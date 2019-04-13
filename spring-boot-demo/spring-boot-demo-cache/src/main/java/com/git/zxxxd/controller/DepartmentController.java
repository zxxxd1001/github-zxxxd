package com.git.zxxxd.controller;

import com.git.zxxxd.bean.Department;
import com.git.zxxxd.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dept")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/get/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return departmentService.getDeptById(id);
    }

    @DeleteMapping("delete/{id}")
    public int deleteDeptById(@PathVariable("id") Integer id){
        return departmentService.deleteDeptById(id);
    }

    @PostMapping("post")
    public Department insertDeptById(@RequestBody Department d){
        return  departmentService.insertDeptById(d);
    }

    @PutMapping("put")
    public Department updateDeptById(@RequestBody Department d){
        return departmentService.updateDeptById(d);
    }

}
