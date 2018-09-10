package concurrent.basic;

import java.util.concurrent.TimeUnit;

public class ThreadGroupDemo {

    public static void main(String[] args) throws InterruptedException {

        ThreadGroup threadGroup=new ThreadGroup("test");


        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName()+"  开始沉睡 " );

                try {
                    TimeUnit.SECONDS.sleep(6);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                    System.out.println(Thread.currentThread().getName()+" 被打断了..... ");
                }

            }
        };

        Thread t1=new Thread(threadGroup,runnable,"t1");
        Thread t2=new Thread(threadGroup,runnable,"t2");
        Thread t3=new Thread(threadGroup,runnable,"t3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(2000);


        System.out.println("活动线程数量：" + threadGroup.activeCount());

        threadGroup.list();
        threadGroup.interrupt();

    }
}
