package concurrent.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qindongliang on 2018/7/24.
 */
public class SellerTicket {

    //火车票余票数量
    private static  int tickctCount=20;
    //使用重入锁，默认是不公平的，
    private static Lock lock=new ReentrantLock();
    //使用线程协作
    private static Condition idle=lock.newCondition();
    //随机等待一定时间，模拟公平性
    private static Random seed=new Random();

    public static void main(String[] args) {



        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                while (true){

                    String name=Thread.currentThread().getName();

                    lock.lock();
                    try {

                        if(tickctCount==0){
                            System.out.println(name+" 票已经售完，谢谢光临！");
                            return;
                        }

                        //卖票
                        System.out.println(name + " 卖出了票id=" + tickctCount);

                        //累加
                        tickctCount--;

                        //为了让别的线程有几率卖票，模拟更真实的例子
                        idle.await(seed.nextInt(1000), TimeUnit.MILLISECONDS);

                    }catch (Exception e){

                        e.printStackTrace();

                        System.out.println("sell error");

                    }finally {

                        lock.unlock();

                    }




                }


            }
        };



        Thread t1=new Thread(runnable,"窗口1");
        Thread t2=new Thread(runnable,"窗口2");
        Thread t3=new Thread(runnable,"窗口3");
        Thread t4=new Thread(runnable,"窗口4");




        t1.start();
        t2.start();
        t3.start();
        t4.start();










    }







}
