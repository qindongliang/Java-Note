package concurrent.lock;

import java.util.concurrent.locks.Lock;

/**
 * Created by qindongliang on 2018/7/22.
 */
public class ShareCounter {

    private Lock lock;

    private int count;


    public ShareCounter(Lock lock) {
        this.lock = lock;
    }


    public  int getCount() throws InterruptedException {

        try{
            lock.lock();

            count++;
            return count;

        }finally {

            lock.unlock();

        }


    }




}
