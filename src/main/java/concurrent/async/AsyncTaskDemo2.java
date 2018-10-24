package concurrent.async;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AsyncTaskDemo2 {

    public static String getThreadName(){
        return Thread.currentThread().getName()+"线程=> ";
    }

    public static void main(String[] args) throws Throwable {

        //manuallyFinish();//简单的使用
        //runSimpleAsyncTask();//运行一个简单的无返回值的异步任务
        //normalAsyncTask();//运行一个简单的有返回值的异步任务
//        asyncCallback();//有回调的调用
//        asyncCallback2();//有回调的调用2

//        asyncCallback3();//有回调的调用3

       // asyncCallback4();//有回调的调用4，使用了多个异步任务提交

//        nestedCompletableFuture();//嵌套的future.
//        asyncCompose();//合并两个具有依赖关系的future任务
       // noDependCombine();//合并两个没有依赖关系的任务
//        mutilTaskAllofTest();//多个任务执行完后，处理一些任务
      //  mutilTaskAnyofTest();//多个任务中，只要一个完成，就整体完成

//        exceptionCatch();//异常处理1
        exceptionHandleCatch();//异常处理2

    }

    public static void exceptionHandleCatch() throws ExecutionException, InterruptedException {

        int age=-1;
        CompletableFuture<String> task= CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {

                if(age<0){
                    throw new IllegalArgumentException("性别必须大于0");
                }

                if(age<18){
                    return "未成年人";
                }

                return "成年人";
            }
        }).handle((res,ex)->{
            System.out.println("执行handle");
            if(ex!=null){
                System.out.println("发生异常");
                return "发生 异常"+ex.getMessage();
            }

            return res;
        });


        System.out.println(task.get());

    }



    public static void exceptionCatch() throws ExecutionException, InterruptedException {
        int age=-1;
       CompletableFuture<String> task= CompletableFuture.supplyAsync(new Supplier<String>() {
           @Override
           public String get() {

               if(age<0){
                   throw new IllegalArgumentException("性别必须大于0");
               }

               if(age<18){
                   return "未成年人";
               }

               return "成年人";
           }
       }).exceptionally(ex->{
           System.out.println(ex.getMessage());
           return "发生 异常"+ex.getMessage();
       });


        System.out.println(task.get());

    }


    public static void mutilTaskAnyofTest() throws ExecutionException, InterruptedException {


        CompletableFuture<String> f1=CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "wait 4 seconds";
            }
        });

        CompletableFuture<String> f2=CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "wait 2 seconds";
            }
        });


        CompletableFuture<String> f3=CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(4);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "wait 10 seconds";
            }
        });



       CompletableFuture<Object> result= CompletableFuture.anyOf(f1,f2,f3);


        System.out.println(result.get());




    }



    public static void mutilTaskAllofTest() throws ExecutionException, InterruptedException {

         //添加n个任务
        CompletableFuture<Double> array[]=new CompletableFuture[3];
        for ( int i = 0; i < 3; i++) {
            array[i]=CompletableFuture.supplyAsync(new Supplier<Double>() {
                @Override
                public Double get() {
                    return Math.random();
                }
            });
        }

       //获取结果的方式一
//       CompletableFuture.allOf(array).get();
//        for(CompletableFuture<Double> cf:array){
//            if(cf.get()>0.6){
//                System.out.println(cf.get());
//            }
//        }
        //获取结果的方式二，过滤大于指定数字，在收集输出
       List<Double> rs= Stream.of(array).map(CompletableFuture::join).filter(number->number>0.6).collect(Collectors.toList());
       System.out.println(rs);

    }




    public static void noDependCombine()throws ExecutionException, InterruptedException{

        CompletableFuture<Double>  d1= CompletableFuture.supplyAsync(new Supplier<Double>() {
            @Override
            public Double get() {
                return 1d;
            }
        });


        CompletableFuture<Double>  d2= CompletableFuture.supplyAsync(new Supplier<Double>() {
            @Override
            public Double get() {
                return 2d;
            }
        });


      CompletableFuture<Double> result=  d1.thenCombine(d2,(number1,number2)->{
            return  number1+number2;
        });


        System.out.println(result.get());



    }



    public static void asyncCompose() throws ExecutionException, InterruptedException {

        CompletableFuture<String>  future1=CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "1";
            }
        });

       CompletableFuture<String>nestedResult = future1.thenCompose(value->
               CompletableFuture.supplyAsync(()->{
                return value+"2";
       }));

        System.out.println(nestedResult.get());
    }


    public static void nestedCompletableFuture() throws ExecutionException, InterruptedException {

        CompletableFuture<String>  future1=CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {


                return "1";
            }
        });

        CompletableFuture<CompletableFuture<String>> nestedResult = future1.thenApply(value->{
          return  CompletableFuture.supplyAsync(()->{
                return value+"2";
            });
        });

        System.out.println(nestedResult.get().get());



    }


    public  static void asyncCallback4() throws ExecutionException, InterruptedException {

        CompletableFuture<String> ref1=  CompletableFuture.supplyAsync(()->{
            try {
                System.out.println(getThreadName()+"supplyAsync开始执行任务1.... ");
//                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(getThreadName()+"supplyAsync: 任务1");
            return null;
        });

        CompletableFuture<String> ref2= CompletableFuture.supplyAsync(()->{
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(getThreadName()+"supplyAsync: 任务2");
            return null;
        });

        CompletableFuture<String> ref3=ref2.thenApplyAsync(value->{
            System.out.println(getThreadName()+"thenApplyAsync: 任务2的子任务");
            return  null;
        });


//        Thread.sleep(4000);
        System.out.println(getThreadName()+ref3.get());
    }


    public  static void asyncCallback3() throws ExecutionException, InterruptedException {
      CompletableFuture<Void> ref=  CompletableFuture.supplyAsync(()->{
            try {
                System.out.println(getThreadName()+" 开始执行.... ");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getThreadName()+"supplyAsync: 一阶段任务");
            return null;
        }).thenRun(()->{
            System.out.println(getThreadName()+"thenRun: 收尾任务");
        });


        System.out.println(getThreadName());
        Thread.currentThread().setDaemon(false);
    }


    public static void asyncCallback2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> task=CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(getThreadName()+"supplyAsync");
                return "123";
            }
        });

        CompletableFuture<Integer> chain1 = task.thenApply(number->{
            System.out.println(getThreadName()+"thenApply1");
            return Integer.parseInt(number);
        });

        CompletableFuture<Integer> chain2 = chain1.thenApply(number->{
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getThreadName()+"thenApply2");
            return number*2;
        });

       CompletableFuture<Void> result=chain2.thenAccept(product->{
           System.out.println(getThreadName()+"thenAccept="+product);
       });

        result.get();
        System.out.println(getThreadName()+"end");


    }


    public static void asyncCallbackLambda() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> task=CompletableFuture.supplyAsync(()->"123")
                .thenApply(number->Integer.parseInt(number))
                .thenApply(count->count*10);
        System.out.println(task.get());
    }

    public static void asyncCallback() throws ExecutionException, InterruptedException {

        CompletableFuture<String> task=CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(getThreadName()+"supplyAsync");
                return "123";
            }
        });

        CompletableFuture<Integer> result1 = task.thenApply(number->{
            System.out.println(getThreadName()+"thenApply1");
            return Integer.parseInt(number);
        });

        CompletableFuture<Integer> result2 = result1.thenApply(number->{
            System.out.println(getThreadName()+"thenApply2");
            return number*2;
        });

        System.out.println(getThreadName()+" => "+result2.get());

    }


    public static void normalAsyncTask() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future=CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {

                try {
                    System.out.println(getThreadName()+"正在执行一个有返回值的异步任务。");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return "OK";
            }
        }, ForkJoinPool.commonPool());

        String result=future.get();

        System.out.println(getThreadName()+"  结果："+result);


    }


    public static void  runSimpleAsyncTask() throws ExecutionException, InterruptedException {

        CompletableFuture<Void> future=CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(getThreadName()+"正在执行一个没有返回值的异步任务。");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        future.get();
        System.out.println(getThreadName()+" 结束。");
    }


    /***
     * 一个简单的例子，通过手动终止future
     * @throws Exception
     */
    public static  void manuallyFinish()throws Exception{

        CompletableFuture<String> completableFuture=new CompletableFuture<String>();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(getThreadName()+"执行.....");
                    completableFuture.complete("success");//在子线程中完成主线程completableFuture的完成

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1=new Thread(runnable);
        t1.start();//启动子线程

        String result=completableFuture.get();//主线程阻塞，等待完成
        System.out.println(getThreadName()+"1x:  "+result);


    }


}
