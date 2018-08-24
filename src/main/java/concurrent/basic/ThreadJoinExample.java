package concurrent.basic;

/**
 * Created by Administrator on 2018/6/26.
 */
public class ThreadJoinExample {


    public static void main(String[] args) throws InterruptedException {

        // join方法，会让主线程等待当前线程执行完，再执行本身
        // join（time）可以让主线程阻塞指定的时间

       Thread t1=  new Thread(()->{

           System.out.println(Thread.currentThread().getName());
           try {
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           System.out.println("3 second ....");

       });

        Thread t2=  new Thread(()->{

            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("2 second ....");

        });

        //下面是串行执行
        t1.start();
        t1.join();
        //必须t1执行完才会执行下面的t2线程
        t2.start();
        t2.join();


        //下面是并行执行
        //t1.start();
        //t2.start();
        //t1.join();
        //t2.join();



        System.out.println("main thread");



    }

}
