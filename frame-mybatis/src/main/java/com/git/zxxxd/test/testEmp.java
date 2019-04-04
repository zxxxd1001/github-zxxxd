package com.git.zxxxd.test;

import com.git.zxxxd.common.MyBatisUtils;
import com.git.zxxxd.entity.Emp;
import com.git.zxxxd.entity.EmpOne;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestEmp {
    public static void main(String[] args) {
        SqlSession sqlSession=MyBatisUtils.getSession();
        Emp emp=new Emp(14,"张三",100.00,25);
        sqlSession.insert("insert",emp);
        emp=new Emp(12,"张三",100.00,25);
        sqlSession.insert("insert",emp);

        emp=new Emp(13,"李四",100.00,22);
        sqlSession.insert("insert",emp);

        emp=new Emp(15,"",null,22);
        sqlSession.insert("insertTrim",emp);

        emp.setAge(30);
        sqlSession.update("update",emp);
        emp.setAge(null);
        sqlSession.update("updateSet",emp);
        List<Emp> list=sqlSession.selectList("findAllOrById");
        list.stream().forEach(item->{
            System.out.println(item);
        });

        Emp emp1=sqlSession.selectOne("findAllOrById",13);
        List<Map> listMap=sqlSession.selectList("findMap");
        List list1=sqlSession.selectList("findAs");
        List<EmpOne> list2=sqlSession.selectList("findResultMap");
        List<EmpOne> list3=sqlSession.selectList("findResultMap1");

        sqlSession.delete("delete",14);

        List deleteId=new ArrayList();
        deleteId.add(12);
        deleteId.add(13);
        deleteId.add(15);
        sqlSession.delete("deleteIn",deleteId);

        sqlSession.commit();
        sqlSession.close();
    }
}
