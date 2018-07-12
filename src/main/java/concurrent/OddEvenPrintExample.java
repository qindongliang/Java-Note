package concurrent;

import java.util.Random;

/**
 * Created by qindongliang on 2018/7/12.
 */
public class OddEvenPrintExample {



    static  class CounterGenrator{

        public  int count=1;

    }



    static class EvenThread extends Thread{

         CounterGenrator counterGenrator;

         public EvenThread(CounterGenrator counterGenrator){
             this.setName("even thread");
             this.counterGenrator=counterGenrator;
         }

         @Override
         public void run() {

             while (counterGenrator.count<11){

                 synchronized (counterGenrator){


                     while (counterGenrator.count%2!=0){

                         System.out.println("even thread wait ");
                         try {
                             counterGenrator.wait();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }


                     }


                     System.out.println("even thread print "+counterGenrator.count);

                     counterGenrator.count++;
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }

                     counterGenrator.notify();

                 }





             }



         }
     }



   static class OddThread extends Thread{

        CounterGenrator counterGenrator;

        public OddThread(CounterGenrator counterGenrator){
            this.setName("odd thread");
            this.counterGenrator=counterGenrator;
        }

        @Override
        public void run() {

            while (counterGenrator.count<11){


                synchronized (counterGenrator){


                    while (counterGenrator.count%2==0){

                        System.out.println("odd thread wait ");
                        try {
                            counterGenrator.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }


                    System.out.println("odd thread print "+counterGenrator.count);

                    counterGenrator.count++;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    counterGenrator.notify();


                }





            }



        }
    }



    public static void main(String[] args) {

        CounterGenrator c=new CounterGenrator();



        OddThread oddThread=new OddThread(c);


        EvenThread evenThread=new EvenThread(c);




        oddThread.start();

        evenThread.start();








    }

}
