package concurrent.tools.phaser;


import java.util.concurrent.Phaser;

/**
 * Created by qindongliang on 2018/8/26.
 */
public class PhaserDemo2 {

    public static void main(String[] args) {

        int stepNums=3;

        Phaser phaser=new Phaser(){

            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println(phase+"    "+registeredParties);
                return  phase+1>=stepNums||registeredParties==0;
            }
        };



        for (int i = 0; i < 4; i++) {
            phaser.register();
            new Thread(new Task2(phaser)).start();

        }


    }


  static   class Task2 implements Runnable{
        private final Phaser phaser;

        public Task2(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {

            //判断是否终止
            while (!phaser.isTerminated()){
                int i=phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName()+"执行完任务");
            }

        }
    }

}
