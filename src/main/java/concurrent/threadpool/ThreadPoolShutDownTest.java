package concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolShutDownTest {

    public static void main(String[] args) throws InterruptedException {


        ExecutorService executor= Executors.newFixedThreadPool(1);


        executor.submit(new Runnable() {
            @Override
            public void run() {

                while (true){

                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("被打断了.....");
                        break;
                    }

                }

            }
        });

//        executor.shutdown();//不在接受新的任务，正在执行和等待的任务会被执行完成
        executor.shutdownNow();//会对每个线程发送Interrupted指令，通过线程内部做优雅的关闭。

        // 上面的两个方法，不会阻塞，会立即返回。
        // 如果阻塞等待，需要使用下面的方法

        //如果在指定时间内结束返回true，终止超时, 返回false，我们取反来判断，是不是超时
        if(!executor.awaitTermination(3, TimeUnit.SECONDS)){
            System.out.println("等待了3秒之后，仍然没有停止,使用 System.exit(0)");
            System.exit(0);
        }


        System.out.println("正常停止.......");




    }
}
