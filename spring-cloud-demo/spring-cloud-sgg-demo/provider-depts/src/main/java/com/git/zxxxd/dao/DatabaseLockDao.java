package com.git.zxxxd.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface DatabaseLockDao {
    @Insert("insert methodLock (method_name) VALUES(#{key})")
    int insertLock(String key);
    @Delete("delete from methodLock where method_name=#{key}")
    int deleteLock(String key);
}
