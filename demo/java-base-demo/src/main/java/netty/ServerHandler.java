package netty;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;

public class ServerHandler extends ChannelHandlerAdapter {
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //客户端与服务端创建连接的时候调用
        System.out.println("channelActive");
        ctx.channel().pipeline().fireChannelRead("hello world");
    }

    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
        System.out.println("handlerAdded");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx,cause);
        System.out.println("exceptionCaught");
        //工程出现异常的时候调用
        cause.printStackTrace();
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ServerHandler-channelRead："+msg);
        throw new BusinessException("from OutBoundHandlerB");
    }
}
