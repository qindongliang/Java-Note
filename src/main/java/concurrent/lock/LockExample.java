package concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qindongliang on 2018/7/22.
 */
public class LockExample {


    public static void main(String[] args) {



        ShareCounter counter=new ShareCounter(new ReentrantLock());


        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println(Thread.currentThread().getName()+":   "+counter.getCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Thread t1=new Thread(runnable,"t1");
        Thread t2=new Thread(runnable,"t2");
        Thread t3=new Thread(runnable,"t3");


        t1.start();
        t2.start();
        t3.start();





    }


}
