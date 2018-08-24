package concurrent.basic;

/**
 * Created by Administrator on 2018/6/27.
 */
public class WaitNotifyExample {

    private static String message;

    public static void main(String[] args) throws InterruptedException {


        Object lock=new Object();


        Thread t1=new Thread(()->{

            synchronized (lock){
                System.out.println("message: "+message);


                while (message==null){
                    try {
                        System.out.println("开始阻塞...1");
                        lock.wait();
                        System.out.println("开始阻塞...2");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println(message);
            }


        });

//
//        Thread t2=new Thread(()->{
//
//            synchronized (lock){
//                message="a message from thread ! ";
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                lock.notify();
//
//            }
//
//
//        });


        t1.start();


        Thread.sleep(3000);

        synchronized (lock) {
            lock.notify();

        }
//        t1.interrupt();

//        System.exit(0);

//        t2.start();




    }


}
