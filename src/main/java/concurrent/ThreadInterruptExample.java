package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by qindongliang on 2018/6/25.
 */
public class ThreadInterruptExample {
    public static void main(String[] args) throws InterruptedException {


        // 当线程处于wait，sleep，join的状态打断会抛出线程中断异常
        // 其他情况下通过检测状态来正确退出

        Task task1=new Task();
        Thread t1=new Thread(task1);

        t1.start();

        while (true) {

            if(Math.random()>0.5) {
                System.out.println(">0.5");
//                Thread.sleep(1000);
                t1.interrupt();
                break;
            }
            TimeUnit.MICROSECONDS.sleep(1);
        }



    }

    private static class Task implements  Runnable{


        @Override
        public void run() {

            int c =0 ;

            while(true){

                c++;

                System.out.println("task running .... "+c);

                if(Thread.currentThread().isInterrupted()){

                    System.out.println("interrupted flag=true ");
                    terminate();
                    return;
                }


                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("interrupted exception");
                    terminate();
                    return;
                }


            }



        }


        private void  terminate(){
            System.out.println("terminating task");
        }
    }


}
