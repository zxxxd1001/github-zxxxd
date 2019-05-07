package com.git.zxxxd.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.git.zxxxd.bean.UserAddress;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Service(interfaceClass = UserService.class ,timeout = 1000,version = "2.0.0")
public class UserServiceTwoImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceTwoImpl.....new...");
        // TODO Auto-generated method stub
        UserAddress address1 = new UserAddress(3, "山西省晋中市榆次区", "3", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(4, "山西省太原市", "4", "王老师", "010-56253825", "N");

        /**
         * 测试服务容错 发生错误时自动重试其它服务器
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */
        return Arrays.asList(address1,address2);
    }
}
