package com.git.zxxxd.controller;

import com.git.zxxxd.bean.Employee;
import com.git.zxxxd.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("get/{id}")
    public Employee getById(@PathVariable("id") Integer id){
        return employeeMapper.getById(id);
    }

    @PostMapping("post")
    public int getById(@RequestBody Employee id){
        return employeeMapper.insertEmployee(id);
    }

}
