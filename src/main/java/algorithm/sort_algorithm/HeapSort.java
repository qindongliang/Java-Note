package algorithm.sort_algorithm;

import java.util.Arrays;

/**
 * 采用最大堆，实现从小到大的排序
 * 时间复杂度O(nlogn) 空间复杂度O(1)
 * Created by qindongliang on 2018/10/21.
 */
public class HeapSort {



    public static void sort(int arr[]){

        //初始化构建一个大顶堆
        for (int i = arr.length/2;i>=0; i--) {
            System.out.println();
            heapAdjust(arr,i,arr.length);
        }
        //原地排序，无序额外的空间辅助
        for (int i =  arr.length-1;i>0; i--) {
            swap(arr,0,i);//将最大的值，放在数组的尾部
            heapAdjust(arr,0,i);//重新调整堆的结构，选举出来新的最大值。
        }

    }

    private static void swap(int[] arr, int index1, int index2) {

        int tmp=arr[index1];//最大值，下标为0的永远是最大值
        arr[index1]=arr[index2];//将最后一位数字与第一位替换
        arr[index2]=tmp;//现在最后一位是最大的


    }

    private static void heapAdjust(int[] arr, int i, int length) {
        int child;
        int father;
        for (father=arr[i];left(i)<length;i=child){
            child=left(i);
            //第一个条件代表必定有右子树，，第二个条件代表左子树小于右子树，则比较右子树和父亲
            if(child!=length-1 && arr[child]<arr[child+1]){
                child++;//加1，代表是右子树
            }
            //如果父节点小于孩子，则进行交换
            if(father<arr[child]){
                arr[i]=arr[child];
            }else{
                //符合大顶堆的结构
                break;
            }

        }
        //此时i的下标代表的是孩子的值，把父亲的数据赋值给孩子。
        arr[i]=father;

    }

    public static int left(int i){
        return 2*i+1;
    }

    public static void main(String[] args) {

        int array[]={3,-1,4,6};
        System.out.println("before: "+ Arrays.toString(array));
        sort(array);
        System.out.println("after: "+Arrays.toString(array));


    }
}
