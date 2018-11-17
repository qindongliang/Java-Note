package basic.reference;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadShare {

    public String text="str-0";

    public int count=0;

    public Cat cat;

    static class Cat{

        public String name="none";

    }


    public static void main(String[] args) throws InterruptedException {


        ThreadShare share=new ThreadShare();


        Thread printThread=new Thread(new PrintThread(share));

        printThread.start();

        Thread.sleep(1000);

        Thread updateThread=new Thread(new UpdateThread(share));

        updateThread.start();













    }

    public static class UpdateThread implements Runnable{
        private ThreadShare threadShare;

        public UpdateThread(ThreadShare threadShare) {
            this.threadShare = threadShare;
        }

        @Override
        public void run() {
            threadShare.text="update";
            threadShare.count=10;
//            threadShare.cat.name="i am tom";
            threadShare.cat=new Cat();
        }
    }


    public static class PrintThread implements Runnable{

        private ThreadShare threadShare;

        public PrintThread(ThreadShare threadShare) {
            this.threadShare = threadShare;
        }

        @Override
        public void run() {

            String text=threadShare.text;
            int count=threadShare.count;
            Cat cat=threadShare.cat;

//            System.out.println("local变量访问： "+text+" "+count+"  "+cat.name);
            System.out.println("local变量访问： "+text+" "+count+"  "+cat);
            System.out.println("实例访问 "+threadShare.text+"   "+threadShare.count+"   "+threadShare.cat);
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("=======================");
            System.out.println("local变量访问： "+text+" "+count+"  "+cat);
            System.out.println("实例访问 "+threadShare.text+"   "+threadShare.count+"   "+threadShare.cat);

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
