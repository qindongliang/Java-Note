package concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by Administrator on 2018/8/8.
 */
public class LockSupportExamle2 {


    public static void main(String[] args) {

        Thread main=Thread.currentThread();

        new Thread(()->{
            System.out.println("主线程："+main.getState());
            LockSupport.park("1");

            System.out.println("主线程："+main.getState());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("5秒后主线程："+main.getState());
            LockSupport.unpark(main);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park(main);
            System.out.println("解锁后主线程："+main.getState());

        }).start();


//        LockSupport.park("3");


        System.out.println("主线程结束......");






    }
}
