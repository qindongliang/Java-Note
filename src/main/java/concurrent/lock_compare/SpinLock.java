package concurrent.lock_compare;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Administrator on 2018/8/2.
 * 非公平自旋锁
 */
public class SpinLock {

    private AtomicReference<Thread> owner=new AtomicReference<>();


    private void lock() throws InterruptedException {


          Thread expectValue=null;
          Thread   updateValue;

        do {
             updateValue=Thread.currentThread();
            System.out.println(updateValue.getName()+" 自旋等待中.....  ");
            Thread.sleep(1000);

            //只有第一个执行的线程，才会加锁成功，其他一直处于自旋等待中
        }while (!owner.compareAndSet(expectValue,updateValue));

        System.out.println(updateValue.getName()+" 加锁成功...... 4秒后释放锁 ");

        // do work

        Thread.sleep(4000);
        System.out.println(updateValue.getName()+" 释放锁了。。。。。 ");
        unlock();

    }


    public void unlock(){


        Thread expectValue=Thread.currentThread();

        owner.compareAndSet(expectValue,null);


    }




    public static void main(String[] args) {

        SpinLock spinLock=new SpinLock();


        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                try {
                    spinLock.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Thread t1=new Thread(runnable);
        Thread t2=new Thread(runnable);
        Thread t3=new Thread(runnable);


        t1.start();
        t2.start();
        t3.start();


    }



}
