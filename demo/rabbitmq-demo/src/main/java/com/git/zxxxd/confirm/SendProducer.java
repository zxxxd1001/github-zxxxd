package com.git.zxxxd.confirm;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SendProducer {
    public static void main(String[] args) throws Exception {
        SendProducer s = new SendProducer();
//        s.producer();
//        s.producer1();
//        s.producer2();
        s.producer3();
    }

    private void producer3() throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //指定我们的消息投递模式: 消息的确认模式
        channel.confirmSelect();
        //发送一条消息
        channel.basicPublish("test_confirm_exchange", "confirm.save", null, "Hello RabbitMQ Send confirm message!".getBytes());

        //添加一个确认监听
        channel.addConfirmListener(new ConfirmListener() {
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.err.println("-------no ack!-----------");
            }
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.err.println("-------ack!-----------");
            }
        });
    }

    private void producer2() throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-max-length", 10);
        //创建队列
        channel.queueDeclare("test-listener-confirm", true, false, true, args);

        channel.confirmSelect();
        String str="hello,addConfirmListener,ConfirmListener";
        for (int i=0;i<20;i++) {
            channel.basicPublish("", "test-listener-confirm", MessageProperties.PERSISTENT_BASIC, str.getBytes("UTF-8"));
        }
        long start = System.currentTimeMillis();
        channel.addConfirmListener(new ConfirmListener() {
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("nack: deliveryTag = " + deliveryTag + " multiple: " + multiple);
            }
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("ack: deliveryTag = " + deliveryTag + " multiple: " + multiple);
            }
        });
        System.out.println("执行waitForConfirmsOrDie耗费时间: " + (System.currentTimeMillis() - start) + "ms");
//        channel.close();
//        connection.close();
    }

    /**
     * 普通confirm模式，每发送一条消息，
     * 调用waitForConfirms()方法等待服务端confirm，
     * 这实际上是一种串行的confirm，
     * 每publish一条消息之后就等待服务端confirm，basicQos
     * 如果服务端返回false或者超时时间内未返回，客户端进行消息重传；
     */
    public void producer() throws Exception {
        Connection conn = ConnectionUtils.getConnection();
        // 创建信道
        Channel channel = conn.createChannel();
        // 声明队列
        channel.queueDeclare("test-easy-confirm", false, false, false, null);
        // 开启发送方确认模式

        channel.confirmSelect();
        String message = "hello,confirm";

        channel.basicPublish("", "test-easy-confirm", null, message.getBytes("UTF-8"));
        if (channel.waitForConfirms()) {
            System.out.println("消息发送成功");
        } else {
            System.out.println("消息发送失败");
        }
        channel.close();
        conn.close();
    }

    /**
     * 批量confirm模式，每发送一批消息之后，调用waitForConfirms()方法，
     * 等待服务端confirm，这种批量确认的模式极大的提高了confirm效率，
     * 但是如果一旦出现confirm返回false或者超时的情况，
     * 客户端需要将这一批次的消息全部重发，这会带来明显的重复消息，
     * 如果这种情况频繁发生的话，效率也会不升反降；
     */
    public void producer1() throws Exception {
        Connection conn = ConnectionUtils.getConnection();
        // 创建信道
        Channel channel = conn.createChannel();
        // 声明队列
        channel.queueDeclare("test-easy-confirm", false, false, false, null);
        // 开启发送方确认模式
        channel.confirmSelect();
        String message = "hello,confirm";
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("", "test-easy-confirm", null, message.getBytes("UTF-8"));
        }
        if (channel.waitForConfirms()) {
            System.out.println("消息发送成功");
        } else {
            System.out.println("消息发送失败");
        }

        /**
         *  waitForConfirmsOrDie处会造成当前程序的阻塞
         *  该方法会等到最后一条消息得到确认或者得到nack才会结束
         *
         */
//        long start = System.currentTimeMillis();
//        channel.waitForConfirmsOrDie();
//        System.out.println("执行waitForConfirmsOrDie耗费时间: "+(System.currentTimeMillis()-start)+"ms");

        channel.close();
        conn.close();
    }
}
