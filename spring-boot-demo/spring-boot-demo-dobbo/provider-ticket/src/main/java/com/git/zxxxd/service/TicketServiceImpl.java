package com.git.zxxxd.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Component
@Service //将服务发布出去
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        /**
         * 数据库操作
         */
        return "《厉害了，我的国》";
    }
}
