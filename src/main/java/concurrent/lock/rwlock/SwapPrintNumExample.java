package concurrent.lock.rwlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qindongliang on 2018/12/1.
 */
public class SwapPrintNumExample {


    static class AppPrintNum{

        static int count=0;

        //声明一把锁
        Lock lock=new ReentrantLock();
        //奇数等待监视器
        Condition oddWait=lock.newCondition();
        //偶数等待监视器
        Condition evenWati=lock.newCondition();


        public void printOdd() throws InterruptedException {
            lock.lock();
            try {
                while (count % 2 == 0) {//当前是偶数
                    oddWait.await();//奇数线程等待
                }

                System.out.println(Thread.currentThread().getName()+" print: "+count);

                count++;//计数器+1

                Thread.sleep(1000);//避免打印的太快

                evenWati.signalAll();//唤醒偶数线程

            }finally {
                lock.unlock();
            }

        }


        public void printEven() throws InterruptedException {

            try {
                lock.lock();

                while(count%2!=0){//说明当前是奇数
                    evenWati.await();//偶数线程阻塞
                }

                System.out.println(Thread.currentThread().getName()+" print: "+count);

                count++;
                Thread.sleep(1000);

                oddWait.signalAll();//唤醒奇数线程

            }finally {
                lock.unlock();
            }




        }





    }



    public static void main(String[] args) {

        AppPrintNum appPrintNum=new AppPrintNum();

        Runnable t1=new Runnable() {
            @Override
            public void run() {
                try {
                    while (true)
                        appPrintNum.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable t2=new Runnable() {
            @Override
            public void run() {
                try {
                    while (true)
                        appPrintNum.printOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread even=new Thread(t1,"偶数线程");
        Thread odd=new Thread(t2,"奇数线程");


        even.start();
        odd.start();







    }




}
