package concurrent.tools;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by qindongliang on 2018/8/17.
 */
public class CountDownLatchDemo1 {




    public static  void demo1() throws InterruptedException {

        CountDownLatch countDownLatch=new CountDownLatch(3);





        Random random=new Random();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName()+" begin ... ");
                try {
                    Thread.sleep(random.nextInt(4)*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();

            }
        };

        Thread t1=new Thread(runnable);
        Thread t2=new Thread(runnable);
        Thread t3=new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();



        Runnable waitThread=()->{

            try {
                System.out.println(Thread.currentThread().getName()+"  进入等待中....  ");
                countDownLatch.await();
                System.out.println(Thread.currentThread().getName()+" 3秒后结束  ");
                Thread. sleep(3000);
                System.out.println(Thread.currentThread().getName()+"  结束  ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };




        System.out.println(Thread.currentThread().getName()+" 打印 .... ");


        Thread t4=new Thread(waitThread,"等待1线程");
        Thread t5=new Thread(waitThread,"等待2线程");
        Thread t6=new Thread(waitThread,"等待3线程");
        t4.start();
        t5.start();
        t6.start();






    }


    public static void main(String[] args) throws InterruptedException {

        demo1();
    }







}
