package concurrent.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by qindongliang on 2018/7/24.
 */
public class LockQueueExample2 {

    private Lock lock=new ReentrantLock();

    Condition cl=lock.newCondition();



    Queue<Integer> queue;



    Random random=new Random();

    int limitCount;


    public LockQueueExample2(Queue<Integer> queue, int limitCount) {
        this.queue = queue;
        this.limitCount = limitCount;
    }


    public void producer() throws InterruptedException {

        while (true) {
            lock.lock();
            String name = Thread.currentThread().getName();

            try {

                while (queue.size() == limitCount) {

                    System.out.println(name + " 队列满了，生产者开始阻塞 ");
                    cl.await();//满了就阻塞
                }



                int feed = random.nextInt(100);
                System.out.println("生产者放入一条数据：" + feed);
                queue.add(feed);

                Thread.sleep(1000);
                cl.signalAll();

            } finally {
                lock.unlock();
            }

        }

    }


    public void consumer() throws InterruptedException {

        while (true) {
            lock.lock();
            String name = Thread.currentThread().getName();

            try {

                while (queue.isEmpty()) {

                    System.out.println(name + " 队列空了，消费者开始阻塞 ");

                    cl.await();//满了就阻塞
                }


                int feed = queue.remove();
                System.out.println("消费者消费一条数据：" + feed);

                Thread.sleep(1000);

                cl.signalAll();//通知生产者可以生产了。

            } finally {
                lock.unlock();
            }

        }


    }

    public static void main(String[] args) {

        Queue<Integer> queue=new LinkedList<Integer>();
        int limitCount=10;

        LockQueueExample2 example=new LockQueueExample2(queue,limitCount);


        Thread t1=new Thread(()->{

            try {
                example.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });


        Thread t2=new Thread(()->{

            try {
                example.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        t1.start();
        t2.start();




    }


}
