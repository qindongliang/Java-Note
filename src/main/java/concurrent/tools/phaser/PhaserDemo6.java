package concurrent.tools.phaser;

import java.util.concurrent.Phaser;

/**
 * Created by Administrator on 2018/8/27.
 */
public class PhaserDemo6 {

    public static void main(String[] args) throws InterruptedException {

       final Phaser phaser=new Phaser(1);


        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                phaser.arriveAndAwaitAdvance();//等待

                System.out.println(Thread.currentThread().getName()+" 开始执行。。 ");

            }
        };

        for (int i = 0; i < 3; i++) {
            phaser.register();
            new Thread(runnable).start();
        }
        Thread.sleep(6000);
//        phaser.arriveAndAwaitAdvance();
        phaser.arriveAndDeregister();
        System.out.println(Thread.currentThread().getName()+" 开始执行。。 ");




    }
}
