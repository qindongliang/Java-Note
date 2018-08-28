package concurrent.tools.exchager;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ExchangeDemo2 {

   static Exchanger<DataBuffer<Integer>>  exchanger=new Exchanger<>();
   static DataBuffer<Integer> intialEmptyBuffer=new DataBuffer<>();
   static DataBuffer<Integer> intialFullBuffer=new DataBuffer<>();
   static AtomicInteger countDown=new AtomicInteger(5);


    static class ProducerWorker implements Runnable{
        //每次睡眠时长，单位是秒
        long sleep;

        public ProducerWorker(long sleep) {
            this.sleep = sleep;
        }

        @Override
        public void run() {
            DataBuffer currentBuffer=intialEmptyBuffer;
            while (currentBuffer!=null&&countDown.get()>0){
                try {
                    TimeUnit.SECONDS.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                currentBuffer.put(countDown.get());//每次放入数据
                if(currentBuffer.isFull()){
                    try {
                        System.out.println(Thread.currentThread().getName()+"  放入了快递"+countDown.get());
                        currentBuffer=exchanger.exchange(currentBuffer);//交换后得到null
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                countDown.getAndDecrement();

            }

        }


    }

    static class ConsumerWorker implements Runnable{

        //每次睡眠时长，单位是秒
        long sleep;

        public ConsumerWorker(long sleep) {
            this.sleep = sleep;
        }

        @Override
        public void run() {
            DataBuffer<Integer> currentBuffer=intialFullBuffer;

            while (currentBuffer!=null&&countDown.get()>0){
                try {
                    TimeUnit.SECONDS.sleep(sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //如果为空就进行交换
                if(currentBuffer.isEmpyt()){
                    try {
                        currentBuffer=exchanger.exchange(currentBuffer); //交换数据
                        Integer value=currentBuffer.get();//不断的从
                        System.out.println(Thread.currentThread().getName()+"  拿走了快递"+value);
                        System.out.println();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }

        }
    }


    public static void main(String[] args) {
        new Thread(new ProducerWorker(1),"快递员").start(); //启动生产者，每次睡眠1秒，启动顺序不分先后
        new Thread(new ConsumerWorker(3),"我   ").start(); //启动消费者，每次睡眠3秒，启动顺序不分先后


    }

    /***
     * 数据交换类
     * @param <T>
     */
   static class DataBuffer<T>{
        T data;
        public boolean isFull(){
            return data!=null;
        }

        public boolean isEmpyt(){
            return  data==null;
        }

        public T get(){
            T d=data;
            data=null;
            return d;
        }

        public void  put (T data){
            this.data=data;
        }



    }

}
