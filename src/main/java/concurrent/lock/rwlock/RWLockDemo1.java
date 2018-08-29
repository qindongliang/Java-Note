package concurrent.lock.rwlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWLockDemo1 {

    ReadWriteLock rwLock=new ReentrantReadWriteLock();
    Lock readLock=rwLock.readLock();
    Lock writeLock=rwLock.writeLock();

    String name;

    public String get(){
        readLock.lock();
        try {
            return name;
        }finally {
            readLock.unlock();
        }
    }

    public void set(String value){

        writeLock.lock();
        try{
            this.name=value;
        }finally {
            writeLock.unlock();
        }
    }


    public static void main(String[] args) {


        RWLockDemo1 demo1=new RWLockDemo1();






        new Thread(()->{

            while(demo1.get()==null){

            }

            System.out.println("end");

        }).start();





        try {
            TimeUnit.SECONDS.sleep(5);
            demo1.set("123");
            TimeUnit.MINUTES.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
