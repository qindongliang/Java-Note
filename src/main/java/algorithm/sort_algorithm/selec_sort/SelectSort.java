package algorithm.sort_algorithm.selec_sort;

import java.util.Arrays;

/**
 * 算法思想：
 * 选择排序算法假设无序的数组是有序的，那么
 * 数组每个位置上的元素一定是，从当前位置开始到结尾中
 * 最小的，基于这个假设，选择排序每次都会查找从其位置
 * 开始到末尾中的最小元素的下标，找到之后，交换当前位置的值
 * 与最小值，反复如此就能把无序数组，给排序好
 *
 * 平均时间复杂度：О(n²)
 * 平均空间复杂度：O(1)
 * 是否稳定：不是稳定排序算法
 *
 */
public class SelectSort {

    public static  void sort(int arr[]){

        int min;//存储每次遍历得到的最小元素的数组下标值
        int swap;//存储代待交换元素的值
        for (int i = 0; i < arr.length; i++) {
            //依次数组的下标赋值
            min = i;
            //遍历剩余部分的元素，找到最小值的下标
            for (int j = i; j < arr.length; j++) {
                // 比较元素值
                if (arr[j] < arr[min]) {
                    min = j;//下标赋值
                }
            }
            //每次把最小值提前
            swap = arr[min];
            arr[min] = arr[i];
            arr[i] = swap;

            System.out.println(Arrays.toString(arr));
        }

    }


    public static void main(String[] args) {

        int a[]={10,19,8,7,1};
        sort(a);


    }


}
