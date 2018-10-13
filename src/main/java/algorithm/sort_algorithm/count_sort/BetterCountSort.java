package algorithm.sort_algorithm.count_sort;

import java.util.Arrays;

//https://www.youtube.com/watch?v=TTnvXY82dtM&app=desktop

/***
 * 非比较排序，
 * 时间复杂度+空间复杂度都为 O（n+k）
 * n=数组元素的个数，k=元素里面的最大的值
 *
 */
public class BetterCountSort {
    public static void main(String []args){
        //排序的数组
        int a[] = {2,3,-1,3};
//        int a[] = {9,1,2};
        int b[] = countSort(a);

        System.out.println(Arrays.toString(b));
    }

    public static int[] countSort(int []a){
        //使用最大值和最小值的方式是一种优化的计数排序
        //可以兼容负数的情况，同时能减少存储的空间，比如最大数是100，但实际上只有90-100这10个数字
        //所以仅仅需要10个存储空间即可
        int max = a[0], min = a[0];
        for(int i : a){
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        System.out.println("max:"+max+"  min:"+min);
        int k = max - min + 1;
        System.out.println("count array len："+k);

        int c[] = new int[k];
        //先是count计数词频
        for(int i = 0; i < a.length; ++i){
            c[a[i]-min] ++;//优化过的地方，减小了数组c的大小，同时a[i]-min能保证c数组的第一个元素一定有元素的
            //因为必定存在min-min=0
        }
        System.out.println("count: "+Arrays.toString(c));
        //然后为了保持排序稳定，我们需要做一次累加操作
        //这样做的目的，是为了标记出原始数组里面的该元素，前面有几个元素，这个值
        //实际上就是其在原生数组里面的位置，如果有重复的元素，则会先会
        //放置最右边的元素，这样就能保证，排序的稳定性
        for(int i = 1; i < c.length; ++i){
            c[i] = c[i] + c[i-1];
        }

        System.out.println("sumCount："+Arrays.toString(c));

        //存储最终的排序结果
        int b[] = new int[a.length];
        //这里必须从后向前遍历，只有这样出现重复的元素，才会保持顺序的把最后面的重复元素，永远放在最右边。
        //从而保证排序的稳定性
        //如果从前向后排序，重复元素的顺序，刚好相反，所以就不是稳定的算法，但如果不关注稳定性，那么结果还是正确的
        for (int i = a.length-1; i >=0 ; i--) {
             //减去min是为了优化存储空间，这样得到新的转换值，
             int pos=a[i]-min;
             int sumCount=c[pos];

            System.out.println(a[i]+" 在原数组的排序后的位置是： "+(sumCount-1));

            //把最终生层的排序值，放在新的数组里面返回
            b[sumCount-1]=a[i];
            c[pos]--; //如果有重复元素，位置需要从右向左放置，所以需要把sumCount的值-1

        }


        return b;
    }

}
