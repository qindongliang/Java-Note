package nio.io_model.v1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by qindongliang on 2018/11/13.
 */
public class V1TimeServer {

    public static void main(String[] args) throws IOException {

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
