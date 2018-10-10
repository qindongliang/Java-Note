package sort_algorithm;

import java.util.Random;

/**
 * Created by qindongliang on 2018/9/9.
 */
public class BubbleSort {


    public static int bubbleSort(int a[]){
        int count=0;
        for(int i=0;i<a.length;i++){
            for (int j = i+1; j <a.length; j++) {
                if(a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
                count++;
            }
        }

        return count;
    }

    static  int count=0;

    public static void quickSort(int a[],int left,int right ){

        if(left>=right) return;

        int pivot=a[left];
        int i=left;
        int j=right;

        //如果左右指针碰头就代表这一轮迭代结束
        while (i!=j){
            //先从右边开始,找小于pivot点的数字
            //因此，循环的条件是如果大于pivot就继续查找
            //小于pivot就停止
            while(a[j]>=pivot&&i<j){
                count++;
                j--;
            }
            //后从左边开始，找大于pivot的数字
            //因此，循环的条件是如果是小于pivot就继续查找
            //大于pivot就停止
            while(a[i]<=pivot&&i<j){
                count++;
                i++;
            }

            if(i<j) {
                //交换两个数字
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }

        }

        //基准归位
        a[left]=a[i];
        a[i]=pivot;

        quickSort(a,left,i-1);

        quickSort(a,i+1,right);

    }


    public static void main(String[] args) {
        Random random=new Random();
        int seed=100000;
        System.out.println("排序总个数："+seed);
        System.out.println("===============");
        int a[]=new int[seed];
        for(int i=0;i<seed;i++){
            a[i]=random.nextInt(seed);
        }

//        int []a=new int[]{6,1,2,7,9,3,4,5,10,8};
//        int []a=new int[]{10,9,8,7,6,5,4,3,2,1};
//        int []a=new int[]{1,2,3,4,5,6,7,8,9,10};
//        int []a=new int[]{6,6,6,6,6,6,6,8,6,6};
        long start=System.currentTimeMillis();
        quickSort(a,0,a.length-1);
        long end=System.currentTimeMillis();
        System.out.println("总遍历次数："+count);
        System.out.println("快排耗时："+(end-start)+"ms");


        System.out.println("===========");
        start=System.currentTimeMillis();
        System.out.println("总遍历次数："+bubbleSort(a));
        end=System.currentTimeMillis();
        System.out.println("冒泡耗时："+(end-start)+"ms");


    }


}
