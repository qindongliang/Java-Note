package netty.discard_server;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/***
 *  handles a server-side channel
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //discard the recevied data silently.

        System.out.println("execute code.....");

//        ((ByteBuf)(msg)).release();
//        ByteBuf in=(ByteBuf) msg;

        try {
            // Do something with msg
//            while (in.isReadable()){
//                char c=(char)in.readByte();
//                System.out.println(c);
//                System.out.flush();
//            }

//            System.out.println(in.toString(CharsetUtil.UTF_8));//print info
            msg="bb";
//           ChannelFuture cf= ctx.writeAndFlush(Unpooled.copiedBuffer("你好from server...!", CharsetUtil.UTF_8));// sent data to client
           ChannelFuture cf=ctx.writeAndFlush("1134总");
            if(cf.isSuccess()){
                System.out.println("ok");
            }else{
                System.out.println("fail");
            }
//            ctx.writeAndFlush(msg);//Alternatively

        } finally {
//            ReferenceCountUtil.release(msg);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // close the connection when an exception is raised;
        cause.printStackTrace();
        ctx.close();
    }
}
