package concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) {


        ThreadPoolExecutor pool=(ThreadPoolExecutor)Executors.newFixedThreadPool(4);

        pool.allowCoreThreadTimeOut(true);


        pool.submit(new Runnable() {
            @Override
            public void run() {

                System.out.println("go......");
            }
        });




    }

}
