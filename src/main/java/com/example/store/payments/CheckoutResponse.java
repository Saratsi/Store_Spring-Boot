package com.example.store.payments;

import lombok.Data;

@Data
public class CheckoutResponse {
    private Integer orderId;
    private String checkoutUrl;

    public CheckoutResponse(Integer orderId, String checkoutUrl) {
        this.orderId = orderId;
        this.checkoutUrl = checkoutUrl;
    }
}
