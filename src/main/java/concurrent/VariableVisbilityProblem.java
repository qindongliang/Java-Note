package concurrent;

/**
 * Created by qindongliang on 2018/6/25.
 */
public class VariableVisbilityProblem {

    static boolean keepRunning=true;

    public static void main(String[] args) throws InterruptedException {


        // 在主线程里面启动一个子线程
        new Thread(()->{

            while (keepRunning){

//                System.out.println();

            }


        }).start();



        Thread.sleep(1000);
        //在主线程中改变变量状态 ， 循环不会终止
        //说明两个线程之间的修改是可见的
        keepRunning=false;


        //println 语句里面是同步的，所以根据happen-before关系是会终止循环的

        // 此外Thread.sleep()方法也会终止，这比较奇怪，因为oracle
        //官网明确指出sleep和yield方法没有同步语义，这个问题我暂时
        //想不明白，如果你想明白了，请一定告诉我。




    }




}
