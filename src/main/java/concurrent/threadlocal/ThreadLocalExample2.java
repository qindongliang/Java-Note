package concurrent.threadlocal;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/8/6.
 */
public class ThreadLocalExample2 implements Runnable {

    private static final AtomicInteger next=new AtomicInteger(100);


    private static final  ThreadLocal<Integer> threadId =new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return  next.getAndIncrement();
        }
    };


    private static final  ThreadLocal<Date> startDate =new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return  new Date();
        }
    };


    public int getOwnId(){

        return threadId.get();
    }




    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"  线程开始 "+getOwnId()+"   "+startDate.get());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"  线程结束 "+getOwnId()+"   "+startDate.get());

    }


    public static void main(String[] args) {
       ThreadLocalExample2 example2=new ThreadLocalExample2();

        Thread t1=new Thread(example2);
        Thread t2=new Thread(example2);
        Thread t3=new Thread(example2);

        t1.start();
        t2.start();
        t3.start();


    }


}
