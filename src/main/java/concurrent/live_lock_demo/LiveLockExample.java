package concurrent.live_lock_demo;

/**
 * Created by qindongliang on 2018/7/15.
 * 线程活锁的例子
 */
public class LiveLockExample {


    public static void main(String[] args) {



        Worker w1=new Worker("work1",true);


        Worker w2=new Worker("work2",true);

        CommonResource common=new CommonResource(w1);


        new Thread(()->{

            try {
                w1.work(common,w2);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();




        new Thread(()->{

            try {
                w2.work(common,w1);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();


    }




}
