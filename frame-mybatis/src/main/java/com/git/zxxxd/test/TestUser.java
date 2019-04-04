package com.git.zxxxd.test;

import com.git.zxxxd.common.MyBatisUtils;
import com.git.zxxxd.dao.NoteBook;
import com.git.zxxxd.dao.UserMapper;
import com.git.zxxxd.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUser {
    public static void main(String[] args) {
        SqlSession sqlSession=MyBatisUtils.getSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        NoteBook noteBook=sqlSession.getMapper(NoteBook.class);

        List userList=userMapper.selectAll();
        List userList1=userMapper.selectAll1();
        List noteBookList=noteBook.selectAll();
        User user=userMapper.select("zhouj","03590914-a934-4da9-ba4d-b41799f917d1");
        Map map=new HashMap();
        map.put("name","zhouj");
        map.put("id","03590914-a934-4da9-ba4d-b41799f917d1");
        User user1=userMapper.selectTwo(map);


        sqlSession.commit();
        sqlSession.close();
    }
}
