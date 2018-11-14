package io.io_model.v1_bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by qindongliang on 2018/11/13.
 */
public class V1TimeServer {

    public static void main(String[] args) throws IOException {


        //没有线程池的版本=n个客户端对n个线程
//        serial();
        //使用线程池的版本=n个客户端对m个线程
        optimize();






    }


    public static void optimize() throws IOException {
        int port=8080;
        ServerSocket server=null;
        ExecutorService pool=Executors.newFixedThreadPool(10);
        try {
            server = new ServerSocket(port);

            System.out.println("server start..... port=" + port);
            Socket socket = null;
            while (true) {
                socket = server.accept();
                pool.execute(new V1Handler(socket));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            server.close();//
        }
    }


    public static void serial() throws IOException {
        int port=8080;
        ServerSocket server=null;

        try {
            server = new ServerSocket(port);

            System.out.println("server start..... port=" + port);

            Socket socket = null;
            while (true) {
                socket = server.accept();
                new Thread(new V1Handler(socket)).start();// use new thread to handle
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            server.close();//
        }
    }




}
