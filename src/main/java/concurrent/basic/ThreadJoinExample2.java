package concurrent.basic;

public class ThreadJoinExample2 {


    public static void main(String[] args) throws InterruptedException {


        System.out.println( "123" );

        //join方法，会阻塞调用者线程，比如在main线程里面，执行t1.join()方法，会阻塞main线程知道t1线程执行完毕
        //如果main线程自己调用join方法，那么自己永远存活，对应这个mian线程就会永远不会退出
        Thread.currentThread().join();



    }


}
