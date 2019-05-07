package com.git.zxxxd.service;

import com.git.zxxxd.bean.UserAddress;

import java.util.List;

public interface UserService {
    List<UserAddress> getUserAddressList(String userId);
}
