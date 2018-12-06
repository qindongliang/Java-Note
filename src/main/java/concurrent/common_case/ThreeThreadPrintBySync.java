package concurrent.common_case;

public class ThreeThreadPrintBySync {


     static class PrintABC{

         final  Object monitor=new Object();
         volatile  int count=1;//轮次计数，从1开始，为了保证可见性，这里需要用volatile修饰
         String id="A";//贡献的
         int printCount ;

         public PrintABC(int printCount) {
             this.printCount = printCount;
         }

         public void printA() throws InterruptedException {
             while (count < printCount) {
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
                 while (count < printCount) {
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
             while (count < printCount +1) {//最后一次终结线程，需要多加一次
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

        PrintABC printABC=new PrintABC(3);

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
