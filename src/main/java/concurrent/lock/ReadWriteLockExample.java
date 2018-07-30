package concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        int index=random.nextInt(list.size());
        try{
            Thread.sleep(2000);
            return list.get(index);
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
        datas.add("a");
        datas.add("b");
        datas.add("c");





        ReadWriteLockExample lockExample=new ReadWriteLockExample(datas);


        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                while (true){
                    String name=Thread.currentThread().getName();

                    try {
                        System.out.println(name+" 打印了:"+lockExample.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };


        Thread t1=new Thread(runnable,"读线程1");
        Thread t2=new Thread(runnable,"读线程2");
        Thread t3=new Thread(runnable,"读线程3");

        t1.start();
        t2.start();
        t3.start();


        Thread t4=new Thread(()->{
             int count=0;
            while (true){
                String name=Thread.currentThread().getName();
                System.out.println();
                System.out.println(name+" 写入了"+count);
                System.out.println();
                lockExample.put(count+"");
                count++;
            }
        });

        t4.setName("写线程4");
        t4.start();













    }



}
