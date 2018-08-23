package concurrent.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by qindongliang on 2018/8/24.
 */
public class CyclicBarrierDemo5 {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {


        CyclicBarrier cyclicBarrier=new CyclicBarrier(2);

        new Thread(()->{

            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(2000);

        System.out.println(1/0);

        cyclicBarrier.await();

    }
}
