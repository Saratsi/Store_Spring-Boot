package com.example.store.payments;

import com.example.store.orders.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PaymentResult {
    private Integer orderId;
    private PaymentStatus paymentStatus;
}
