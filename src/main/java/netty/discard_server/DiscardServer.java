package netty.discard_server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class DiscardServer {

    private  int port;

    public DiscardServer(int port) {
        this.port = port;
    }


    public void run(){

        //accept incoming connections
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        //after boss accepts the connection and registers the accepted connection to the worker.
        //handles the traffic of the accepted connection
        EventLoopGroup workerGroup=new NioEventLoopGroup();

        try{

            ServerBootstrap b=new ServerBootstrap();
            b.group(bossGroup,workerGroup);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    //fix string use decoder and encoder
                    socketChannel.pipeline().addLast(new StringDecoder()).addLast(new StringEncoder()).addLast(new DiscardServerHandler())
                    ;
                }
            });
            b.option(ChannelOption.SO_BACKLOG,128);
            b.childOption(ChannelOption.SO_KEEPALIVE,true);

            //bind and start to accept incoming connections
            ChannelFuture f=b.bind(port).sync();
            System.out.println("server is running....");
            // wait until the server socket is closed
            // in this example, this does not happen,but you can do that to gracefully
            //shut down your server.
            f.channel().closeFuture().sync();




        }catch (Exception e){
            e.printStackTrace();
        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }


    }



    public static void main(String[] args) {

        int port=8080;

        new DiscardServer(port).run();


    }

}
