package concurrent.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Administrator on 2018/7/31.
 */
public class ReadWriteDeadLockExample {

    static  ReadWriteLock rwlock=new ReentrantReadWriteLock();

    //写锁降级,正常运行
    static void downgradeLock(){
        rwlock.writeLock().lock();
        System.out.println("down 1");
        rwlock.readLock().lock();
        System.out.println("down 2");
        rwlock.writeLock().unlock();
        System.out.println("down 3");
        rwlock.readLock().unlock();
        System.out.println("down 4");
    }


    //读锁升级写锁，下面的这段代码会发生死锁
    //正确的方法，应该先使用trylock看看是否有资格获取锁
    static void upgradeLock(){
        rwlock.readLock().lock();
        System.out.println(" up 1 ");
//        System.out.println(rwlock.writeLock().tryLock());
        rwlock.writeLock().lock();
        System.out.println(" up 2 ");
        rwlock.readLock().unlock();
        System.out.println(" up 3 ");
        rwlock.writeLock().unlock();
        System.out.println(" up 4 ");
    }




    public static void main(String[] args) {
        downgradeLock();
//        upgradeLock();

    }
}
