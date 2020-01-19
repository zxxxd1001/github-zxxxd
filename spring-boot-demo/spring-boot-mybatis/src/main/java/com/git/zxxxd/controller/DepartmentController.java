package com.git.zxxxd.controller;

import com.git.zxxxd.bean.Department;
import com.git.zxxxd.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dept")
public class DepartmentController {
    private static final Logger logger =LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DeptService deptService;

    @GetMapping("/get/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return deptService.getDeptById(id);
    }
    @GetMapping("/gets/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return deptService.getDept(id);
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

    @GetMapping("testRollBackFor")
    public int test(){
//        return deptService.test();

        try {
            deptService.abstractTest();
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
//           e.printStackTrace();
        }
        return 0;
    }

}
