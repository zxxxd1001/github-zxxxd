package com.git.zxxxd.controller;

import com.git.zxxxd.bean.Department;
import com.git.zxxxd.mapper.DepartmentMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dept")
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/get/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @Delete("delete/{id}")
    public int deleteDeptById(@PathVariable("id") Integer id){
        return departmentMapper.deleteDeptById(id);
    }

    @PostMapping("post")
    public Department insertDeptById(@RequestBody Department d){
        departmentMapper.insertDeptById(d);
        return  d;
    }

    @PutMapping("put")
    public int updateDeptById(Department d){
        return departmentMapper.updateDeptById(d);
    }

}
