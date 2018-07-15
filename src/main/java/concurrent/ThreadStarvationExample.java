package concurrent;

/**
 * Created by qindongliang on 2018/7/15.
 * 线程饥饿例子
 */
public class ThreadStarvationExample {


    static class Worker{




        public synchronized void work() throws InterruptedException {
            String name=Thread.currentThread().getName();

            System.out.println(name+ "begin ....");



            while(true){

                System.out.println(name+" is working .....  ");
                Thread.sleep(1000);
//                wait(10);  加上这段，可以在空闲的时候释放cpu

            }




        }



    }




    public static void main(String[] args) {



        Worker worker=new Worker();


         new Thread(()->{
             try {
                 worker.work();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }).start();




        new Thread(()->{
            try {
                worker.work();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }


}
