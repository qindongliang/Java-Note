package concurrent.basic;

import java.util.concurrent.TimeUnit;

public class ThreadStopDemp {


    public static void main(String[] args) throws InterruptedException {


        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                String name=Thread.currentThread().getName();
                while (!Thread.currentThread().isInterrupted()){
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println(name+"  沉睡了2秒...... ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
//                        Thread.currentThread().interrupt();
                    }

                }

            }
        };


        Thread thread=new Thread(runnable);

        thread.start();


        System.out.println(thread.getThreadGroup());

        Thread.sleep(4000);



        thread.interrupt();


    }

}
