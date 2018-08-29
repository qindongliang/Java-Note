package concurrent.lock.rwlock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2018/7/27.
 */
public class ReadWriteLockExample {
    Random random=new Random();
    ReadWriteLock rwLock=new ReentrantReadWriteLock();
    Lock readLock=rwLock.readLock();
    Lock writeLock=rwLock.writeLock();
    private List<String> list;

    public ReadWriteLockExample(List<String> list){
        this.list=list;
    }


    public String get() throws InterruptedException {
        readLock.lock();
        try{
        String name=Thread.currentThread().getName();
        if(list.isEmpty()) return "暂时没有数据";
            return list.get(random.nextInt(list.size()));
        }finally {
            readLock.unlock();
        }
    }


    public void put(String item){

        writeLock.lock();
        try{
            list.add(item);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            writeLock.unlock();
        }

    }


    public static void main(String[] args) {

        List<String> datas=new ArrayList<>();

//        datas.add("a");
//        datas.add("b");
//        datas.add("c");





        ReadWriteLockExample lockExample=new ReadWriteLockExample(datas);


        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                while (true){
                    String name=Thread.currentThread().getName();
                    try {
                        System.out.println(name+" 消费了:"+lockExample.get());
//                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };


        new Thread(runnable,"读线程1").start();
        new Thread(runnable,"读线程2").start();
//        new Thread(runnable,"读线程3").start();


        Runnable putThread=new Runnable() {
            @Override
            public void run() {
                int count=0;
                while (true){
                    String name=Thread.currentThread().getName();
                    String value=name+"-"+count;
                    System.out.println(name+" 生产了=>"+value);
                    lockExample.put(value);
//                    try {
//                        TimeUnit.SECONDS.sleep(3);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    count++;
                }
            }
        };

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(putThread,"写线程A").start();
        new Thread(putThread,"写线程B").start();















    }



}
