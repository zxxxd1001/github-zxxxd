package test.io.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class WriteHandler implements CompletionHandler<Integer, ByteBuffer> {
    private AsynchronousSocketChannel clientChannel;
    private CountDownLatch latch;

    public WriteHandler(AsynchronousSocketChannel clientChannel, CountDownLatch latch) {
        this.clientChannel = clientChannel;
        this.latch = latch;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        //完成全部数据的写入
        if (buffer.hasRemaining()) {
            clientChannel.write(buffer, buffer, this);
        } else {
            //读取数据
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            clientChannel.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer buffer) {
                    buffer.flip();
                    byte[] bytes = new byte[buffer.remaining()];
                    buffer.get(bytes);
                    String body;
                    try {
                        body = new String(bytes, "UTF-8");
                        System.out.println("客户端收到结果:" + body);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.err.println("数据读取失败...");
                    try {
                        clientChannel.close();
                        latch.countDown();
                    } catch (IOException e) {
                    }
                }
            });
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        System.err.println("数据发送失败...");
        try {
            clientChannel.close();
            latch.countDown();
        } catch (IOException e) {
        }
    }
}