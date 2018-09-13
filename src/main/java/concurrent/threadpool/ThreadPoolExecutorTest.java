package concurrent.threadpool;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ThreadPoolExecutor pool=(ThreadPoolExecutor)Executors.newFixedThreadPool(2);

//        pool.allowCoreThreadTimeOut(true);


//     FutureTask result=(FutureTask)pool.submit(new Runnable() {
//            @Override
//            public void run() {
//
//                System.out.println("go......");
//            }
//        });


//        FutureTask<String> f1=(FutureTask) pool.submit(new Callable<String>() {
//
//            @Override
//            public String call() {
//
//                System.out.println(Thread.currentThread().getName()+"  println ok2   ");
//                return "ok2";
//            }
//        });

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

        System.out.println(get.get());
        pool.shutdown();



    }

}
