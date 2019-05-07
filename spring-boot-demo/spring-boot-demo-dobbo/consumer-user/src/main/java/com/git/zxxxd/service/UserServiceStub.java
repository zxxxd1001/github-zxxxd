package com.git.zxxxd.service;

import com.git.zxxxd.bean.UserAddress;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 本地存根
 * Stub 可以决定要不要去调 Proxy。
 */
public class UserServiceStub implements UserService {
    private final UserService userService;


    /**
     * 传入的是userService远程的代理对象
     * @param userService
     */
    public UserServiceStub(UserService userService) {
        super();
        this.userService = userService;
    }


    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        // 在调用前
        System.out.println("UserServiceStub.....");
        if(!StringUtils.isEmpty(userId)) {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
