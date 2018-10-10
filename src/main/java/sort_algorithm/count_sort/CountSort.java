package sort_algorithm.count_sort;

import java.util.Arrays;

public class CountSort {
    public static void main(String []args){
        //排序的数组
        int a[] = {2,0,-1};
        int b[] = countSort(a);

        System.out.println(Arrays.toString(b));
    }
    public static int[] countSort(int []a){
        int b[] = new int[a.length];
        int max = a[0], min = a[0];
        for(int i : a){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }
        //这里k的大小是要排序的数组中，元素大小的极值差+1
        int k = max - min + 1;
        int c[] = new int[k];
        for(int i = 0; i < a.length; ++i){
            c[a[i]-min] ++;//优化过的地方，减小了数组c的大小
        }
        System.out.println(Arrays.toString(c));

        for(int i = 1; i < c.length; ++i){
            c[i] = c[i] + c[i-1];
        }
        System.out.println(Arrays.toString(c));

        for(int i = a.length-1; i >= 0; i--){
            int t1=a[i]-min;
            int t2=c[t1];
            int t3=--t2;
            b[t3]=a[i];
//            b[--c[a[i]-min]] = a[i];//按存取的方式取出c的元素
        }

//        for (int i = a.length-1; i >=0 ; i--) {
//
//            int value=a[i];
//
//            int pos=c[value-min];
//
//        }

        return b;
    }

}
