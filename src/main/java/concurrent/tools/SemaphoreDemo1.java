package concurrent.tools;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/8/24.
 */
public class SemaphoreDemo1 {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore=new Semaphore(3);

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 访问资源......");
                    semaphore.release();
            }
        };

        for (int i = 0; i < 5; i++) {
            Thread thread=new Thread(runnable);
            thread.start();
        }

        Thread.sleep(3000);














    }
}
