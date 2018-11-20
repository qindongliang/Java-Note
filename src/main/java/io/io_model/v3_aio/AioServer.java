package io.io_model.v3_aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class AioServer {

    public AioServer(){
         AsynchronousServerSocketChannel serverChannel;
         AsynchronousSocketChannel clientChannel;
        try {
            serverChannel = AsynchronousServerSocketChannel.open();
            InetSocketAddress hostAddress = new InetSocketAddress( 8080);
            serverChannel.bind(hostAddress);
            System.out.println("Server  start ....");
            while (true) {

                serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

                    @Override
                    public void completed(AsynchronousSocketChannel result, Object attachment) {
                        if (serverChannel.isOpen())
                            serverChannel.accept(null, this);
                        try {
                            System.out.println(Thread.currentThread().getName()+"-from ip: "+result.getRemoteAddress());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if ((result != null) && (result.isOpen())) {
                            ReadWriteHandler handler = new ReadWriteHandler(result);
                            ByteBuffer buffer = ByteBuffer.allocate(32);
                            Map<String, Object> readInfo = new HashMap<>();
                            readInfo.put("action", "read");
                            readInfo.put("buffer", buffer);
                            result.read(buffer, readInfo, handler);
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {
                        // process error
                    }
                });
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class ReadWriteHandler implements CompletionHandler<Integer, Map<String, Object>> {


        private AsynchronousSocketChannel clientChannel;

        public ReadWriteHandler(AsynchronousSocketChannel clientChannel) {
            this.clientChannel = clientChannel;
        }

        @Override
        public void completed(Integer result, Map<String, Object> attachment) {

            Map<String, Object> actionInfo = attachment;
            String action = (String) actionInfo.get("action");
            System.out.println(Thread.currentThread().getName()+"-当前的动作："+action);
            if ("read".equals(action)) {
                ByteBuffer buffer = (ByteBuffer) actionInfo.get("buffer");
                buffer.flip();
                actionInfo.put("action", "write");
                String msg = new String(buffer.array()).toString().trim();
                System.out.println("客户端消息："+msg);
                buffer.clear();
                buffer.put( ("server->"+msg+"\n").getBytes(Charset.forName("UTF-8")));
                buffer.flip();
                clientChannel.write(buffer, actionInfo, this);

            } else if ("write".equals(action)) {
                ByteBuffer buffer = ByteBuffer.allocate(32);
                actionInfo.put("action", "read");
                actionInfo.put("buffer", buffer);
                clientChannel.read(buffer, actionInfo, this);
            }

        }

        @Override
        public void failed(Throwable exc, Map<String, Object> attachment) {

        }

    }


    public static void main(String[] args) {
        new AioServer();




    }





}
