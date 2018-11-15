package netty.nio;

import org.joda.time.DateTime;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by qindongliang on 2018/11/14.
 */
public class TimeClientHandle implements Runnable {

    private  String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile  boolean stop;

    public TimeClientHandle(String host, int port) {
        this.host = host==null?"127.0.0,1":host;
        this.port = port;

        try{
            selector=Selector.open();
            socketChannel=SocketChannel.open();
            socketChannel.configureBlocking(false);

        }catch (Exception e){
            System.exit(1);
        }

    }

    @Override
    public void run() {


        try{
            doConnect();
        }catch (Exception e){
            e.printStackTrace();
        }

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


    }


    private  void doConnect(){

        try {
           if(socketChannel.connect(new InetSocketAddress(host, port))) {
               socketChannel.register(selector, SelectionKey.OP_READ);
               String time=new DateTime(System.currentTimeMillis()).toString("yyyy-MM-dd HH:mm:ss");

               ByteBuffer write=ByteBuffer.allocate(time.length());
               write.put(time.getBytes());
               write.flip();

               socketChannel.write(write);

               if(!write.hasRemaining()){
                   System.out.println(" send success ！   ");
               }
           }else {
               socketChannel.register(selector,SelectionKey.OP_CONNECT);
           }

        }catch (Exception e){
            e.printStackTrace();
        }
    }






}
