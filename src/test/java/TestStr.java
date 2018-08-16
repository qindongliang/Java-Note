import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2018/7/12.
 */
public class TestStr {

    public static void main(String[] args) throws InterruptedException {


        AtomicInteger atomicInteger=new AtomicInteger();


        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=10000;i++){
                    atomicInteger.getAndIncrement();
                }

            }
        };

        Thread t1=new Thread(runnable);
        Thread t2=new Thread(runnable);
        Thread t3=new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();


        System.out.println(atomicInteger.get());


    }
}
