package concurrent.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by qindongliang on 2018/8/5.
 */
public class CLHLock {

     class Node{
         //false代表没人占用锁
      volatile   boolean locked=false;
    }

    //指向最后加入的线程
  final   AtomicReference<Node> tail=new AtomicReference<>(new Node());

    //使用ThreadLocal保证每个线程副本内都有一个Node对象
  final   ThreadLocal<Node> current;


    public CLHLock(){
        //初始化当前节点的node
        current=new ThreadLocal<Node>(){
            @Override
            protected Node initialValue() {
                return new Node();
            }
        };


    }


    public void lock() throws InterruptedException {

       //得到当前线程的Node节点
       Node own=current.get();
        //修改为true，代表当前线程需要获取锁
        own.locked=true;

        //设置当前线程去注册锁，注意在多线程下环境下，这个
        //方法仍然能保持原子性，，并返回上一次的加锁节点（前驱节点）
        Node preNode=tail.getAndSet(own);

        //在前驱节点上自旋
        while(preNode.locked){
            System.out.println(Thread.currentThread().getName()+" 开始自旋....  ");
            Thread.sleep(2000);
        }


    }

    public void unlock(){

        //当前线程如果释放锁，只要将占用状态改为false即可
        //因为其他的线程会轮询自己，所以volatile布尔变量改变之后
        //会保证下一个线程能立即看到变化，从而得到锁
        current.get().locked=false;

    }


    public static void main(String[] args) throws InterruptedException {

        CLHLock lock=new CLHLock();

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"  获得锁 ");
                    //前驱释放，do own work
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+"  释放锁 ");
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1=new Thread(runnable,"线程1");
        Thread t2=new Thread(runnable,"线程2");
        Thread t3=new Thread(runnable,"线程3");

        t1.start();
        t2.start();
        t3.start();




    }




}
