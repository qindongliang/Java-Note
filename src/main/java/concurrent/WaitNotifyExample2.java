package concurrent;

/**
 * Created by Administrator on 2018/6/27.
 */
public class WaitNotifyExample2 {


    private volatile boolean go = false;



    private String getThreadName(){
        return Thread.currentThread().getName();
    }

    private synchronized void shouldGo() throws InterruptedException {

        while (go!=true){

            System.out.println(getThreadName()+ " 对象将要wait ");

            wait();// 释放锁

            System.out.println(getThreadName()+ " 被唤醒了......");

        }

        go=false;

    }


    private synchronized void go(){

        while (go==false){

            System.out.println(getThreadName()+"将要唤醒一个或者所有的线程");
            go=true;

//            notify();
            notifyAll();

        }


    }



    public static void main(String[] args) throws InterruptedException {


        WaitNotifyExample2  demo2=new WaitNotifyExample2();


        Runnable waitTask=new Runnable() {
            @Override
            public void run() {

                try {
                    demo2.shouldGo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread()+" 结束运行 ");
            }
        };

        Runnable notifyTask=new Runnable() {
            @Override
            public void run() {
                demo2.go();
                System.out.println(Thread.currentThread()+" 结束运行 ");
            }
        };



        Thread t1=new Thread(waitTask,"等待线程1");
        Thread t2=new Thread(waitTask,"等待线程2");
        Thread t3=new Thread(waitTask,"等待线程3");


        t1.start();
        t2.start();
        t3.start();




        Thread.sleep(2000);

        Thread t4=new Thread(notifyTask,"通知线程1");

        t4.start();








    }


}
