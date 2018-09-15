package concurrent.threadpool;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by qindongliang on 2018/9/14.
 */
public class ForkJoinPoolMaxTest {

    static  int[] getIntArray(int size){
        int array[]=new  int[size];
        Random random=new Random();
        for (int i = 0; i <size ; i++) {
           array[i]=random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        return  array;
    }

    static int getMaxValue(int []array){
        int temp=0;
        for (int num:array) {
            if(temp<num){
                temp=num;
            }
        }

    return temp;
    }

    public static void main(String[] args) {


//        ForkJoinPool forkJoinPool=ForkJoinPool.commonPool();

        int array[]=  getIntArray(10);
//        long start=System.currentTimeMillis();
//        System.out.println( getMaxValue(array));
//        long end=System.currentTimeMillis();
//        System.out.println("串行耗时："+(end-start)+" ms ");

        ForkJoinPool pool=new ForkJoinPool();//实例化pool，构造函数可传入并行度
       long start=System.currentTimeMillis();
      FindMaxTask fmt=  new FindMaxTask(array,0,array.length);
        //Integer max=pool.invoke(fmt);//第一种调用方法
       Integer max= fmt.invoke();//第二种调用方法，使用默认的通用线程池
        System.out.println(max);
       long end=System.currentTimeMillis();
        System.out.println("并行耗时："+(end-start)+" ms ");


    }


    static class FindMaxTask extends RecursiveTask<Integer>{

        private int [] array;
        private int start,end;

        public FindMaxTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {

            //如果太小就不分割，直接计算
            if(end-start<=2){
                int max=-99;
                for (int i = start; i <end ; i++) {
                    max=Integer.max(max,array[i]);
                }
                return max;
            }else{
                //否则就分成两个数组，分别进行处理
                int mid=(end-start)/2+start;

                FindMaxTask left=new FindMaxTask(array,start,mid);
                FindMaxTask right=new FindMaxTask(array,mid,end);

                 invokeAll(right,left);

                int leftRes=left.getRawResult();
                int rightRes=right.getRawResult();


                return Integer.max(leftRes,rightRes);//第一种方法
//                return Integer.max(left.join(),right.join());

            }
        }
    }


}
