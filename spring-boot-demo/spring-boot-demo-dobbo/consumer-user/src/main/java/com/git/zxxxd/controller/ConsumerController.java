package com.git.zxxxd.controller;

import com.git.zxxxd.bean.UserAddress;
import com.git.zxxxd.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("getUserAddressList")
    public String getUserAddressList(){
        consumerService.getUserAddressList();
        return "consumerService";
    }

    @GetMapping("get")
    public List<UserAddress>  get(){
        return consumerService.get();
    }
}
