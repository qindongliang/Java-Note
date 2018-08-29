package concurrent.tools.blockqueue;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by qindongliang on 2018/8/29.
 */
public class SynchronousQueueDemo1 {

    public static void main(String[] args) {

        SynchronousQueue<Integer> synchronousQueue=new SynchronousQueue();



        new Thread(()->{
            int count=0;
            while (true){

                try {

                    System.out.println(Thread.currentThread().getName()+" 放入了"+count);
                    synchronousQueue.put(count);

                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }).start();


        new Thread(()->{

            while (true){

                try {
                    Thread.sleep(2000);
                    int count=synchronousQueue.take();
                    System.out.println(Thread.currentThread().getName()+" 消费了"+count);


                    count++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }).start();
    }


}
