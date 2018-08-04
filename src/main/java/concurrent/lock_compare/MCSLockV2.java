package concurrent.lock_compare;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by Administrator on 2018/8/4.
 */
public class MCSLockV2 {


     class MNode{

        volatile MNode next;
        volatile boolean locked=true;

    }

     //当前线程的引用MNode
    ThreadLocal<MNode> current=new ThreadLocal<>();

    //指向最后一个申请锁的MNode
    volatile MNode tail;

    /**
     * 原子更新器
     */
    final AtomicReferenceFieldUpdater UPDATER = AtomicReferenceFieldUpdater.newUpdater(
                    MCSLockV2.class,
                    MCSLockV2.MNode.class,
                    "tail");




}
