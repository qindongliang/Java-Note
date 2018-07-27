package concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/7/25.
 */
public class LockConditionExample {


    public static void main(String[] args) {

        //不同的condition条件，只能触发自己的解锁
        Lock lock=new ReentrantLock();

        Condition await=lock.newCondition();
        Condition wake=lock.newCondition();




        Thread t1=new Thread(()->{

            lock.lock();

            try {
                System.out.println(Thread.currentThread().getName()+" start await .....");
                await.await();
                System.out.println(Thread.currentThread().getName()+" wake up and end .....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        });

        t1.setName("线程一");

        Thread t2=new Thread(()->{

            lock.lock();

            try {

                System.out.println(Thread.currentThread().getName()+" sleep 5 seconds .....");
                Thread.sleep(3000);

                wake.signalAll();
//                await.signal();

                System.out.println(Thread.currentThread().getName()+" end .....");

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }


        });

        t2.setName("线程二");



        t1.start();
        t2.start();


















    }


}
