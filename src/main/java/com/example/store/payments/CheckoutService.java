package com.example.store.payments;

import com.example.store.carts.Cart;
import com.example.store.orders.Order;
import com.example.store.carts.CartEmptyException;
import com.example.store.carts.CartNotFoundException;
import com.example.store.carts.CartRepository;
import com.example.store.orders.OrderRepository;
import com.example.store.authentication.AuthenticationService;
import com.example.store.carts.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class CheckoutService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final AuthenticationService authenticationService;
    private final CartService cartService;
    private final PaymentGateway paymentGateway;


    @Transactional
    public CheckoutResponse checkout(CheckoutRequest checkoutRequest) {
        Cart cart = cartRepository.getCartWithItems(checkoutRequest.getCartId()).orElse(null);
        if(cart == null){
            throw new CartNotFoundException();
        }

        if(cart.isEmpty()){
            throw new CartEmptyException();
        }

        Order order = Order.createOrderFromCart(cart, authenticationService.getCurrentUser());

        orderRepository.save(order);

        try{
            CheckoutSession session = paymentGateway.createCheckoutSession(order);

            cartService.clearCart(cart.getId());

            return new CheckoutResponse(order.getId(), session.getCheckoutUrl());
        }
        catch (PaymentException e){
            orderRepository.delete(order);
            throw e;
        }
    }

    public void handleWebhookEvent(WebhookRequest webhookRequest){
        paymentGateway.parseWebhookRequest(webhookRequest)
                .ifPresent(paymentResult -> {
                    Order order = orderRepository.findById(paymentResult.getOrderId()).orElseThrow();
                    order.setStatus(paymentResult.getPaymentStatus());
                    orderRepository.save(order);
                });
    }
}
