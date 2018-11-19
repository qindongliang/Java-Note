package basic.reference;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadShare {

    public String text="str-0";

    public int count=0;

    public Cat cat1;

    public Cat cat2=new Cat();

    static class Cat{

        public String name="none";

    }


    public static void main(String[] args) throws InterruptedException {


        ThreadShare share=new ThreadShare();


        Thread printThread=new Thread(new PrintThread(share));
        printThread.setName("打印线程");
        printThread.start();

        Thread.sleep(1000);

        Thread updateThread=new Thread(new UpdateThread(share));
        updateThread.setName("更新线程");

        updateThread.start();













    }

    public static class UpdateThread implements Runnable{
        private ThreadShare threadShare;

        public UpdateThread(ThreadShare threadShare) {
            this.threadShare = threadShare;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" 修改成员变量的值......");
            threadShare.text="update";
            threadShare.count=10;
//            threadShare.cat.name="i am tom";
            threadShare.cat1=new Cat();
            threadShare.cat2.name="cat2";

        }
    }


    public static class PrintThread implements Runnable{

        private ThreadShare threadShare;

        public PrintThread(ThreadShare threadShare) {
            this.threadShare = threadShare;
        }

        @Override
        public void run() {

            String threadName=Thread.currentThread().getName();
            String text=threadShare.text;
            int count=threadShare.count;
            Cat cat1=threadShare.cat1;
            Cat cat2=threadShare.cat2;

            System.out.println(threadName+"  初始值 "+text+" "+count+"  "+cat1+" "+cat2.name);
            System.out.println();
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println(threadName+"局部变量show： "+text+" "+count+"  "+cat1+"  "+cat2.name);
            System.out.println(threadName+"成员变量show： "+threadShare.text+"   "+threadShare.count+"   "+threadShare.cat1+" "+cat2.name);

        }
    }




    public static  void test1() throws InterruptedException {
        ThreadShare share=new ThreadShare();

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                Random random=new Random();
                int second=random.nextInt(6);
                System.out.println(Thread.currentThread().getName()+" sleep  "+second+" second !");
                try {
                    TimeUnit.SECONDS.sleep(second);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                share.text=Thread.currentThread().getName();
            }
        };


        Thread t1=new Thread(runnable);
        t1.start();
        Thread t2=new Thread(runnable);
        t2.start();


        t1.join();
        t2.join();


        System.out.println(share.text);
    }




}


