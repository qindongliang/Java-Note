package nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class NioSelectTest {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(555));

        Selector selector=Selector.open();

        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        while (true){

            Thread.sleep(2000);

            System.out.println("1");

            int status=selector.select();

            if(status==0) continue;

            System.out.println("2");

            Iterator ite=selector.selectedKeys().iterator();

            while (ite.hasNext()){

                SelectionKey key=(SelectionKey)ite.next();

                if(key.isAcceptable()){
                    System.out.println("acceptable");
                }

                if(key.isReadable()){
                    System.out.println("readable");
                }

                if(key.isWritable() && key.isValid()){
                    System.out.println(" write ");
                }

                if(key.isConnectable()){
                    System.out.println("is Connection");
                }


            }

            ite.remove();

        }





    }

}
