package sort_algorithm;

import java.util.Arrays;

/****
 *
 * 非比较排序，属于线性排序算法
 *
 * 时间复杂度O（n+k） n=数组元素的个数，k=元素里面的最大的值
 *
 *
 *
 */

public class CountingSort {


    public static void countSort(){

        int array[]={-1,-3,0,0,9,5,4};

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

        for (int number:array){
            count[number-min]++;
        }

        int z=0;

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


        countSort();






    }




    public static void  test1(){
        int nums[]={1,2,1,0,1};

        int maxNum=2;

        int storeArray[]=new int[maxNum+1];


        //词频计数
        for(int i=0;i<nums.length;i++){
            storeArray[nums[i]]++;
        }

        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(storeArray));

        System.out.println("==============排序后==============");

        int ndx=0;
        //遍历计数后的词频数组
        for (int i = 0; i <storeArray.length ; i++) {
            //进行回放，大于0说明这个数字出现过
            while (storeArray[i]>0){
                nums[ndx]=i;//把词频数组的值，放回原数组里面，
                ndx++;//替换一个数，就索引自增
                storeArray[i]--;//词频减1，防止死循环
            }
        }


        System.out.println(Arrays.toString(nums));



    }



}
