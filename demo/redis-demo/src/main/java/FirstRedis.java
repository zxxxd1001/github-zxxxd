import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class FirstRedis {

    public static void main(String[] args) {
        demoString();
        demoHash();
        jedisConnectionPoo();
    }

    private static void demoString(){
        Jedis jedis = new Jedis ("192.168.2.75",6379);
        jedis.auth("zxd");
        jedis.connect();//连接
        jedis.set("name", "zhang");
        System.out.println(jedis.get("name"));
        System.out.println(jedis.getrange("name",0,1));
        Set<String> keys = jedis.keys("*"); //列出所有的key
        keys.stream().forEach(i->{
            System.out.println(i);
        });
        Set<String> keyss = jedis.keys("name"); //查找特定的key
        keyss.stream().forEach(i->{
            System.out.println(i);
        });
        jedis.disconnect();//断开连接
        System.out.println("-----------demoString");
    }
    private static void demoHash(){
        Jedis jedis=new Jedis("192.168.2.75",6379);
        jedis.auth("zxd");
        jedis.connect();
        jedis.hset("git","user","zxxxd1001");
        System.out.println(jedis.hget("git","user"));
        jedis.disconnect();
        System.out.println("-----------demoHash");
    }

    private static void jedisConnectionPoo(){
        //连接池配置对象
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        //最大连接数
        jedisPoolConfig.setMaxTotal(30);
        //最大链接空闲时间
        jedisPoolConfig.setMaxIdle(10);

        //jedis连接池对象
        JedisPool jedisPool=new JedisPool(jedisPoolConfig,"192.168.2.75",6379);
        Jedis jedis=null;
        try {
            jedis = jedisPool.getResource();
            jedis.auth("zxd");
            jedis.set("age","20");
            System.out.println(jedis.get("age"));
            System.out.println("-----------jedisConnectionPoo");
        } catch (Exception e) {
            System.out.println("链接redis失败！");
        }finally {
            if(jedis!=null){
                jedis.close();
            }
            if(jedisPool!=null){
                jedisPool.close();
            }
        }

    }
}
