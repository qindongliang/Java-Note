package concurrent.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by qindongliang on 2018/7/11.
 */
public class ProducerConsumerDemo1 {



  static   class Producer extends Thread{

        private Queue<Integer> queue;
        private int maxSize;


        public Producer(Queue<Integer> queue,int maxSize,String name){
            this.setName(name);
            this.queue=queue;
            this.maxSize=maxSize;


        }


        @Override
        public void run() {


            while (true){
                try {

                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (queue){

                    while (queue.size()==maxSize){

                        System.out.println(this.getName()+"生产队列满了，开始等待");

                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }


                    Random random=new Random();
                    int value=random.nextInt();

                    System.out.println("生产值："+value);
                    queue.add(value);
                    queue.notifyAll();


                }



            }


        }
    }



 static    class Consumer extends  Thread{
        private Queue<Integer> queue;
        private int maxSize;


        public Consumer(Queue<Integer> queue,int maxSize,String name){
            this.setName(name);
            this.queue=queue;
            this.maxSize=maxSize;


        }


        @Override
        public void run() {

            while (true){

                try {

                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (queue){

                    while (queue.isEmpty()){

                        System.out.println(this.getName()+"队列为空开始等待");

                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }


                    System.out.println("移除："+queue.remove());

                    queue.notifyAll();



                }

            }



        }
    }




    public static void main(String[] args) {

        Queue<Integer> queue=new LinkedList<Integer>();

        int maSize=10;
        Producer producer=new Producer(queue,10,"producer thread");

        Consumer consumer=new Consumer(queue,10,"consumer thread");



        consumer.start();

        producer.start();




    }

}
