package com.git.zxxxd.server.Inject;

/**
 * Created by zhangxuedong on 2018/1/17.
 */
public interface PaymentService {
    void pay(long orderId, long price, Long ordersPaid);
}
