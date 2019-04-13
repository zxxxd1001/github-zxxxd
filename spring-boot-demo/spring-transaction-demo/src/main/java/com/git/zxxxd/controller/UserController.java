package com.git.zxxxd.controller;

import com.git.zxxxd.service.NoteBookService;
import com.git.zxxxd.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private NoteBookService noteBookService;

    @Autowired
    private PatientService patientService;

    @RequestMapping("/select-all")
    public List selectAll(){
        List list=noteBookService.selectAll();
        return list;
    }
    @RequestMapping("/insert")
    public void insert(){
        noteBookService.insert();
    }
    @RequestMapping("/delete")
    public void delete(){
        noteBookService.delete();
    }
}
