package com.git.zxxxd.test;

import com.git.zxxxd.dao.NoteBookMapper;
import com.git.zxxxd.dao.UserMapper;
import com.git.zxxxd.entity.NoteBook;
import com.git.zxxxd.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TestDao {
    public static void main(String[] args) {
        ApplicationContext application=new ClassPathXmlApplicationContext("classpath:spring-application.xml");
        NoteBookMapper noteBookMapper=application.getBean("noteBookMapper",NoteBookMapper.class);
        List<NoteBook> noteBookList=noteBookMapper.selectAll();
        UserMapper userMapper=application.getBean("userMapper",UserMapper.class);
        List<User> userList=userMapper.selectAll();
        noteBookMapper.deleteById("123");
        NoteBook noteBook=new NoteBook();
        noteBook.setCn_notebook_id("123");
        noteBook.setCn_user_id("12");
        noteBook.setCn_notebook_type_id("1234");
        noteBook.setCn_notebook_desc("desc");
        noteBook.setCn_notebook_name("name");
        noteBook.setCn_notebook_createtime(new Timestamp(new Date().getTime()));
        noteBookMapper.insertAll(noteBook);
        System.out.println("");
    }
}
