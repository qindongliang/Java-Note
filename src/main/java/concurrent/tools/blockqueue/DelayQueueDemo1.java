package concurrent.tools.blockqueue;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by qindongliang on 2018/9/1.
 */
public class DelayQueueDemo1 {

    //延迟队列
    static DelayQueue<DelayTask> queue=new DelayQueue<>();



    public static void main(String[] args) throws InterruptedException {

        int delayMs=2000;
        Runnable producer=new Runnable() {
            @Override
            public void run() {

                DelayTask delayTask=new DelayTask(UUID.randomUUID().toString(),delayMs);

                System.out.println(Thread.currentThread().getName()+" 开始放入数据 "+delayTask);

                queue.put(delayTask);

            }
        };

        
        Runnable consumer=new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "尝试获取数据..");
                        System.out.println(Thread.currentThread().getName()+" "+queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(consumer,"消费者0").start();
        new Thread(consumer,"消费者1").start();


        Thread.sleep(5000);

        
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
           new Thread(producer).start();
        }







    }



    static class DelayTask implements Delayed{

        String data;
        long startTime;

        public DelayTask(String data, long delayTimeMs) {
            this.data = data;
            this.startTime = System.currentTimeMillis()+delayTimeMs;
        }

        @Override
        public long getDelay(TimeUnit unit) {

            long diff=startTime-System.currentTimeMillis();
            return unit.convert(diff,TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {

            if(o==null) return 0;

            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }


        @Override
        public String toString() {
            return "DelayTask{" +
                    "data='" + data + '\'' +
                    ", startTime=" + startTime +
                    '}';
        }
    }
}
