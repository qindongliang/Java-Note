package algorithm.sort_algorithm.radix_sort;

import java.util.Arrays;

/**
 *
 * 基数排序2，使用非字符串数组排序
 * 默认仅仅支持大于0的正整数排序。
 * Created by qindongliang on 2018/10/14.
 */
public class BetterRadixSort {


    private static void radixSort(int []a){
        System.out.println("排序前："+Arrays.toString(a));
        int radix=10; //数字从0到9共有10位
        int exp;
        int max=a[0];
        for (int i = 0; i < a.length; i++) {
            max=Math.max(a[i],max);

        }
        System.out.println("数组最大值："+max);

        //判断一个整数，有多少位数
        //exp=1  对个位排序
        //exp=10 对十位排序
        //exp=100对白位排序
        //......依次类推
        for(exp=1;max/exp>0;exp*=10){
            int output[]=new int[a.length];
            int radixArr[]=new int[radix];
            //下面的过程，与计数排序类似
            for (int i = 0; i < a.length; i++) {
                radixArr[a[i]/exp%radix]++;
            }
            //求和定位，相对位置
            for (int i = 1; i < radix; i++) {
                radixArr[i]=radixArr[i]+radixArr[i-1];
            }

            for (int i = a.length-1; i>=0 ; i--) {
                //得到每个数字在bucket数组里面的位置
                int pos=a[i]/exp%radix;
                //得到其的便宜量
                int offset=radixArr[pos];
                output[offset-1]=a[i];//存放其位置
                radixArr[pos]--;//基数自减

            }
            System.out.println("%"+exp+"排序后："+Arrays.toString(output));
            //将排序结果赋值给原数组
            a=output;

        }

    }




    public static void main(String[] args) {

        int a[] = {53, 3, 542, 748, 14, 214, 154, 63, 616};

        radixSort(a);

    }
}
