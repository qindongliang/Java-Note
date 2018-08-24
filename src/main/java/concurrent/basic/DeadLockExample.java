package concurrent.basic;

/**
 * Created by Administrator on 2018/7/13.
 */
public class DeadLockExample {


    public  void m1()throws Exception{

        synchronized (String.class){

            System.out.println(Thread.currentThread().getName()+"  进入方法1 ，3秒后开始获取Interger锁");

            Thread.sleep(3000);

            synchronized (Integer.class){
                System.out.println(Thread.currentThread().getName()+"  进入方法1 ，获取了Interger锁");
            }


        }


    }


    public  void m2()throws Exception{

        synchronized (Integer.class){
            System.out.println(Thread.currentThread().getName()+"  进入方法2 ，3秒后开始获取String锁");
            Thread.sleep(3000);
            synchronized (String.class){

                System.out.println(Thread.currentThread().getName()+"  进入方法2，获取了String锁");
            }


        }


    }



    public static void main(String[] args) throws Exception {


        DeadLockExample deadLockExample=new DeadLockExample();

        Thread t1=new Thread(()->{
            try {
                deadLockExample.m1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        Thread t2=new Thread(()->{
            try {
                deadLockExample.m2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        t1.start();

        t2.start();




    }



}
