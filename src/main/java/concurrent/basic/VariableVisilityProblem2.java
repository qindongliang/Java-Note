package concurrent.basic;

/**
 * Created by qindongliang on 2018/7/9.
 */
public class VariableVisilityProblem2 {

    private  static boolean flag=true; // main thread will call flag=false

    private final static Object lock=new Object(); // lock condition

    public static void thread1(){

        while (flag){

            synchronized (lock){
                // some work
            }

        }

    }


    public static void main(String[] args) throws Exception {

        Thread t1=new Thread(()->{
            thread1();
        });
        t1.start();
        Thread.sleep(1000);
        flag=false;

        // The program can stop normally

    }



}
