package concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */
public class ThreadDaemonExample {

    public static void start(){

        Thread thread=new Thread(()->{


            long memory_used= getMemoryUsed();
            System.out.println("memory used: "+memory_used+" MB" );

            while (true){

                long memory_used1=getMemoryUsed();

                if(memory_used!=memory_used1){
                    memory_used=memory_used1;
                    System.out.println("memory used: "+memory_used+" MB" );
                }

            }

        });

        thread.setPriority(Thread.MAX_PRIORITY);
//        thread.setDaemon(true);
        thread.start();


    }


    private static long getMemoryUsed(){
        return  ( ( Runtime.getRuntime().totalMemory()-
        Runtime.getRuntime().freeMemory())/1024/1024
        );
    }



    static List<String> list=new ArrayList<>();



    public static void main(String[] args) {


        start();

        for (int i = 0; i < 100000; i++) {

            String str=new String("str"+i);

            list.add(str);

        }


        System.out.println("end");




    }

}
