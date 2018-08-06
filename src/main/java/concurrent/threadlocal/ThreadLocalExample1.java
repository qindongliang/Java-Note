package concurrent.threadlocal;

/**
 * Created by Administrator on 2018/8/6.
 */
public class ThreadLocalExample1 {

    static final ThreadLocal counter=new ThreadLocal();

    public static void main(String[] args) {


        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <10 ; i++) {

                    counter.set(i);
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+" 打印"+counter.get() );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };




        Thread t1=new Thread(runnable,"线程1");
        Thread t2=new Thread(runnable,"线程2");
        Thread t3=new Thread(runnable,"线程3");


        t1.start();
        t2.start();
        t3.start();


    }


}
