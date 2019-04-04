package com.git.zxxxd.service;

import com.git.zxxxd.dao.NoteBookMapper;
import com.git.zxxxd.entity.NoteBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class NoteBookService {
    @Autowired
    private NoteBookMapper noteBookMapper;

    public List selectAll(){
        return noteBookMapper.selectAll();
    }

//    @Transactional
    public void insert(){
        noteBookMapper.deleteById("123");
        NoteBook noteBook=new NoteBook();
        noteBook.setCn_notebook_id("123");
        noteBook.setCn_user_id("12");
        noteBook.setCn_notebook_type_id("1234");
        noteBook.setCn_notebook_desc("desc");
        noteBook.setCn_notebook_name("name");
        noteBook.setCn_notebook_createtime(new Timestamp(new Date().getTime()));
        noteBookMapper.insertAll(noteBook);
    }
//    @Transactional
    public void delete(){
        noteBookMapper.deleteById("123");
    }
}
