package concurrent.live_lock_demo;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/7/20.
 */
public class FinalExample {


    static int b=50;
    private  static  int[] array ={0,0,0};
    static  int c=60;
    public static void main(String[] args) throws InterruptedException {


        Thread t1=new Thread(()->{




            while(true){

//                 array.clone();
                if(array[1]==100) {
                    System.out.println(b+ " "+array[1]+" "+c);
//                    System.out.println(array[1]);
//                    System.out.println(c);
                    break;
                }
            }

//            array[1]=500;

            System.out.println("end");




        });


        t1.start();

        Thread.sleep(3000);
        b=100;
        array[1]=100;
        c=200;
//        System.out.println(Arrays.toString(array));



    }
}
