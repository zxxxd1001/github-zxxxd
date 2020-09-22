package netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

import java.util.concurrent.TimeUnit;


public class OutBoundHandlerA extends ChannelHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        super.write(ctx,msg,promise);
        System.out.println("OutBoundHandlerA: " + msg);
    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx)throws Exception {
        super.handlerAdded(ctx);
        //定时
        ctx.executor().schedule(() -> {
            ctx.channel().write("hello world");
            ctx.write("hello world");
        }, 3, TimeUnit.SECONDS);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        System.out.println("OutBoundHandlerA-channelRead："+msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx,cause);
        System.out.println("OutBoundHandlerA.exceptionCaught()");
    }
}
