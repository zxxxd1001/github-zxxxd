import redis.clients.jedis.Jedis;

import java.util.Set;

public class FirstRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis ("192.168.1.10",6379);
        jedis.connect();//连接
        jedis.set("name", "我");
        System.out.println(jedis.get("name"));
        Set<String> keys = jedis.keys("*"); //列出所有的key
        keys.stream().forEach(i->{
            System.out.println(i);
        });
        Set<String> keyss = jedis.keys("name"); //查找特定的key
        keyss.stream().forEach(i->{
            System.out.println(i);
        });
        jedis.disconnect();//断开连接
    }
}
