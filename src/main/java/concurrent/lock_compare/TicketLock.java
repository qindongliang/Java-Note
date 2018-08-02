package concurrent.lock_compare;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by qindongliang on 2018/8/2.
 *
 * 公平自旋锁
 */
public class TicketLock {

     //当前正在服务的号码
    private AtomicInteger serviceNum=new AtomicInteger();

    //正在排队的号码

    private AtomicInteger ticketNum=new AtomicInteger();


    private void lock() throws InterruptedException {

        int getTicketNum=ticketNum.getAndIncrement();


        do{

            System.out.println(Thread.currentThread().getName()+" 开始自旋等待..... ticketNum="+getTicketNum);

            Thread.sleep(1000);


        }while (getTicketNum!=serviceNum.get());


        System.out.println(Thread.currentThread().getName()+" 使用号"+getTicketNum+" 完毕。");
        unlock();

    }

    private void unlock(){

        //开始叫下一位的号
       int nextServiceNum= 1 + serviceNum.get();


        serviceNum.compareAndSet(serviceNum.get(),nextServiceNum);


    }



    public static void main(String[] args) {

        TicketLock ticketLock=new TicketLock();

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                try {
                    ticketLock.lock();
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
