package com.git.zxxxd.controller;

import com.git.zxxxd.dao.DeptService;
import com.git.zxxxd.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/get/{id}")
    public Dept getDeptById(@PathVariable("id") Integer id){
        return deptService.getById(id);
    }

    @DeleteMapping("delete/{id}")
    public int deleteDeptById(@PathVariable("id") Integer id){
        return deptService.deleteById(id);
    }

    @PostMapping("post")
    public Dept insertDeptById(@RequestBody Dept d){
        deptService.insertDept(d);
        return  d;
    }

}
