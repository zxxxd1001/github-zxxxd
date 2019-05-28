package com.git.zxxxd.service.impl;

import com.git.zxxxd.dao.DeptsDao;
import com.git.zxxxd.database.lock.DataBaseLock;
import com.git.zxxxd.entity.Depts;
import com.git.zxxxd.redis.RedisLock;
import com.git.zxxxd.service.DeptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptsService {

    @Autowired
    DeptsDao deptDao;

    @Autowired
    RedisLock redisLock;

    @Autowired
    DataBaseLock dataBaseLock;

    @Override
    public boolean add(Depts depts) {
      return   deptDao.addDept(depts);
    }

    @Override
    public Depts findById(Long deptNo) {
        return  deptDao.findById(deptNo);
    }

    @Override
    public List<Depts> findAll() {
        return deptDao.findAll();
    }


    public void updateById(Depts deptEntity) {
        testRedisLock(deptEntity);
//        testDatebaseLock(deptEntity);
    }

    private void testRedisLock(Depts deptEntity){
        if(redisLock.lock(deptEntity.getDeptNo().toString(),(new Date().getTime()+100000)+"")) {
            deptDao.updateById(deptEntity);
            redisLock.unlock(deptEntity.getDeptNo().toString(), (new Date().getTime()+100000)+"");
        }else{
            System.out.println("获取锁失败！");
        }
    }

    private void testDatebaseLock(Depts deptEntity){
        if(dataBaseLock.lock(deptEntity.getDeptNo().toString())) {
            deptDao.updateById(deptEntity);
            dataBaseLock.unlock(deptEntity.getDeptNo().toString());
        }else{
            System.out.println("获取锁失败！");
        }
    }
}