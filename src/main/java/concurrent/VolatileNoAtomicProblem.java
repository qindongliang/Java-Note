package concurrent;

/**
 * volatile仅仅保证可见性，不保证一致性和原子性
 */
public class VolatileNoAtomicProblem {

    // volatile variable
    static volatile int c;

    public static void main(String[] args) throws Exception{


            // volatile only guarantee visibility no atomicity
            problemDemo();


            // how to fix the prolem ?

           //  1 : use synchronized methon

          //   2 : use  AtomicInteger






    }

    public static void useSynchronized(){

    }




    public static synchronized void increment(){
        c++;
    }



    public static void problemDemo() throws  Exception{


        for (int i = 0; i < 10; i++) {

            //  reset 0
            c=0;

            // thread 1

            Thread t1=new Thread(()->{

                for (int j = 0; j < 1000; j++) {
                    c++;
                }

            });

            // thread 2

            Thread t2=new Thread(()->{

                for (int j = 0; j < 1000; j++) {
                    c++;
                }

            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();


            System.out.println("count value: "+c);


        }
    }










}
