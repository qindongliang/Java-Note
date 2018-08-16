package concurrent.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * Created by Administrator on 2018/8/16.
 */
public class StampLockExample1 {

    private  static  int counter=0;


    public static void main(String[] args) {


        StampedLock sl=new StampedLock();



        Runnable readTask=()->{

            long stamp=sl.readLock();
            try {
                System.out.println(Thread.currentThread().getName()+" 开始读取 ");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" 读取 "+counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                sl.unlockRead(stamp);
            }

        };

        Runnable readOptimisticTask=()->{

            long stamp=sl.tryOptimisticRead();
            int cts=counter;
            try {
//                System.out.println("in optimistic lock"+sl.validate(stamp)+"  "+stamp);

                if(!sl.validate(stamp)) {//乐观读失败
                    System.out.println(Thread.currentThread().getName() +" 乐观读失败"+stamp);
                    stamp = sl.readLock();//转成读锁
                    try {
                        cts=counter;
                    }finally {
                        sl.unlockRead(stamp);
                    }

                }
//                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }


            System.out.println(Thread.currentThread().getName() + " 读取 " + cts);
        };


        Runnable writeTask=()->{

            long stamp=sl.writeLock();
            try {
                System.out.println(Thread.currentThread().getName()+" 开始写入 ");
                Thread.sleep(3000);
                counter++;
                System.out.println(Thread.currentThread().getName()+" 写入 "+counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                sl.unlock(stamp);
            }

        };


        Thread t1=new Thread(writeTask);
        Thread t2=new Thread(writeTask);
        Thread t3=new Thread(writeTask);
//        Thread t4=new Thread(readTask);//阻塞读
        Thread t4=new Thread(readOptimisticTask);//乐观读

        t1.start();
        t2.start();
        t4.start();
        t3.start();








    }

}
