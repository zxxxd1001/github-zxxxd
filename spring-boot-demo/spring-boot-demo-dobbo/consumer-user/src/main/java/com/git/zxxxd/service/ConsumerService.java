package com.git.zxxxd.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.git.zxxxd.bean.UserAddress;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 		1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 		2）、配置服务提供者
 *
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 * @author lfy
 *
 */
@Service
public class ConsumerService {

    @Reference
    TicketService ticketService;

    /**
     * 参数配置覆盖关系
     *  1）、精确优先 (方法级优先，接口级次之，全局配置再次之)
     *  2）、消费者设置优先(如果级别一样，则消费方优先，提供方次之)
     *
     * timeout="0" 默认是1000ms
     * retries="":重试次数，不包含第一次调用，0代表不重试
     * 幂等（设置重试次数）【查询、删除、修改】、非幂等（不能设置重试次数）【新增】
     */
    @Reference(interfaceClass = UserService.class,timeout = 5000,retries=3,version = "2.0.0",check=false,stub="true")
    UserService userService;

    @Reference(timeout = 5000,version = "1.0.0",check=false,stub = "com.git.zxxxd.service.UserServiceStub")
    UserService us;

//    @Reference(url = "localhost:20882",version = "1.0.0",timeout = 5000)//dubbo直链接
//    UserService us;

    public void hello(){
        String ticket = ticketService.getTicket();
        System.out.println("买到票了："+ticket);
    }

    public void getUserAddressList(){
        List<UserAddress> addressList = userService.getUserAddressList("2");
        for (UserAddress userAddress : addressList) {
            System.out.println(userAddress);
        }
        addressList=us.getUserAddressList("1");
        for (UserAddress userAddress : addressList) {
            System.out.println(userAddress);
        }
    }


    public List<UserAddress> get(){
//      return us.getUserAddressList("1");
      return  userService.getUserAddressList("2");
    }

}
