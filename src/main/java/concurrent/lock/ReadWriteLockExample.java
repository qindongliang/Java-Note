package concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2018/7/27.
 */
public class ReadWriteLockExample {

    ReadWriteLock rwLock=new ReentrantReadWriteLock();
    Lock readLock=rwLock.readLock();
    Lock writeLock=rwLock.writeLock();
    private List<String> list;

    public ReadWriteLockExample(List<String> list){
        this.list=list;
    }


    public String get(int index){
        readLock.lock();
        try{
            return list.get(index);
        }finally {

            readLock.unlock();
        }
    }


    public void put(String item){

        writeLock.lock();
        try{
            list.add(item);
        }finally {
            writeLock.unlock();
        }

    }


    public static void main(String[] args) {






    }



}
