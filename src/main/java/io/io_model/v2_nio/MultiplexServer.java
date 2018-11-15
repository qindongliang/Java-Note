package io.io_model.v2_nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by qindongliang on 2018/11/14.
 */
public class MultiplexServer  {


    public static void main(String[] args) throws Exception {

        String host="192.168.10.114";

        int port=5555;

        Selector selector=Selector.open();// multiplexor

        ServerSocketChannel serverChannel=ServerSocketChannel.open();// get a ServerSocketChannel

        InetSocketAddress  address=new InetSocketAddress(host,port);

        serverChannel.bind(address);//bind channel's socket to a local address and configures

        serverChannel.configureBlocking(false);//Adjusts this channel's boloking model

        int ops=serverChannel.validOps();//get ops of serverChannel support

        serverChannel.register(selector,ops,null);// At first,  we need register a ServerSocketChannel that it can accept request
        // from the client .

        System.out.println("start server.....");
      while (true){

          int status=selector.select();// execute block when channels is empty

//          System.out.println("status: "+status);

           Set<SelectionKey> keys= selector.selectedKeys();
           Iterator<SelectionKey> iterator = keys.iterator();


          while (iterator.hasNext()){
              SelectionKey key = iterator.next();
              if(key.isAcceptable()){// Tests whether this key's channel is ready to accept a new socket connection
              System.out.println("The key is acceptable");
              SocketChannel client=serverChannel.accept();
              client.configureBlocking(false);
              client.register(selector, SelectionKey.OP_READ);
              System.out.println("Connection Accepted: "+client.getLocalAddress()+" "+client.getRemoteAddress()+"  ");
              }

              if(key.isReadable()){
                  System.out.println("The key is readable");
                  SocketChannel client=(SocketChannel)key.channel();
                  String result=readMessage(client);
                  if (result.equals("quit") || result.equals("shutdown")) {
                      client.close();
                      System.out.println("disconnect from client ");
                      continue;
                  }

                  System.out.println("readable message: "+result);
                  writeMessage(client, result);

              }

              if(key.isWritable()){
                  System.out.println("The key is writable");
                  SocketChannel client=(SocketChannel)key.channel();
                  String result = readMessage(client);
                  if (result.length() > 0) {
                      System.out.println("write: "+result);
                      writeMessage(client, result);
                  }
              }

              iterator.remove();//remove SelectionKey which have been finished.



          }

          TimeUnit.SECONDS.sleep(3);

      }



    }

    public static String readMessage(SocketChannel client) throws IOException {
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        int size=client.read(buffer);

        String result=new String(buffer.array()).trim();

        return result;
    }



    public static void writeMessage(SocketChannel client, String ret) {
        ret="Server-Reply"+ret;

        try {
            ByteBuffer buffer = ByteBuffer.wrap(ret.getBytes());
            client.write(buffer);

            buffer.rewind();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
