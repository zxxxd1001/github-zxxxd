package com.git.zxxxd.domain.controller;

import com.git.zxxxd.domain.dao.PlanBedDao;
import com.git.zxxxd.domain.utils.Person;
import com.git.zxxxd.domain.entity.User;
import com.git.zxxxd.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlanBedDao planBedDao;

    @Value("${age}")
    private Integer age;

    @Autowired
    private Person person;

    @PostMapping("/user")
    public User save(@RequestBody User user) {
        if (userRepository.save(user)) {
            System.out.printf("保存成功:%s", user.getName());
        }
        return user;
    }
    @GetMapping("/hello")
    public String hello() {
        System.out.println(age);
        System.out.println(person);
        planBedDao.getPlanBedResourceLog();
        return "hello spring boot";
    }
}
