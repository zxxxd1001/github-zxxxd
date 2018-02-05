package com.git.zxxxd.server.Inject.impl;

import com.git.zxxxd.server.Inject.OrderService;
import com.git.zxxxd.server.Inject.PriceService;
import com.git.zxxxd.server.Inject.PaymentService;

import javax.inject.Inject;

public class OrderServiceImpl implements OrderService {

    private final PriceService priceService;
    private final PaymentService paymentService;
    private final SessionManager sessionManager;

    private Long ordersPaid=0L;

    @Inject
    public OrderServiceImpl(PriceService priceService, PaymentService paymentService, SessionManager sessionManager) {
        this.priceService = priceService;
        this.paymentService = paymentService;
        this.sessionManager = sessionManager;
    }
    public void sendToPayment(long orderId){
        long price=priceService.getPrice(orderId);
        paymentService.pay(orderId,price,sessionManager.getSessionId());
        ordersPaid=ordersPaid+1;
        throw new RuntimeException("orderId:"+orderId+",price:"+price+",ordersPaid:"+ordersPaid);
    }
}
