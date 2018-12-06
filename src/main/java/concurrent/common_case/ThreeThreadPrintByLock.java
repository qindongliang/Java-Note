package concurrent.common_case;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * 基于Lock实现的，三个线程轮流交替分别打印A，B，C，10次
 */
public class ThreeThreadPrintByLock {


     static class PrintABC{

         Lock lock=new ReentrantLock();

         Condition conA=lock.newCondition();
         Condition conB=lock.newCondition();
         Condition conC=lock.newCondition();
         volatile  int count=1;
         String id="A";
         int limit=2;


         public void printA() throws InterruptedException {
                while(count<limit) {
                 lock.lock();
                 try {
                     while (!id.equals("A")) {
                         conA.await();
                     }
                     System.out.println(Thread.currentThread().getName() + "打印： " + id);
                     id = "B";
                     conB.signal();
                 } finally {
                     lock.unlock();
                 }

             }

         }

         public void printB() throws InterruptedException {
             while(count<limit) {
                 lock.lock();
                 try {
                     while (!id.equals("B")) {
                         conB.await();
                     }
                     System.out.println(Thread.currentThread().getName() + "打印： " + id);
                     id = "C";
                     conC.signal();

                 } finally {
                     lock.unlock();
                 }
             }

         }

         public void printC() throws InterruptedException {


             while (count < limit+1) {
                 lock.lock();
                 try {
                     while (!id.equals("C")) {
                         conC.await();
                     }
                     System.out.println(Thread.currentThread().getName() + "打印： " + id + " \n");
                     id = "A";
                     count = count + 1;
                     conA.signal();

                 } finally {
                     lock.unlock();
                 }

             }
         }




    }


    public static void main(String[] args) {



        PrintABC printABC=new PrintABC();


        Thread t1=new Thread(()->{
            try {
                printABC.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t1.setName("A线程");


        Thread t2=new Thread(()->{
                try {
                    printABC.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });
        t2.setName("B线程");

        Thread t3=new Thread(()->{
                try {
                    printABC.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        });
        t3.setName("C线程");

        t2.start();
        t3.start();
        t1.start();



    }


}
