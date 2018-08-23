package concurrent.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by qindongliang on 2018/8/24.
 */
public class CyclicBarrierDemo5 {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException, TimeoutException {


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

        System.out.println("1111");

        cyclicBarrier.await(3, TimeUnit.SECONDS);

    }
}
