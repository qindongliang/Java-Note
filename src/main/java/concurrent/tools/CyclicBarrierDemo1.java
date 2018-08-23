package concurrent.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2018/8/23.
 */
public class CyclicBarrierDemo1 {

    private   CyclicBarrier cyclicBarrier;
    private List<List<Integer>> partialResults = Collections.synchronizedList(new ArrayList<>());
    private Random random = new Random();
    private int NUM_PARTIAL_RESULTS;
    private int NUM_WORKERS;



    void runSimulation(int numWorkers,int numLists){

        NUM_WORKERS=numWorkers;
        NUM_PARTIAL_RESULTS=numLists;

       Thread combine=new AggregatorThread();
        combine.setName("combine线程");

        cyclicBarrier=new CyclicBarrier(numWorkers,combine);

        System.out.println("workNums: "+numWorkers+"  ");


        for (int i = 0; i < numWorkers; i++) {

            Thread worker=new Thread(new NumberCreateThread());
            worker.start();
        }

    }





    class NumberCreateThread implements Runnable{

        @Override
        public void run() {

            String name=Thread.currentThread().getName();

            List<Integer> tempResult=new ArrayList<>();
            for (int i = 0; i < NUM_PARTIAL_RESULTS; i++) {

                Integer num=random.nextInt(10);

                System.out.println(name+" 生产了"+num);
                tempResult.add(num);
            }

            partialResults.add(tempResult);


            try {
                System.out.println(name+" 等待其他线程到达  ");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }


    class AggregatorThread extends Thread{


        @Override
        public void run() {
            String name=Thread.currentThread().getName();
            System.out.println(name+" 开始计算最终结果...... ");

            int sum=0;

            for(List<Integer> dxs:partialResults){

                for(Integer num:dxs){
                    System.out.print(num+" ");
                    sum+=num;
                }
                System.out.println();

            }

            System.out.println(name+"  计算完毕总结果="+sum);



        }
    }


    public static void main(String[] args) {

        CyclicBarrierDemo1 demo=new CyclicBarrierDemo1();

        demo.runSimulation(3,3);


    }


}
