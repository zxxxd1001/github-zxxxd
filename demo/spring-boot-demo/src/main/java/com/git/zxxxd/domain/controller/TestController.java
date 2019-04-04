package com.git.zxxxd.domain.controller;

import com.git.zxxxd.domain.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping("test")
@RestController
public class TestController {
    @RequestMapping("test")
    public User test(@RequestBody User user){
        return user;
    }
    @RequestMapping("testTwo")
    public List testTwo(@RequestBody List<Object> list){
        return list;
    }
    @RequestMapping("testThree")
    public Map testThree(@RequestBody Map map){
        return map;
    }
    @RequestMapping("testList")
    public List<User> testList(@RequestBody List<User> map){
        return map;
    }
    @RequestMapping("testMap")
    public List<Map> testMap(@RequestBody List<Map> map){
        return map;
    }
    @RequestMapping("testSet")
    public Set testTwo(@RequestBody Set<Object> set){
        return set;
    }
}
