package io.io_model.v3_aio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class AioClient {


    public static void main(String[] args) throws Exception {


         AsynchronousSocketChannel client=AsynchronousSocketChannel.open();
        InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8080);


        Future<Void> future=client.connect(hostAddress);

        future.get();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message;
        System.out.println("input msg:");
        while ((message = br.readLine()) != null) {


            byte[] byteMsg = message.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(byteMsg);
            Future<Integer> writeResult = client.write(buffer);

            try {
                writeResult.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            buffer.flip();
            buffer.clear();
            ByteBuffer serverMsg=ByteBuffer.allocate(1024);
            Future<Integer> readResult = client.read(serverMsg);
            try {
                readResult.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String echo = new String(serverMsg.array());
            System.out.println("server reply: "+echo);
            serverMsg.clear();
        }


    }





}
