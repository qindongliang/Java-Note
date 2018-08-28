package concurrent.tools.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by qindongliang on 2018/8/24.
 */
public class CountDownLatchDemo3 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch=new CountDownLatch(3);

        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();

        System.out.println("1111");

        countDownLatch.await();


    }
}
