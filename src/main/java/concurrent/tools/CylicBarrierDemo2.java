package concurrent.tools;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2018/8/23.
 */
public class CylicBarrierDemo2 {


    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier=new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"  所有任务结束了.....");
            }
        });

        Random random=new Random();
        Runnable task=new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(random.nextInt(3)*1000);
                    System.out.println(Thread.currentThread().getName()+" 执行了...  ");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }
        };


        Thread t1=new Thread(task,"线程一");
        Thread t2=new Thread(task,"线程二");
        Thread t3=new Thread(task,"线程三");


        t1.start();
        t2.start();
        t3.start();









    }

}
