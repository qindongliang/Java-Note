package io.io_model.v2_nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/** reference document => https://gist.github.com/rostyslav
 *  Created by qindongliang on 2018/11/14.
 */
public class MultiplexClient  {


    public static void main(String[] args) throws Exception {

        Selector selector = Selector.open();

        String host="192.168.10.114";
        int port=5555;
        InetSocketAddress address=new InetSocketAddress(host,port);

//        SocketChannel client=SocketChannel.open(address); // Opens a socket channel and connects it to a remote address

        SocketChannel client=SocketChannel.open();//Only opens a socket channel
        client.connect(address);
        client.configureBlocking(false);



        client.register(selector,SelectionKey.OP_CONNECT);

        System.out.println("Begin to connect ServerSocket....");

        //read msg
        Thread readMsgThread=new ReceiveThread(client);
        readMsgThread.start();

        TimeUnit.SECONDS.sleep(2);
        //send msg
        while (( sendMessage(client)) != -1) {

        }

        client.close();





    }




    private static boolean stopSend;

    public static class ReceiveThread extends Thread{


        private SocketChannel client;

        public ReceiveThread(SocketChannel socketChannel) {
            this.client = socketChannel;
        }


        @Override
        public void run() {

            int nBytes = 0;
            ByteBuffer buf = ByteBuffer.allocate(2048);
            try {
                while (!stopSend) {
                    while ((nBytes = client.read(buf)) > 0) {
                        String result=new String(buf.array());
                        System.out.println("Client Receive msg: "+result);
                        buf.clear();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();

            }


        }
    }



    public static int sendMessage(SocketChannel client) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        try {
            msg = in.readLine();
            ByteBuffer bytebuf =ByteBuffer.wrap(msg.getBytes());
            client.write(bytebuf);
            TimeUnit.SECONDS.sleep(1);
            if (msg.equals("quit") || msg.equals("shutdown")) {
                System.out.println("time to stop the client");
                interruptThread();
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                client.close();
                return -1;
            }
        bytebuf.rewind();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    private static void interruptThread() {
        stopSend=true;
    }




    private void connect(){
        //        while (true){
//
//            selector.select();
//
//            Set<SelectionKey> keys= selector.selectedKeys();
//            Iterator<SelectionKey> iterator = keys.iterator();
//
//            while(iterator.hasNext()){
//
//                SelectionKey key=iterator.next();
//
//                if(key.isConnectable()){ // connecting ......   tcp handshake
//
//                    if(client.finishConnect()){
//
//                        System.out.println("connect success.....");
//
//                        key.interestOps(SelectionKey.OP_READ);
//                    }
//
//                }
//
//
//            }
//
//
//
//        }
    }


}
