package concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorInfoTest {

    public static void main(String[] args) throws InterruptedException {



        ThreadPoolExecutor pool= (ThreadPoolExecutor)Executors.newFixedThreadPool(3);

       Runnable run= new Runnable() {
            @Override
            public void run() {

//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        };

        pool.submit(run);
        pool.submit(run);
        pool.submit(run);
        pool.submit(run);
        pool.submit(run);

        Thread.sleep(200);
        System.out.println(pool.getActiveCount());//当前正在处理任务的线程数量
        System.out.println(pool.getPoolSize());//当前已经创建的线程数量
        System.out.println(pool.getCorePoolSize());//核心线程池的数量
        System.out.println(pool.getLargestPoolSize());//得到曾经创建过最大的线程池的数量
        System.out.println(pool.getCompletedTaskCount());//得到已经完成任务的数量


        pool.shutdown();


    }

}
