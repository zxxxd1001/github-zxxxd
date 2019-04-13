package com.git.zxxxd.controller;

import com.git.zxxxd.bean.Department;
import com.git.zxxxd.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dept")
public class DepartmentController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/get/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return deptService.getDeptById(id);
    }

    @DeleteMapping("delete/{id}")
    public int deleteDeptById(@PathVariable("id") Integer id){
        return deptService.deleteDeptById(id);
    }

    @PostMapping("post")
    public Department insertDeptById(@RequestBody Department d) throws Exception {
        deptService.insertDeptById(d);
        return  d;
    }

    @PutMapping("put")
    public int updateDeptById(Department d){
        return deptService.updateDeptById(d);
    }

}
