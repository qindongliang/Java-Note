package sort_algorithm.count_sort;

import java.util.Arrays;

public class StableCountingSort2 {

    public static void main(String[] args) {

        int a[]={-1,-3,0,0,9,5,4};
        //有负数



        int b[]=new int[a.length];

        int max = a[0], min = a[0];
        for(int i : a){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }

        System.out.println("原始数组："+Arrays.toString(a));
        int a2[]=new int[a.length];
        for (int i = 0; i <a.length ; i++) {
            a2[i]=a[i]-min;
        }
        System.out.println("负数转化后的数组："+Arrays.toString(a2));



        System.out.println(" min:"+min+" max:"+max);

        //可以减少c数组空间的大小
        int k=max-min+1;
        int c[]=new int[k];

        for (int i = 0; i <a.length ; i++) {
            c[a[i]-min]++;
        }

        System.out.println("词频计数后的数组： "+Arrays.toString(c));

        int ndx=0;
        for (int i = 0; i <c.length; i++) {
            while (c[i]>0){
                a[ndx]=i;
                c[i]--;
            }
        }
        System.out.println("排序后的数组："+Arrays.toString(a));


//        for (int i = 1; i <c.length ; i++) {
//            c[i]=c[i]+c[i-1];
//        }
//
//        System.out.println("为了保持排序稳定转化的词频数组："+Arrays.toString(c));
//
//        for (int i = a.length-1; i >=0 ; --i) {
//            b[c[a[i]-min]--]=a[i];
//        }
//
//        //最终的排序结果.....
//        System.out.println("最终结果："+Arrays.toString(b));







    }

}
