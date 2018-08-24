package concurrent.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by qindongliang on 2018/8/23.
 */
public class CyclicBarrierDemo4 {

    public static void main(String[] args) {


        CyclicBarrier cyclicBarrier=new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("任务完成，触发一次.....");
            }
        });

       Runnable runnable=new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(1000);
                   cyclicBarrier.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (BrokenBarrierException e) {
                   e.printStackTrace();
               }
           }
       };


       new Thread(runnable).start();
       new Thread(runnable).start();

        new Thread(runnable).start();
        new Thread(runnable).start();





    }

}
