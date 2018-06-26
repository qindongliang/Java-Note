package concurrent;

/**
 * Created by Administrator on 2018/6/26.
 */
public class ThreadJoinExample {


    public static void main(String[] args) throws InterruptedException {

        // join方法，会让主线程等待当前线程执行完，再执行本身
        // join（time）可以让主线程阻塞指定的时间

       Thread tx=  new Thread(()->{

           System.out.println(Thread.currentThread().getName());
           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

           System.out.println("5 second ....");

       });

        tx.start();
        tx.join(1000);

        System.out.println("txx");



    }

}
