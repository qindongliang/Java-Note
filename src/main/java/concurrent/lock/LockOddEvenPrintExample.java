package concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qindongliang on 2018/7/25.
 */
public class LockOddEvenPrintExample {

    static class CountValue{
        static  int count=1;
    }


    static class PrintNumer {

        private Lock lock=new ReentrantLock();
        private Condition isOdd=lock.newCondition();
        private Condition isEven=lock.newCondition();
        private int maxSize=10;


        // 打印奇数
        public void printOddNum() throws InterruptedException {


            while (CountValue.count<maxSize){

                lock.lock();

                try {

                    while (CountValue.count%2==0){
                        System.out.println(Thread.currentThread().getName()+"奇数线程阻塞");
                        isOdd.await();
                    }

                    System.out.println(Thread.currentThread().getName()+"线程 打印 "+CountValue.count);
                     CountValue.count++;



                    Thread.sleep(1000);
                    // 通知偶数线程
                    isEven.signal();

                }finally {

                    lock.unlock();
                }




            }


        }



        // 打印偶数
        public void printEvenNum() throws InterruptedException {


            while (CountValue.count<maxSize){

                lock.lock();

                try {

                    while (CountValue.count%2!=0){
                        System.out.println(Thread.currentThread().getName()+"偶数线程阻塞");
                        isEven.await();
                    }



                    System.out.println(Thread.currentThread().getName()+"线程 打印 "+CountValue.count);
                    CountValue.count++;
                    Thread.sleep(1000);
                    // 通知偶数线程
                    isOdd.signal();

                }finally {

                    lock.unlock();
                }




            }


        }




    }




    public static void main(String[] args) {


        PrintNumer printNumer=new PrintNumer();

        Thread t1=new Thread(()->{


            try {
                printNumer.printEvenNum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.setName("even");



        Thread t2=new Thread(()->{


            try {
                printNumer.printOddNum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t2.setName("odd");


        t1.start();
        t2.start();






    }


}
