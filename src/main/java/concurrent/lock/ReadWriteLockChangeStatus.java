package concurrent.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by qindongliang on 2018/7/30.
 */
public class ReadWriteLockChangeStatus {



    public void downgrade(ReadWriteLock readWriteLock){

        boolean downgrade=false;
        //使用写锁
        readWriteLock.writeLock().lock();

        try {
            boolean readLockAcquired = readWriteLock.readLock().tryLock();
            if (readLockAcquired) {
                System.out.println("写锁降级读锁成功");
//                System.out.println("当前持有读锁的数量：" + ((ReentrantReadWriteLock) readWriteLock).getReadHoldCount());
//                System.out.println("当前持有写锁的数量：" + ((ReentrantReadWriteLock) readWriteLock).getWriteHoldCount());

                //释放写锁
                readWriteLock.writeLock().unlock();

                downgrade = true;

                try {
                    // 使用读锁处理的读取逻辑

                } finally {
                    // 释放读锁
                    readWriteLock.readLock().unlock();

                }


            }else{
                System.out.println("写锁降级读锁失败");
            }
        }finally {
            // 如果重入读锁失败，则需要手动释放写锁
            if(!downgrade){
                System.out.println("写锁降级读锁失败，手动释放写锁");
                readWriteLock.writeLock().unlock();
            }

//            System.out.println("当前持有读锁的数量：" + ((ReentrantReadWriteLock) readWriteLock).getReadHoldCount());
//            System.out.println("当前持有写锁的数量：" + ((ReentrantReadWriteLock) readWriteLock).getWriteHoldCount());



        }


    }


    public void upgrade(ReadWriteLock readWriteLock){

        boolean upgrade=false;
        //加读锁
        readWriteLock.readLock().lock();

        try{
            boolean writeLockAcquire=readWriteLock.writeLock().tryLock();

              if(writeLockAcquire){
                  System.out.println("读锁升级写锁成功");

                  readWriteLock.readLock().unlock();

                  upgrade=true;

                  try{
                      //如果升级成功，就做相关的更新写入逻辑
                  }finally {

                      readWriteLock.writeLock().unlock();
                  }

              }  else {
                  System.out.println("读锁升级写锁失败");
              }

        }finally {

            //如果升级写锁失败，则需要手动释放读锁
            if(!upgrade){

                readWriteLock.readLock().unlock();
            }


        }







    }




    public static void main(String[] args) {

         ReadWriteLock lock=new ReentrantReadWriteLock();

         ReadWriteLockChangeStatus changeStatus=new ReadWriteLockChangeStatus();

         //写锁降级读锁
         changeStatus.downgrade(lock);
         //读锁升级写锁
         changeStatus.upgrade(lock);




    }

}


