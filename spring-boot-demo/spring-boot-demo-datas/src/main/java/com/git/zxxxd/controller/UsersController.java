package com.git.zxxxd.controller;

import com.git.zxxxd.bean.Users;
import com.git.zxxxd.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 127.0.0.1:8082/save
     {
     "id":2,
     "name":"张三2",
     "age":18,
     "sex":0,
     "addr":"北京"
     }
     */
    @PostMapping("save")
    public Users save(@RequestBody Users users){
        return usersService.save(users);
    }

    /**
     * 127.0.0.1:8082/get?id=2
     */
    @GetMapping("get")
    public Users get(Integer id){
        return usersService.get(id);
    }

    /**
     * 127.0.0.1:8082/save-plus
     {
     "id":2,
     "name":"张三2",
     "age":18,
     "sex":0,
     "addr":"北京"
     }
     */
    @PostMapping("save-plus")
    public Users savePlus(@RequestBody Users users){
        return usersService.savePlus(users);
    }

    /**
     * 127.0.0.1:8082/get-plus?id=2
     */
    @GetMapping("get-plus")
    public Users getPlus(Integer id){
        return usersService.getPlus(id);
    }
}
