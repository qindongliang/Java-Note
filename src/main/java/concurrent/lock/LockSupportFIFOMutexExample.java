package concurrent.lock;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by Administrator on 2018/8/7.
 */
public class LockSupportFIFOMutexExample {

    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        //先把自己加到队列里面
        waiters.add(current);

        // Block while not first in queue or cannot acquire lock
        //peek取出头元素但不移除，判断头元素是否等当前线程 ，如果不是当前元素，直接进入循环
        //如果头不是当前线程，那么判断CAS指令，如果成功直接执行代码，否则进入循环阻塞
        while (waiters.peek() != current || !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            if (Thread.interrupted()) // ignore interrupts while waiting
                wasInterrupted = true;
        }

        waiters.remove();
        if (wasInterrupted)          // reassert interrupt status on exit
            current.interrupt();
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }


    public static void main(String[] args) {



    }


}
