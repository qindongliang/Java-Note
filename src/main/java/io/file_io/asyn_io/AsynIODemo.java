package io.file_io.asyn_io;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class AsynIODemo {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("F:\\temp\\kp_info");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
//        readByFuture(fileChannel);//同步的读取方式
//        readByCompletionHandler(fileChannel);//异步读取的方式
//        Thread.sleep(1000);

        writeByFuture();//异步写入的的方法


    }


    public static void writeByFuture() throws Exception{

        Path path = Paths.get("F:\\temp\\nio_text");
        if(!Files.exists(path)){
            Files.createFile(path);
        }
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;

        buffer.put("test data".getBytes());
        buffer.flip();

        Future<Integer> operation = fileChannel.write(buffer, position);
        buffer.clear();

        while(!operation.isDone());

        System.out.println("Write done");


        System.out.println(12);
    }



    public static void writeByCompletionHandler() throws Exception{
        Path path = Paths.get("data/test-write.txt");
        if(!Files.exists(path)){
            Files.createFile(path);
        }

        AsynchronousFileChannel fileChannel =
                AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;

        buffer.put("test data".getBytes());
        buffer.flip();

        fileChannel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {

            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("bytes written: " + result);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("Write failed");
                exc.printStackTrace();
            }
        });

    }


    public static void readByCompletionHandler(AsynchronousFileChannel fileChannel){
        ByteBuffer buffer = ByteBuffer.allocate(5);
        long position = 0;
        fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {

                System.out.println("thread: "+Thread.currentThread().getName());

                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });
    }


    public static void readByFuture(AsynchronousFileChannel fileChannel){
        ByteBuffer buffer = ByteBuffer.allocate(12);
        long position = 0;
        Future<Integer> operation = fileChannel.read(buffer, position);
        while(!operation.isDone()); //判断是否读取完成

        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data));
        buffer.clear();
    }

}
