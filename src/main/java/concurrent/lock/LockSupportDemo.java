package concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by qindongliang on 2018/8/8.
 */
public class LockSupportDemo {


    public static void main(String[] args) {

        Thread main=Thread.currentThread();





        new Thread(()->{


            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Object ob= LockSupport.getBlocker(main);
            System.out.println(ob);

        }).start();

        LockSupport.park("dongliangpark");


    }

}
