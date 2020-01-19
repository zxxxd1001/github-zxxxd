package com.git.zxxxd.controller;

import com.git.zxxxd.bean.Department;
import com.git.zxxxd.bean.Employee;
import com.git.zxxxd.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("test")
    public void test(){
        Employee d=new Employee();
        d.setLastName("张三");
        d.setGender(123);
        employeeMapper.insertEmp(d);

        Employee ds=new Employee();
        ds.setLastName("王五");
        ds.setGender(1232);
        employeeMapper.insertEmp(ds);

        Map<String, Object> m=new HashMap<>();
        m.put("lastName","李四");
        m.put("gender",20);
        employeeMapper.insertMap(m);
    }

    @GetMapping("get")
    public List get(){
        Employee d=new Employee();
        return employeeMapper.getEmployee(d);
    }

}
