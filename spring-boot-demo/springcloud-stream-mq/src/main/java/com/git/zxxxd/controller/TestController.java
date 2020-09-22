package com.git.zxxxd.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.git.zxxxd.stream.RabbitmqSender;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private RabbitmqSender rabbitmqSender;
    @GetMapping("test")
    public void test(){
        for(int i = 0; i < 1; i ++){
            try {
                Map<String, Object> properties = new HashMap<String, Object>();
                properties.put("SERIAL_NUMBER", "12345");
                properties.put("BANK_NUMBER", "abc");
                properties.put("PLAT_SEND_TIME", DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
                rabbitmqSender.sendMessage("Hello, I am amqp sender num :" + i, properties);

            } catch (Exception e) {
                System.out.println("--------error-------");
                e.printStackTrace();
            }
        }
        //TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
