package concurrent.tools.concurrent_queue;

import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by qindongliang on 2018/9/1.
 */
public class ConcurrentQueueTest {


    public static void main(String[] args) throws InterruptedException {

        ConcurrentLinkedQueue<String> queue=new ConcurrentLinkedQueue<>();




        Runnable producer=new Runnable() {
            @Override
            public void run() {

                String head=UUID.randomUUID().toString();
                System.out.println(Thread.currentThread().getName()+" 生产了 "+head);
                queue.offer(head);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        Thread.sleep(3000);

        Runnable consumer=new Runnable() {
            @Override
            public void run() {
               String data= queue.poll();
                System.out.println(Thread.currentThread().getName()+" 消费了 "+data);

            }
        };


        new Thread(consumer).start();







    }



}
