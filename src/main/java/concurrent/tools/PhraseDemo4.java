package concurrent.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * Created by qindongliang on 2018/8/26.
 */
public class PhraseDemo4 {


    public static void main(String[] args) {


        ExecutorService executorService= Executors.newCachedThreadPool();

        Phaser ph=new Phaser(1);

        System.out.println(ph.getPhase());

        executorService.submit(new RunAction("T1",ph));
        executorService.submit(new RunAction("T2",ph));
        executorService.submit(new RunAction("T3",ph));

//        ph.arriveAndAwaitAdvance();

//        System.out.println(ph.getPhase());

    }



    static class RunAction implements Runnable {

        String name;
        private Phaser ph;

        public RunAction(String name, Phaser ph) {
            this.name = name;
            this.ph = ph;
            ph.register();
        }

        @Override
        public void run() {

            System.out.println(name+"step phrase=> "+ph.getPhase());

            System.out.println(name+ " running ....");

            ph.arriveAndAwaitAdvance();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ph.arriveAndDeregister();

        }
    }

}
