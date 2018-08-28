package concurrent.tools.exchager;

import java.util.concurrent.Exchanger;

public class ExchangeDemo1 {



    public static void main(String[] args) {

        Exchanger exchanger=new Exchanger();
        ExchangeDemo1 demo1=new ExchangeDemo1();

        Thread t1=new Thread(new Worker(exchanger,"A"));
        Thread t2=new Thread(new Worker(exchanger,"B"));

        t1.start();
        t2.start();

    }


   static class  Worker implements Runnable{

        Exchanger exchanger;
        Object object;

        public Worker(Exchanger exchanger, Object object) {
            this.exchanger = exchanger;
            this.object = object;
        }

        public void run() {

            Object privious=this.object;
            try {
                this.object=this.exchanger.exchange(this.object);
                System.out.println(Thread.currentThread().getName()+" exchange "+privious+"  for "+this.object);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }



}
