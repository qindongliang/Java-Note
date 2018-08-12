package concurrent.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by qindongliang on 2018/8/12.
 */
public class MyMutex {

    class Sync extends AbstractQueuedSynchronizer{

        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0,1);
        }

        @Override
        protected boolean tryRelease(int arg) {
              setState(0);

            return true;
        }
    }

    private final Sync sync=new Sync();

    public void lock(){
        sync.acquire(0);
    }

    public void unlock(){
        sync.release(0);
    }

    public static void main(String[] args) {

        MyMutex myMutex=new MyMutex();

        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                myMutex.lock();

               String name= Thread.currentThread().getName();

                System.out.println(name+"  开始工作..... ");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(name+"  结束工作..... ");
                myMutex.unlock();



            }
        };


        Thread t1=new Thread(runnable,"线程1 ");
        Thread t2=new Thread(runnable,"线程2 ");
        Thread t3=new Thread(runnable,"线程3 ");

        t1.start();
        t2.start();
        t3.start();


    }





}
