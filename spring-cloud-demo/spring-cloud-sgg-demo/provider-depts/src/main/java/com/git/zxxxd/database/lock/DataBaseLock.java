package com.git.zxxxd.database.lock;

import com.git.zxxxd.dao.DatabaseLockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 优点：简单，易于理解
 *
 * 缺点：会有各种各样的问题（操作数据库需要一定的开销，使用数据库的行级锁并不一定靠谱，性能不靠谱）
 *  程序链接的数据库必须是一个
 */
@Component
public class DataBaseLock {

    /**
     * 利用主键唯一的特性，如果有多个请求同时提交到数据库的话，数据库会保证只有一个操作可以成功，
     * 那么我们就可以认为操作成功的那个线程获得了该方法的锁，当方法执行完毕之后，想要释放锁的话，删除这条数据库记录即可。
     */

    @Autowired
    DatabaseLockDao databaseLockDao;

    /**
     * 加锁
     * @param key
     * @return
     */
    public boolean lock(String key) {
        try {
            databaseLockDao.insertLock(key);
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 解锁
     * @param key
     */
    public void unlock(String key) {
        databaseLockDao.deleteLock(key);
    }
}
