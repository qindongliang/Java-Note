package concurrent.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by qindongliang on 2018/9/15.
 */
public class CompeletionServiceTest {


    public static void testCompletionService(ExecutorService pool)throws  Exception{

        //使用包装的类，进行提交，所有完成的任务会提交到一个队列里面
        //如果用原来的Future接口是不知道任务是否完成，需要循环遍历判断状态
        CompletionService service=new ExecutorCompletionService(pool);

        int taskNum=3;
        //必须用servic提交，不能用pool
        for (int i = 0; i <taskNum ; i++) {
            service.submit(getCall());

        }

        for (int i = 0; i <taskNum; i++) {
            Future<String>  result= service.take();
            System.out.println(result.get());
        }



    }


    public  static Callable<String> getCall(){

        Callable<String> run=new Callable() {
            @Override
            public String call() {
                Random random=new Random();
                String name=Thread.currentThread().getName();
                int sleep=random.nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String result= name+"执行完成了，睡了"+sleep+"秒";
                return result;
            }
        };

        return run;
    }


    public static void testFuture(ExecutorService pool) throws ExecutionException, InterruptedException {



        int taskNum=3;
        List<Future> futures=new ArrayList<>();

        for (int i = 0; i < taskNum; i++) {
            futures.add(pool.submit(getCall()));
        }

        for(Future future:futures){

            System.out.println(future.get());
        }


    }


    public static void main(String[] args) throws Exception {

        ExecutorService pool= Executors.newFixedThreadPool(6);
        testFuture(pool);//test future
        System.out.println("==================");
        testCompletionService(pool); //test comletionservice
        pool.shutdown();








    }

}
