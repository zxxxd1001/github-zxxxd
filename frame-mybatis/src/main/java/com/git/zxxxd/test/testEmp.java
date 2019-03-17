package com.git.zxxxd.test;

import com.git.zxxxd.common.MyBatisUtils;
import com.git.zxxxd.entity.Emp;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class testEmp {
    public static void main(String[] args) {
        SqlSession sqlSession=MyBatisUtils.getSession();
        Emp emp=new Emp(14,"张三",100.00,25);
        sqlSession.insert("insert",emp);
//        emp=new Emp(12,"张三",100.00,25);
//        sqlSession.insert("insert",emp);

//        emp=new Emp(13,"李四",100.00,22);
//        sqlSession.insert("insert",emp);

        emp.setAge(30);
        sqlSession.update("update",emp);
        List<Emp> list=sqlSession.selectList("findAll");
        list.stream().forEach(item->{
            System.out.println(item);
        });

        Emp emp1=sqlSession.selectOne("findById",13);

        sqlSession.delete("delete",14);

        sqlSession.commit();
        sqlSession.close();
    }
}
