package com.git.zxxxd.controller;

import com.git.zxxxd.bean.Employee;
import com.git.zxxxd.mapper.EmployeeMapper;
import com.git.zxxxd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("get/{id}")
    public Employee getPathById(@PathVariable("id") Integer id){
        return employeeService.getPathById(id);
    }

    @GetMapping("get-json/{id}")
    public Employee getById(@PathVariable("id") Integer id) throws IOException {
        return employeeService.getById(id);
    }

    @PostMapping("post")
    public Employee getById(@RequestBody Employee id){
        return employeeService.insertEmployee(id);
    }

}
