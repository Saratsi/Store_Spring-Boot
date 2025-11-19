package com.example.store.orders;

import com.example.store.carts.Cart;
import com.example.store.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orders", schema = "store")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Column(name = "created_at",insertable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<OrderItem> orderItems = new LinkedHashSet<>();

    public static Order createOrderFromCart(Cart cart, User customer){
        Order order = new Order();
        order.setTotalPrice(cart.getTotalPrice());
        order.setStatus(PaymentStatus.PENDING);
        order.setCustomer(customer);

        cart.getCartItems().forEach(item -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(item.getProduct());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setTotalPrice(item.getTotalPrice());
            orderItem.setUnitPrice(item.getProduct().getPrice());
            order.getOrderItems().add(orderItem);
        });

        return order;
    }

    public boolean isPlacedBy(User customer){
        return  this.getCustomer().getId().equals(customer.getId());
    }

}