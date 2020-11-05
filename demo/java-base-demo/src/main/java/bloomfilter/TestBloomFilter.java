package bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import me.ttting.common.hash.BloomFilterStrategies;
import me.ttting.common.hash.JedisBitArray;
import redis.clients.jedis.JedisPool;

/**
 * https://juejin.im/post/6844903982209449991
 */
public class TestBloomFilter {
    private static int total = 1000000;
    private static BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total);
//    private static BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total, 0.001);

    /**
     * BloomFilter调用create方法会传入三个参数
     * 1 funnel
     * 2 expectedInsertions 预故插入的数量
     * 3 fpp 假阳性的概率
     */
    public static void main(String[] args) {
//        bloomFilter();
//        testGuavaBloomFilter();
        testGuavaBloomFilter2();
    }

    public static void bloomFilter(){
        // 初始化1000000条数据到过滤器中
        for (int i = 0; i < total; i++) {
            bf.put(i);
        }

        // 匹配已在过滤器中的值，是否有匹配不上的
        for (int i = 0; i < total; i++) {
            if (!bf.mightContain(i)) {
                System.out.println("有坏人逃脱了~~~");
            }
        }

        // 匹配不在过滤器中的10000个值，有多少匹配出来
        int count = 0;
        for (int i = total; i < total + 10000; i++) {
            if (bf.mightContain(i)) {
                count++;
            }
        }
        System.out.println("误伤的数量：" + count);
    }

    public static void testGuavaBloomFilter() {
        BloomFilter<String> bloomFilter = BloomFilter.create((Funnel<String>) (from, into) -> {
            into.putString(from, Charsets.UTF_8);
        }, 100_0000, 0.000_0001);

        String testElement1 = "123";
        String testElement2 = "456";
        String testElement3 = "789";

        bloomFilter.put(testElement1);
        bloomFilter.put(testElement2);
        System.out.println(bloomFilter.mightContain(testElement1));
        System.out.println(bloomFilter.mightContain(testElement2));
        System.out.println(bloomFilter.mightContain(testElement3));
    }

    /**
     * https://www.jianshu.com/p/cae51ad2486c
     *
     * 示例代码
     * https://github.com/ttting/redis-bloomfilter
     */
    public static void testGuavaBloomFilter2(){
        JedisPool jedisPool = new JedisPool("192.168.29.52", 6379);
        JedisBitArray jedisBitArray = new JedisBitArray(jedisPool, "test-1");
        me.ttting.common.hash.BloomFilter<String> bloomFilter =me.ttting.common.hash.BloomFilter.create(
                (Funnel<String>) (from, into) ->into.putString(from, Charsets.UTF_8),
                10,
                0.0000001,
                BloomFilterStrategies.MURMUR128_MITZ_32,
                jedisBitArray);

        bloomFilter.put("111");
        bloomFilter.put("222");
        System.out.println(bloomFilter.mightContain("111"));
        System.out.println(bloomFilter.mightContain("222"));
        System.out.println(bloomFilter.mightContain("333"));

    }
}
