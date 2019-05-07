package com.git.zxxxd.work;

import org.junit.Test;

/**
 * 轮训分发：一个生产者，两个消费者
 *     |-->C1
 * p-->|
 *     |-->C2
 *
 * 消费者1和消费者2处理的消息是一样的。
 * 消费者1：偶数
 * 消费者2：奇数
 * 这种方式叫做轮训分发（round-robin），结果就是不管谁忙活着谁清闲着，都不会多给一个消息，
 * 任务消息按照你一个，我一个的方式消费，两个消费者公平的拿到相同数量的消息，只是时间先后而已。
 *
 * 公平分发：程序处理快的，就要多干点，处理慢的就想干也干不了的，就是要充分利用消费者
 * 注意事项：
 *  使用公平分发，必须关闭自动应答ack，然后改成手动应答方式。
 */
public class TestWork {
    @Test
    public void sender() throws Exception {
        new SendProducer().producer();
    }

    //轮训分发
    @Test
    public void consumer1() throws Exception{
        new WorkConsumer().consumer("消费者1",2000,true);
    }
    //轮训分发
    @Test
    public void consumer2() throws Exception{
        new WorkConsumer().consumer("消费者2",1000,true);
    }

    //公平分发
    @Test
    public void consumer3() throws Exception{
        new WorkConsumer().consumer("消费者3",2000,false);
    }
    //公平分发
    @Test
    public void consumer4() throws Exception{
        new WorkConsumer().consumer("消费者4",1000,false);
    }
}
