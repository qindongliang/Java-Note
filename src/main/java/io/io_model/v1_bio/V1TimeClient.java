package io.io_model.v1_bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by qindongliang on 2018/11/13.
 */
public class V1TimeClient {

    public static Boolean isServerClose(Socket socket){
        try{
            socket.sendUrgentData(0xFF);//发送1个字节的紧急数据，默认情况下，服务器端没有开启紧急数据处理，不影响正常通信
            return false;
        }catch(Exception se){
            return true;
        }
    }

    public static void main(String[] args) throws IOException {

        String ip="localhost";
        int port=8080;

        Socket socket=null;
        BufferedReader in=null;
        PrintWriter out=null;


        try {
            socket=new Socket(ip,port);
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            Scanner input=null;

            while (true) {

                if(isServerClose(socket)){
                    System.out.println("server exit ..... ");
                    break;
                }
                System.out.print("please input:");
                input=new Scanner(System.in);
                out.println(input.nextLine());
                String rsp = in.readLine();
                System.out.println("result： " + rsp);
            }




        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
            in.close();
            socket.close();
        }
    }

}
