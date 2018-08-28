package concurrent.tools.semaphore;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/8/25.
 */
public class SemaphoreDemo2 {

    private final Lock lock=new ReentrantLock(true);
    private final Condition condition=lock.newCondition();
    private int permit;
    public SemaphoreDemo2(int permit) {
        this.permit=permit;
    }

    public static void main(String[] args) {

       final SemaphoreDemo2 semaphoreDemo2=new SemaphoreDemo2(0);

        Runnable runnable=new Runnable() {

            public void run() {
                semaphoreDemo2.acquire();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                semaphoreDemo2.release();
            }
        };

        for(int i=0;i<5;i++){
            Thread thread=new Thread(runnable);
            thread.start();
        }



    }


    private void acquire(){

        lock.lock();
        try{
            if(permit==0){
                condition.await();//如果超过限制，就进入条件阻塞队列
            }
            System.out.println(Thread.currentThread().getName()+"  获得资源 .... ");
             permit--;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    private void  release(){
        lock.lock();
        try{
            permit++;
            condition.signalAll(); //每当有一个释放令牌，就唤醒所有等待的线程
        }finally {
            lock.unlock();
        }


    }


}
