package concurrent.tools.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2018/8/23.
 */
public class CyclicBarrierDemo3 {


    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier c=new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {

                System.out.println(3);
            }
        })     ;


        new Thread(()->{
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(1);

        }).start();


        c.await();

        System.out.println(2);



    }
}
