package concurrent.tools;

import java.util.concurrent.Phaser;

/**
 * Created by Administrator on 2018/8/25.
 */
public class PhaserDemo1 {

    public static void main(String[] args) throws InterruptedException {

     test2();

    }
    public static  void test2() throws InterruptedException {

        Phaser phaser=new Phaser(1);

        for (int i = 0; i < 10; i++) {
            phaser.register();
            new Thread(new MyTask(phaser)).start();
        }

        Thread.sleep(3000);
        phaser.arriveAndDeregister();

    }

    public  static void test1(){
        Phaser phaser=new Phaser();

        phaser.register();
        for (int i = 0; i < 10; i++) {

            new Thread(new MyTask(phaser)).start();
        }

    }

    static class  MyTask implements Runnable{

        private final Phaser phaser;

        public MyTask(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {

            int i=phaser.arriveAndAwaitAdvance();

            System.out.println(Thread.currentThread().getName()+" 当前任务完成"+i);

        }
    }

}
