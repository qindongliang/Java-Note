package concurrent.tools.phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * Created by qindongliang on 2018/8/26.
 */
public class PhraseDemo4 {


    public static void main(String[] args) {


        //
        Phaser phaser=new Phaser(1);

        //Create 3 threads
        Thread thread1=new Thread(new MyRunnable(phaser,"first"),"Thread-1");
        Thread thread2=new Thread(new MyRunnable(phaser,"second"),"Thread-2");
        Thread thread3=new Thread(new MyRunnable(phaser,"third"),"Thread-3");
        System.out.println("\n--------Phaser has started---------------");
        //Start 3 threads
        thread1.start();
        thread2.start();
        thread3.start();

        //get current phase
        int currentPhase=phaser.getPhase();

        phaser.arriveAndAwaitAdvance();
//        phaser.arriveAndDeregister();
        System.out.println("------Phase-"+currentPhase+" has been COMPLETED----------");


//        currentPhase=phaser.getPhase();
//        phaser.arriveAndAwaitAdvance();
//        System.out.println("------Phase-"+currentPhase+" has been COMPLETED----------");
//
//       /* current thread Arrives and deRegisters from phaser.
//        * DeRegistration reduces the number of parties that may
//        * be required to advance in future phases.
//        */
//        phaser.arriveAndDeregister();
//
//        //check whether phaser has been terminated or not.
//        if(phaser.isTerminated())
//            System.out.println("\nPhaser has been terminated");



    }



    static class MyRunnable implements Runnable{

        Phaser phaser;

        public MyRunnable(Phaser phaser,String name) {
            this.phaser = phaser;
            this.phaser.register();//
            System.out.println(name+"New unarrived party has been registered with phaser");
        }

        @Override
        public void run() {

            String threadName=Thread.currentThread().getName();

            System.out.println(threadName +
                    " - party has arrived and is working in "
                    + "Phase-"+phaser.getPhase());

            phaser.arriveAndAwaitAdvance();//wait other

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //------NEXT PHASE BEGINS------

            System.out.println(Thread.currentThread().getName() +
                    " - party has arrived and is working in "
                    + "Phase-"+phaser.getPhase());
            phaser.arriveAndAwaitAdvance();

            phaser.arriveAndDeregister();


        }


    }


}
