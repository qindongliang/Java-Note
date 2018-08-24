package concurrent.basic;

/**
 * Created by Administrator on 2018/6/27.
 */
public class ThreadLifeCycleExample {


    public static void main(String[] args) throws InterruptedException {


//                demo1();//   NEW OR RUNNABLE OR TERMINATED
//                demo2();//   BLOCKED
//                 demo3();//    WAITING

                    demo4();// TIMED_WAITING








    }


    public static void demo4() throws InterruptedException {

       Thread t1= new     Thread(()->{

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });


        t1.start();


        Thread.sleep(1000);

        System.out.println(t1.getState());





    }





    /***
     *  显示 BLOCKED 状态
     */
    public static void demo2() throws InterruptedException {


        Thread t1=new Thread(new DemoThread());
        Thread t2=new Thread(new DemoThread());

        t1.start();
        t2.start();


        Thread.sleep(1000);

        System.out.println(t1.getState());
        System.out.println(t2.getState());

    }




    /***
     * 显示 NEW OR RUNNABLE OR TERMINATED 状态
     * @throws InterruptedException
     */
    public static  void demo1() throws InterruptedException {

        Thread t1=new Thread(()->{
                // 空的内容
        });
        //NEW
        System.out.println(t1.getState());
        t1.start();
        //RUNNABLE
        System.out.println(t1.getState());
        Thread.sleep(1000);
        //TERMINATED
        System.out.println(t1.getState());


    }





}

class WaitingThread implements Runnable{


    public static Thread t1;


    public static void demo3(){
        t1=new Thread(new WaitingThread());

        t1.start();
    }


    public static void main(String[] args) {

        demo3();

    }


    @Override
    public void run() {


        Thread t2=new Thread(new SleepThread());
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}


class SleepThread implements Runnable{

    @Override
    public void run() {


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(WaitingThread.t1.getState());


    }
}





class  DemoThread implements Runnable{

    @Override
    public void run() {

        sharedResource();

    }

    public static synchronized void sharedResource(){

        while (true){

            //无限循环，模拟的重的负载
            // t1 不会退出这个方法
            // t2 会一直在等待获取这个方法
        }


    }


}