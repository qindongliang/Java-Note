package concurrent.threadpool;

import org.joda.time.DateTime;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by qindongliang on 2018/9/12.
 */
public class ScheduleExecutorServiceTest {


    public static void main(String[] args) {


        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+" running..... "+new DateTime().toString("yyyy-MM-dd HH:mm:ss"));

            }
        };


        ScheduledExecutorService executor= Executors.newScheduledThreadPool(1);


//        executor.scheduleAtFixedRate(runnable,2,2, TimeUnit.SECONDS);//等3秒执行
        executor.scheduleWithFixedDelay(runnable,2,2, TimeUnit.SECONDS);//等5秒执行







    }

}
