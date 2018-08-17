package concurrent.lock;

import java.util.Random;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by Administrator on 2018/8/17.
 */
public class StampLockPointExample2 {

    private double x,y;
    private final StampedLock s1=new StampedLock();

    //exclusively lock
    public void move(double moveX,double moveY) throws InterruptedException {
        long stamp=s1.writeLock();
        System.out.println(Thread.currentThread().getName()+"  get the write lock.... ("+moveX+","+moveY+")");
        try{
            x+=moveX;
            y+=moveY;

            Thread.sleep(3000);
        }finally {
            s1.unlockWrite(stamp);
        }

    }


    // A read-only method
    public double distanceFromOrigin(){

        long stamp=s1.tryOptimisticRead();//
        double curentX=x , currentY=y;
        if(!s1.validate(stamp)){ //  Has been changed by another thread
            stamp=s1.readLock(); // require Read-Lock
            System.out.println(Thread.currentThread().getName()+"  optimistic read fail , beginning the block  ");
            try {
                curentX = x;
                currentY = y;
            }finally {
                s1.unlockRead(stamp);
            }

        }
        System.out.println(Thread.currentThread().getName()+" read result (x="+curentX+","+currentY+")");
        // if the stamp is valid , return immediately
        return Math.sqrt(curentX*curentX+currentY*currentY);
    }


    public void moveIfAtOrigin(double newX,double newY) throws InterruptedException {

        long stamp=s1.readLock(); // could instead

        System.out.println(Thread.currentThread().getName()+"  into execute.... ");
        try{
            while (x==0.0&&y==0.0){
                //try get the writeLock => "upgrade read lock"
                long ws=s1.tryConvertToWriteLock(stamp);
                if(ws!=0L){ // update data if upgrade success
                    System.out.println(Thread.currentThread().getName()+"  upgrade read lock success ..... ");
                    Thread.sleep(3000);
                    stamp=ws;
                    x=newX;
                    y=newY;
                    break;
                }else {
                    System.out.println(Thread.currentThread().getName()+" get write lock if  upgrade read lock fail  ..... ");
                    // unlock read lock if upgrade fail
                    s1.unlockRead(stamp);
                    // apply write lock
                    stamp=s1.writeLock();
                }
            }

        }finally {
            s1.unlock(stamp);
        }


    }


    public static void main(String[] args) {

        StampLockPointExample2 lockPoint=new StampLockPointExample2();
        Random random=new Random();
        Runnable write=()->{
            try {
//                lockPoint.move(random.nextDouble(),random.nextDouble());
                lockPoint.moveIfAtOrigin(random.nextDouble(),random.nextDouble());
            } catch (Exception e) {
                e.printStackTrace();
            }

        };

        Runnable read=()->{
                lockPoint.distanceFromOrigin();
        };


        Thread t1=new Thread(write);
        Thread t2=new Thread(write);
        Thread t3=new Thread(write);
        Thread t4=new Thread(read);
        Thread t5=new Thread(read);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();


    }





}
