package concurrent.async;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AsyncTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


//      noReturnValue();

//        useReturnValue();
//        useReturnValueAndComplete();
        chainFuture();
        System.out.println("finished......");

    }

    public static void chainFuture() throws ExecutionException, InterruptedException {

        CompletableFuture<String> future=CompletableFuture.supplyAsync(()->getHello());
       future= future.thenApply(s->s+" World").thenApply(String::toLowerCase);

        System.out.println(future.get());
    }


    public static void useReturnValueAndComplete() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future=CompletableFuture.supplyAsync(()->getHello());
        Thread.sleep(3000);
        future.complete("完成");

        System.out.println(future.get());
    }

    public static void useReturnValue() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future=CompletableFuture.supplyAsync(()->getHello());
        System.out.println(future.get());
    }

    public static String  getHello(){


        return "Hello Return Value";
    }


    public static void noReturnValue() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future=CompletableFuture.runAsync(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Hello");
                    }
                }
        );

        future.get();
    }


}
