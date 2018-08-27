package concurrent.tools.phaser;

import java.util.concurrent.Phaser;

/**
 * Created by qindongliang on 2018/8/26.
 */
public class PhraseDemo3 {

    public static void main(String[] args) {

        Phaser phaser=new Phaser(2);

        for (int i = 0; i < 2; i++) {
            new Thread(new Worker(phaser)).start();
        }


    }

    static class Worker implements Runnable{

        private final Phaser phaser;

        public Worker(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            String name=Thread.currentThread().getName();
            System.out.println(name+"  执行完成..... ");

            phaser.arriveAndAwaitAdvance();
            System.out.println(name+"继续执行......");
        }
    }


}
