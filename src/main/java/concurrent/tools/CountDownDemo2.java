package concurrent.tools;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2018/8/20.
 */
public class CountDownDemo2 {





    static class Worker implements Runnable{

        private final CountDownLatch startSignal;
        private final CountDownLatch dongSignal;

        Worker(CountDownLatch startSignal,CountDownLatch dongSignal){
            this.startSignal=startSignal;
            this.dongSignal=dongSignal;
        }
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+"  启动了，等待main线程调度.......");
                startSignal.await();
                doWork();
                System.out.println(Thread.currentThread().getName()+"  完活 ..... ");
                dongSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        void doWork() throws InterruptedException {

            System.out.println(Thread.currentThread().getName()+"  开始工作 ..... ");
            Thread.sleep(5000);

        }
    }



    public static void main(String[] args) throws InterruptedException {


        CountDownLatch startSignal=new CountDownLatch(1);//
        CountDownLatch doneSignal=new CountDownLatch(5);

        for(int i=0;i<5;i++){

            new Thread(new Worker(startSignal,doneSignal)).start();
        }
        Thread.sleep(4000);
        System.out.println(Thread.currentThread().getName()+"线程准备就绪，所有线程可以开始工作了..... ");
        startSignal.countDown();
        doneSignal.await();

        System.out.println(Thread.currentThread().getName()+"线程监控任务结束 ");






    }
}
