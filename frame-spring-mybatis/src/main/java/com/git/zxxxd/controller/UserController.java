package com.git.zxxxd.controller;

import com.git.zxxxd.dao.NoteBookMapper;
import com.git.zxxxd.entity.NoteBook;
import com.git.zxxxd.service.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private NoteBookService noteBookService;

    @RequestMapping("/select-all")
    public List selectAll(){
        return noteBookService.selectAll();
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
