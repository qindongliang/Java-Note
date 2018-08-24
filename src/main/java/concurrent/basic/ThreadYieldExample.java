package concurrent.basic;

/**
 * Created by Administrator on 2018/6/26.
 */
public class ThreadYieldExample {


    public static void main(String[] args) {

        //yield方法仅仅是对线程调度器的一个暗示，表示自己
        //可以暂停执行一会，把空闲的资源短暂的让给同一优先级或者更高的线程，如果没有
        //符合条件的就还执行自己的任务，

        new Thread(()->{

            for (int i = 0; i <100; i++) {


                System.out.println(Thread.currentThread().getName()+"  .....");

            }


        }).start();


        for (int i = 0; i < 100; i++) {

            Thread.yield();
            System.out.println(Thread.currentThread().getName()+"  .....");

        }





    }





}
