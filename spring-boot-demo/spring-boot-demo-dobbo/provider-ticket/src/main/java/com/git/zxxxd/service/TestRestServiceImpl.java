package com.git.zxxxd.service;

/**
import com.alibaba.dubbo.config.annotation.Service;
import com.git.zxxxd.bean.UserAddress;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


 * 不能使用

@Service
@Path("users")
public class TestRestServiceImpl implements TestRestService {

    @GET
    @Path("register")
    @Consumes({MediaType.APPLICATION_JSON})
    public String registerUser(UserAddress user) {
        return "asdasd";
    }
}
 */
