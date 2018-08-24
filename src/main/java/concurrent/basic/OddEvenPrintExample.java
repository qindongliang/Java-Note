package concurrent.basic;

/**
 * Created by qindongliang on 2018/7/12.
 * 使用两个线程交替按顺序打印奇数和偶数
 */
public class OddEvenPrintExample {


    /***
     * 监视器对象
     */
    static  class CounterGenerator{
        public  int incrementCount=1;//开始的打印的位置
        private int stopCount;//停止的位置

        public CounterGenerator(int incrementCount,int stopCount){
            this.incrementCount=incrementCount;
            this.stopCount=stopCount;
        }

    }


    /***
     * 偶数打印线程
     */
    static class EvenThread extends Thread{

         CounterGenerator counterGenrator;

         public EvenThread(CounterGenerator counterGenrator){
             this.setName("even thread");
             this.counterGenrator=counterGenrator;
         }

         @Override
         public void run() {
             try {
                 //终止条件
                 while (counterGenrator.incrementCount < counterGenrator.stopCount) {
                     //监视器加锁
                     synchronized (counterGenrator) {
                         //判断是奇数，就挂起等待
                         while (counterGenrator.incrementCount % 2 != 0) {
                             System.out.println("even thread wait ");
                             counterGenrator.wait();
                         }
                         //打印数字
                         System.out.println("even thread print " + counterGenrator.incrementCount);
                         counterGenrator.incrementCount++;//更新计数器
                         Thread.sleep(1000);//避免打印太快
                         counterGenrator.notify();//通知奇数线程
                     }

                 }

             }catch (Exception e){
                 e.printStackTrace();
             }
         }
     }


    /***
     * 奇数打印线程
     */
   static class OddThread extends Thread{

        CounterGenerator counterGenrator;
        public OddThread(CounterGenerator counterGenrator){
            this.setName("odd thread");
            this.counterGenrator=counterGenrator;

        }

        @Override
        public void run() {
            try {
                //终止条件
                while (counterGenrator.incrementCount < counterGenrator.stopCount) {
                    //监视器加锁
                    synchronized (counterGenrator) {
                        //判断是偶数，就挂起等待
                        while (counterGenrator.incrementCount % 2 == 0) {
                            System.out.println("odd thread wait ");
                            counterGenrator.wait();
                        }
                        //打印数字
                        System.out.println("odd thread print " + counterGenrator.incrementCount);
                        counterGenrator.incrementCount++;//更新计数器
                        Thread.sleep(1000);//避免打印太快
                        counterGenrator.notify();//通知偶数线程

                    }

                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {

        //监视器对象，两个参数分别是开始打印的位置与程序终止的位置
        CounterGenerator counterGenerator=new CounterGenerator(1,10);
        //奇数打印线程
        OddThread oddThread=new OddThread(counterGenerator);
        //偶数打印线程
        EvenThread evenThread=new EvenThread(counterGenerator);
        oddThread.start();
        evenThread.start();

    }

}
