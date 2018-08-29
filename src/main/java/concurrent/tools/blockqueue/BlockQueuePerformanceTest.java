package concurrent.tools.blockqueue;

import java.util.concurrent.*;

/**
 * Created by qindongliang on 2018/8/29.
 */
public class BlockQueuePerformanceTest {

    static ExecutorService e= Executors.newFixedThreadPool(2);
    static int n=100;

    public static void main(String[] args) throws Exception {

        System.out.println("len , linkqueue, arrayqueue, synchronousqueue");
        for (int i = 0; i < 10; i++) {
            int length = (i == 0) ? 1 : i * 5;
            System.out.print(length + "\t");
            System.out.print(doTest(new LinkedBlockingQueue<Integer>(length), n) + "\t");
            System.out.print(doTest(new ArrayBlockingQueue<Integer>(length), n) + "\t");
            System.out.print(doTest(new SynchronousQueue<Integer>(), n));
            System.out.println();
        }

        e.shutdown();





    }


    private static long doTest(final BlockingQueue<Integer> q, final int n) throws Exception {
        long t = System.nanoTime();

        e.submit(new Runnable() {
            public void run() {
                for (int i = 0; i < n; i++)
                    try { q.put(i); } catch (InterruptedException ex) {}
            }
        });

        Long r = e.submit(new Callable<Long>() {
            public Long call() {
                long sum = 0;
                for (int i = 0; i < n; i++)
                    try { sum += q.take(); } catch (InterruptedException ex) {}
                return sum;
            }
        }).get();
        t = System.nanoTime() - t;

        return (long)(1000000000.0 * n / t); // Throughput, items/sec
    }


}
