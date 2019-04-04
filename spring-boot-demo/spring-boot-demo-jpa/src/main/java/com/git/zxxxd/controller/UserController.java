package com.git.zxxxd.controller;

import com.git.zxxxd.dao.UserService;
import com.git.zxxxd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("get/{id}")
    public User getById(@PathVariable("id") Integer id){
        return userService.getById(id);
    }

    @PostMapping("post")
    public User insertUser(@RequestBody User id){
        userService.insertUser(id);
        return id;
    }

}
