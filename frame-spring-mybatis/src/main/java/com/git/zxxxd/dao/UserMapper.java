package com.git.zxxxd.dao;

import com.git.zxxxd.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectAll();
    User select(@Param("name") String name, @Param("id") String id);
    User selectTwo(Map map);
    List<User> selectAll1();
}
