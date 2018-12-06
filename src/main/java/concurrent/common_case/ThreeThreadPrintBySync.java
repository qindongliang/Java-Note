package concurrent.common_case;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThreadPrintBySync {


     static class PrintABC{

         final  Object monitor=new Object();
         volatile  int count=1;
         String id="A";
         int limit=3;


         public void printA() throws InterruptedException {
             while (count < limit) {
                 synchronized (monitor) {
                     while (!id.equals("A")) {
                         monitor.wait();
                     }
                     System.out.println(Thread.currentThread().getName() + "打印： " + id);
                     id = "B";
                     monitor.notifyAll();
                 }

             }
         }

             public void printB() throws InterruptedException {
                 while (count < limit) {
                     synchronized (monitor) {
                         while (!id.equals("B")) {
                             monitor.wait();
                         }
                         System.out.println(Thread.currentThread().getName() + "打印： " + id);
                         id = "C";
                         monitor.notifyAll();
                     }

                 }
             }

         public void printC() throws InterruptedException {
             while (count < limit+1) {
                 synchronized (monitor) {
                     while (!id.equals("C")) {
                         monitor.wait();
                     }
                     System.out.println(Thread.currentThread().getName() + "打印： " + id+"\n");
                     id = "A";
                     count=count+1;
                     monitor.notifyAll();
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
