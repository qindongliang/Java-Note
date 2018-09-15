package concurrent.threadpool;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
/**
 * Created by qindongliang on 2018/9/14.
 */
public class ForkJoinPoolSumTest {

    static  int[] getIntArray(int size){
        int array[]=new  int[size];
        Random random=new Random();
        int sum=0;
        for (int i = 0; i <size ; i++) {
            array[i]=random.nextInt(100);
            sum+=array[i];
        }
        System.out.println(Arrays.toString(array));
        System.out.println("sum: "+sum);

        return  array;
    }

    public static void main(String[] args) {
        int array[]=  getIntArray(10);
        long start=System.currentTimeMillis();
        ArrayTransForm fmt=  new ArrayTransForm(array,0,array.length);
        fmt.invoke();//使用默认的通用线程池
        fmt.print();//打印最大值
        long end=System.currentTimeMillis();
        System.out.println("并行耗时："+(end-start)+" ms ");



    }




    //没有返回值的任务
    static class ArrayTransForm extends RecursiveAction{
        private int [] array;
        private int start,end;
        //必须使用静态变量
        private  static int sum;

        public ArrayTransForm(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        private void print(){
            System.out.println("max: "+sum);
        }

        @Override
        protected void compute() {
            //如果太小就不分割，直接计算
            if(end-start<=3){
                for (int i = start; i <end ; i++) {
                    sum+=array[i];
                }


            }else{
                //否则就分成两个数组，分别进行处理
                int mid=(end-start)/2+start;

                ArrayTransForm left=new ArrayTransForm(array,start,mid);
                ArrayTransForm right=new ArrayTransForm(array,mid,end);

                 left.fork();
                right.fork();
                left.join();
                right.join();


            }




        }
    }


}
