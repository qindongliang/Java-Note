package algorithm.sort_algorithm;

import java.util.Arrays;

/****
 *
 * 添加快速排序的例子
 *
 * (1)不断找基准
 *（2）小于基准的放左边
 * (3)大于基准的放右边
 */
public class QucikSort {

    static int []a=new int[]{6,1,2,7,9,3,4,5,10,8};

    static  void sort(){
        show();
        quickSort(0,a.length-1);

    }

    static void show(){
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int lowerIndex,int higherIndex){

        if(lowerIndex>=higherIndex) return;
        int i=lowerIndex;//左哨兵
        int j=higherIndex; //右哨兵

        int pivotIndex=i;
        int pivot=a[pivotIndex]; //基准数字
        //i=j 说明哨兵相遇，迭代完毕
        while(i!=j){
            //从右遍历到左找到第一个大于基准数的数，停下来
            while(a[j]>=pivot && i<j){
                j--;//每后退一步，就自减1
            }

            while(a[i]<=pivot && i<j){
                i++;//每前进一步，就加1
            }

            if(i<j) {
                //交换元素
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }

        }
        //基准换位
        a[pivotIndex]=a[i];
        a[i]=pivot;




        show();
//        System.out.println(lowerIndex+" "+(i-1));
        quickSort(lowerIndex,i-1);//继续处理左边的
        quickSort(i+1,higherIndex);//继续处理右边的


    }


    public static void main(String[] args) {


        sort();




    }

}
