package netty.nio;

import org.joda.time.DateTime;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * Created by qindongliang on 2018/11/14.
 */
public class MultiplexerTimeServer implements Runnable {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private volatile boolean stop;

    public MultiplexerTimeServer(int port){
        try {
            selector = Selector.open();
            serverSocketChannel=ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            //listen address where local machine and special port
            serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("server port: "+port);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }


    public void stop(){
        this.stop=true;
    }


    @Override
    public void run() {

        while (!stop){

            try {
                int status= selector.select();
                if(status==0) continue;

                Iterator<SelectionKey> ite=selector.selectedKeys().iterator();

                while (ite.hasNext()){

                    SelectionKey key=ite.next();

                    //key无效，就跳过
                    if(!key.isValid()) continue;

                    if(key.isAcceptable()){
                        System.out.println("acceptable");

                        ServerSocketChannel ssc=(ServerSocketChannel)key.channel();
                        SocketChannel sc=ssc.accept();
                        sc.configureBlocking(false);
                        sc.register(selector,SelectionKey.OP_READ);


                    }

                    if(key.isReadable()){
                        System.out.println("read");
                        SocketChannel sc=(SocketChannel) key.channel();
                        ByteBuffer readBuffer=ByteBuffer.allocate(1024);

                        int readBytes=sc.read(readBuffer);
                        if(readBytes>0){
                            readBuffer.flip();
                            byte[] bytes=new byte[readBuffer.remaining()];
                            readBuffer.get(bytes);
                            String body=new String(bytes,"UTF-8");
                            System.out.println("receive data："+body);

                            String time=new DateTime(System.currentTimeMillis()).toString("yyyy-MM-dd HH:mm:ss");

                            ByteBuffer write=ByteBuffer.allocate(time.length());
                            write.put(time.getBytes());
                            write.flip();

                            sc.write(write);


                        }else{
                            key.cancel();
                            sc.close();
                        }
                    }

                    if(key.isWritable()){
                        System.out.println("write");
                    }



                    ite.remove();

                }


            }catch (Exception e){
                e.printStackTrace();
            }

        }

        try {
            selector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
