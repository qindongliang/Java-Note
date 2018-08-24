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

        Lock lock=new ReentrantLock();

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 得到锁......");
                lock.unlock();
            }
        };


        Thread t1=new Thread(runnable);
        t1.start();

        Thread t2=new Thread(runnable);
        t2.start();


        Thread.sleep(3000);


        System.out.println(t1.getState());
        System.out.println(t2.getState());












    }
}
