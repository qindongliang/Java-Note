package concurrent.spinlock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by qindongliang on 2018/8/5.
 */
public class MCSLock {

    class Node{
      volatile   Node next;//后继节点
        //默认false
      volatile   boolean locked;
    }

    //指向最后加入的线程
    final AtomicReference<MCSLock.Node> tail=new AtomicReference<>(null);

    ThreadLocal<Node> current;

    public MCSLock(){
        //初始化当前节点的node
        current=new ThreadLocal<MCSLock.Node>(){
            @Override
            protected MCSLock.Node initialValue() {
                return new MCSLock.Node();
            }
        };
    }


    public void lock() throws InterruptedException {

        //获取当前线程的Node
        Node own=current.get();

        //获取前驱节点
        Node preNode=tail.getAndSet(own);

        //如果前驱节点不为null，说明有线程已经占用
        if(preNode!=null){
            //设置当前节点为需要占用状态；
            own.locked=true;
            //把前面节点的next指向自己
            preNode.next=own;

            //在自己的节点上自旋等待前驱通知
            while(own.locked){

                System.out.println(Thread.currentThread().getName()+" 开始自旋....  ");
                Thread.sleep(2000);

            }


        }

        System.out.println(Thread.currentThread().getName()+" 获得了锁....  ");

    }


    public void unlock(){
        //获取自己的节点
        Node own=current.get();
        //
        if(own.next==null){
            //判断是不是自身是不是最后一个线程
            if(tail.compareAndSet(own,null)){
                //是的话就结束
                return;
            }

            //在判断过程中，又有线程进来
            while (own.next==null){

            }

        }
        //本身解锁，通知它的后继节点可以工作了，不用再自旋了
        own.next.locked=false;
        own.next=null;// for gc


    }

    public static void main(String[] args) {

        MCSLock lock=new MCSLock();

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"  获得锁 ");
                    //前驱释放，do own work
                    Thread.sleep(4000);
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
