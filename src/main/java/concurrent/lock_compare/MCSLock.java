package concurrent.lock_compare;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Administrator on 2018/8/4.
 */
public class MCSLock  {

    AtomicReference<QNode> tail;

    ThreadLocal<QNode> myNode;


    class QNode{
        boolean locked;
        QNode next;
    }


    public  void lock(){

        QNode qNode=myNode.get();

        QNode pred=tail.getAndSet(qNode);

        if(pred!=null){
            qNode.locked=true;
            pred.next=qNode;
            // wait until predecessor give up the lock
            while(qNode.locked){}
        }
    }

    public void unlock(){

        QNode qNode=myNode.get();

        if(qNode.next==null){

            if(tail.compareAndSet(qNode,null)){
                return;
            }
            // wait until predecessor fills in its next field
            while (qNode.next==null){}
        }

        qNode.next.locked=false;
        qNode.next=null;

    }







}
