package com.git.zxxxd.controller;

import com.git.zxxxd.entity.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("emp")
public class EmployeeController {

    @GetMapping("get/{id}")
    public Employee getById(@PathVariable("id") Integer id){
        return null;
    }

    @PostMapping("post")
    public int getById(@RequestBody Employee id){
        return 0;
    }

}
