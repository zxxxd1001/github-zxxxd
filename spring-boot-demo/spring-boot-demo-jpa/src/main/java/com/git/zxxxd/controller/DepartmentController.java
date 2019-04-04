package com.git.zxxxd.controller;

import com.git.zxxxd.entity.Department;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dept")
public class DepartmentController {


    @GetMapping("/get/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return null;
    }

    @DeleteMapping("delete/{id}")
    public int deleteDeptById(@PathVariable("id") Integer id){
        return 0;
    }

    @PostMapping("post")
    public Department insertDeptById(@RequestBody Department d){
        return  d;
    }

}
