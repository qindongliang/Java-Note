package concurrent.tools.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by qindongliang on 2018/9/1.
 */
public class ArrayBlockQueueDemo1 {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> queue=new ArrayBlockingQueue<String>(4);

        queue.put("a");
        queue.put("b");
        queue.put("c");
        queue.put("d");

//        System.out.println(queue.size());

        System.out.println(queue.take());
        System.out.println(queue.peek());

    }
}
