package concurrent.aqs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by qindongliang on 2018/8/12.
 */
public class Mutex2 implements Lock {



    private final Sync sync=new Sync();

    @Override
    public void lock() {

        sync.acquire(1);

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
            sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public boolean isLocked()         { return sync.isHeldExclusively(); }
    public boolean hasQueuedThreads() { return sync.hasQueuedThreads(); }

    public Thread getOwn(){return sync.getOwn();};



    // 0 = unlock , 1 = lock
    private static class Sync extends AbstractQueuedSynchronizer{

        @Override //是否处于锁定状态
        protected boolean isHeldExclusively() {
            return getState()==1;
        }

        public Thread getOwn(){
           return getExclusiveOwnerThread();
        }


        @Override // 如果状态是0，就获取锁
        protected boolean tryAcquire(int arg) {

            assert arg == 1 ; //不能是0

            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }

            return false;
        }


        Condition newCondition(){
            return new ConditionObject();
        }


        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            s.defaultReadObject();
            setState(0); // 重置状态

        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1 ; //不能是0

            if(getState()==0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);

            return true;


        }




    }

    public static void main(String[] args) throws InterruptedException {

        Mutex2 mutex2=new Mutex2();

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                mutex2.lock();

                System.out.println(Thread.currentThread().getName()+"开始使用中...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mutex2.unlock();

            }
        };



        Thread t1=new Thread(runnable,"线程1 ");

        t1.start();


        Thread.sleep(1000);
//        mutex2.lock();

        System.out.println(mutex2.getOwn().getName());
        System.out.println(mutex2.isLocked());
//        System.out.println("主线程");

//        mutex2.unlock();




    }



}
