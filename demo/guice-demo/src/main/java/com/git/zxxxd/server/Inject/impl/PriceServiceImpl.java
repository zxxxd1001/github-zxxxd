package com.git.zxxxd.server.Inject.impl;

import com.git.zxxxd.server.Inject.PriceService;

/**
 * Created by zhangxuedong on 2018/1/17.
 */
public class PriceServiceImpl implements PriceService {
    @Override
    public long getPrice(long orderId) {
        return 345L;
    }
}
