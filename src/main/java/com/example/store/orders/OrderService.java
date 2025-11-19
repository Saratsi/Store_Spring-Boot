package com.example.store.orders;

import com.example.store.authentication.AuthenticationService;
import com.example.store.users.User;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {
    private final AuthenticationService authenticationService;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDto> getAllOrders(){
        User user = authenticationService.getCurrentUser();
        List<Order> orders = orderRepository.getOrdersByCustomer(user);
        return orders.stream().map(order -> orderMapper.toDto(order)).toList();
    }

    public OrderDto getOrder(Integer orderId) {
        Order oder = orderRepository.getOrderWithItems(orderId).orElse(null);
        if(oder == null){
            throw new OrderNotFoundException();
        }

        User user = authenticationService.getCurrentUser();
        if(!oder.isPlacedBy(user)){
            throw new AccessDeniedException("Access denied");
        }
        return orderMapper.toDto(oder);
    }
}
