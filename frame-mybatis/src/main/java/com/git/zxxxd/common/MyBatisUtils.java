package com.git.zxxxd.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtils {
    public static SqlSession getSession(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        InputStream is=MyBatisUtils.class.getClassLoader().getResourceAsStream("mybatis/SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(is);
        return sqlSessionFactory.openSession();
    }
}
