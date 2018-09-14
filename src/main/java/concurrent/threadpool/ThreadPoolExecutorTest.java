package concurrent.threadpool;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


//        ThreadPoolExecutor pool=(ThreadPoolExecutor)Executors.newFixedThreadPool(1);
        //测试拒绝策略，
        ThreadPoolExecutor pool=new ThreadPoolExecutor(1,1,
                60,TimeUnit.SECONDS,new LinkedBlockingQueue<>(1));

//        pool.allowCoreThreadTimeOut(true);


//     FutureTask result=(FutureTask)pool.submit(new Runnable() {
//            @Override
//            public void run() {
//
//                System.out.println("go......");
//            }
//        });


        FutureTask<String> f1=(FutureTask) pool.submit(new Callable<String>() {

            @Override
            public String call() throws InterruptedException {

                System.out.println(Thread.currentThread().getName()+"  println ok1   ");
                TimeUnit.MINUTES.sleep(1253);
                System.out.println(Thread.currentThread().getName()+"  println ok2   ");
                return "ok2";
            }
        });




//        pool.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+" 运行了......");
//            }
//        });


       FutureTask<Integer> get=(FutureTask) pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ok....");
            }
        },456);


        FutureTask<Integer> get1=(FutureTask) pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ok111....");
            }
        },456111);

        System.out.println(get1.get());
        pool.shutdown();



    }

}
