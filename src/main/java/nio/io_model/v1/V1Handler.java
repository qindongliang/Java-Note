package nio.io_model.v1;

import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by qindongliang on 2018/11/13.
 */
public class V1Handler implements Runnable {
    BufferedReader in=null;
    PrintWriter out=null;
    private Socket socket;

    public V1Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run()  {
        try {
            System.out.println(Thread.currentThread().getName()+"开始运行...");
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(this.socket.getOutputStream(),true);
            String currentTime=null;
            String body=null;
            while (true){
                body=in.readLine();
                if(body==null||body.length()==0) {
                    System.out.println("exit socket");
                    break;
                }
                System.out.println("receive data: "+body);
                currentTime="java".equals(body)?new DateTime().toString("yyyy-MM-dd HH:mm:ss.SSS"):"no ok";
                out.println(currentTime);

            }

        } catch (IOException e) {
            e.printStackTrace();


        }finally {
            close();// release resource.....
        }


    }

    private void close(){
        try {
            in.close();
            out.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
