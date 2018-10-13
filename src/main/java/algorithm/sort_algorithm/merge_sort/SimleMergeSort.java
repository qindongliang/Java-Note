package algorithm.sort_algorithm.merge_sort;

import java.util.Arrays;

public class SimleMergeSort {


    public static void mergeSort(int arr[],int start,int end){

        if(start>=end) return;
        int mid=(start+end)/2;
        //递归切分
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);

        //开始归并
        int i=0;
        int first=start;
        int last=mid+1;
        //临时数组存放交换排序结果
        int []tmp=new int[end-start+1];

        //基于mid中间点的位置，开始合并两个有序数组
        while (first<=mid&&last<=end){
            if(arr[first]<arr[last]){
                tmp[i++]=arr[first++];//左边的数据小
            }else{
                tmp[i++]=arr[last++];//右边的数据小
            }
        }

        // 第一个while执行过之后，如果符合下面这个
        //条件就说明，左边的数组元素还有剩余，现在把剩下的全部拷贝到新的有序数组
        while (first<=mid){
            tmp[i++]=arr[first++];
        }
        // 第一个while执行过之后，如果符合下面这个
        //条件就说明，右边的数组元素还有剩余，现在把剩下的全部拷贝到新的有序数组
        while (last<=end){
            tmp[i++]=arr[last++];
        }

        //新排序好的数据归位到，原始数组对应的位置里面
        int k=0;
        while (start<=end){
            arr[start++]=tmp[k++];
        }

        }

    public static void main(String[] args) {

        int[] input = {8,9,4,-5,6};
        System.out.println("排序前："+ Arrays.toString(input));
        mergeSort(input,0,input.length-1);
        System.out.println("排序后："+ Arrays.toString(input));

    }
}
