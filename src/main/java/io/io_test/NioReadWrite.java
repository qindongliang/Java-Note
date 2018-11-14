package io.io_test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NioReadWrite {


    private static void nioRead()throws  Exception{

        FileInputStream fin = new FileInputStream("src/main/resources/class/Demo.java");

        FileChannel fc=fin.getChannel();


        ByteBuffer buffer=ByteBuffer.allocate(300);
        int temp;
        while ( (temp=fc.read(buffer) )!=-1){
            System.out.println(temp);
            buffer.clear();
        };


        fc.close();;
        fin.close();
    }


    private static void nioWrite()throws  Exception{

        FileOutputStream outStream = new FileOutputStream("src/main/resources/class/tt");

        FileChannel out=outStream.getChannel();


        ByteBuffer buffer= Charset.forName("UTF-8").encode("你好你好你好你好");
        int len=0;
        while ( (len=out.write(buffer))!=0 ) {
            System.out.println("写入长度："+len);
            //不能执行clear，实现的是append模式
        }




        out.close();;
        outStream.close();
    }







    public static void main(String[] args) throws Exception {

            nioWrite();


    }
}
