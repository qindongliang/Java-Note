package concurrent.cas;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by qindongliang on 2018/7/18.
 */
public class CasExample {


    private static AtomicBoolean flag=new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {



        new Thread(()->{


            while (flag.get()){

            }


        }).start();


        Thread.sleep(2000);

        System.out.println("main end ....");

        flag.set(false);


    }


}
