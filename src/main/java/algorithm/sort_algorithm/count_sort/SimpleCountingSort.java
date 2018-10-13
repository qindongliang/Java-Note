package algorithm.sort_algorithm.count_sort;

import java.util.Arrays;

/****
 *
 * 非比较排序，属于线性排序算法
 *
 * 时间复杂度O（n+k） n=数组元素的个数，k=元素里面的最大的值
 *
 * 最简单的计数排序
 *
 *
 */

public class SimpleCountingSort {


    public static void countSort(){

        int array[]={2,0,-1};

        int max=array[0];
        int min=array[0];

        for(int i=0;i<array.length;i++){
            if(array[i]<min){
                min=array[i];
            }

            if(array[i]>max){
                max=array[i];
            }
        }

        System.out.println("max: "+max+" min: "+min);

        int []count=new int[max-min+1];

        //每个数减去最小的数可以支持负数变成正数，并计数词频，
        for (int i:array){
            count[i-min]++;
        }

        int z=0;
        //遍历计数词频的数组，判断指定位置上词频是否大于0，然后重新映射原始数组
        for (int i = min; i <=max ; i++) {
            while (count[i-min]>0){
                array[z]=i;
                z++;
                count[i-min]--;
            }
        }

        System.out.println(Arrays.toString(array));

    }




    public static void main(String[] args) {


//        countSort();

        simpleCountSort();





    }




    public static void  simpleCountSort(){
        int nums[]={2,1,0,1};

        int maxNum=2;

        int storeArray[]=new int[maxNum+1];

        //词频计数
        for(int i=0;i<nums.length;i++){
            storeArray[nums[i]]++;
        }

        System.out.println("==============排序后==============");

        int ndx=0;
        //遍历计数后的词频数组
        for (int i = 0; i <storeArray.length ; i++) {
            //对于每个index的值进行循环，输出，因为有可能重复
            while (storeArray[i]>0){
                nums[ndx]=i;//把词频数组的值，放回原数组里面，
                ndx++;//替换一个数，就索引自增
                storeArray[i]--;//词频减1，防止死循环
            }
        }


        System.out.println(Arrays.toString(nums));



    }



}
