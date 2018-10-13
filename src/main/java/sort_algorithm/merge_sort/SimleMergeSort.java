package sort_algorithm.merge_sort;

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

        //2个数据的处理情况
        while (first<=mid&&last<=end){
            //小的放前面
            if(arr[first]<arr[last]){
                tmp[i++]=arr[first++];
            }else{
                tmp[i++]=arr[last++];
            }
        }

        // 左边仅仅有一个元素的处理情况
        while (first<=mid){
            tmp[i++]=arr[first++];
        }
        // 右边仅仅有一个元素的处理情况
        while (last<=end){
            tmp[i++]=arr[last++];
        }

        //新排序好的数据归位到，原始数据里面
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
