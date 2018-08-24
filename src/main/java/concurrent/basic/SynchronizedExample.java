package concurrent.basic;

/**
 * Created by qindongliang on 2018/7/8.
 */
public class SynchronizedExample {


    private static volatile int a=3;

    public  SynchronizedExample() {
    }

    public static  synchronized  void demo2(){

        a++;

    }

    public synchronized void  demo4(){

        System.out.println(a);
    }

    public void show(){

        System.out.println(a);
    }


    public void demo1(){

        //1

        int a=1;
        int x=3;

        // 2
        synchronized (this){
            int b=5;
            StringBuffer buffer=new StringBuffer("abc");
            int c=6;
        }

        //3
        int e=4;
        int y=7;

    }


    public static void main(String[] args) {






    }

}
