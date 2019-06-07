package leetcode.easy.array_all;

import java.util.Arrays;

/****
 *https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 题目描述：
 *
 * 给定一个可以重复的有序数组，让在不额外花费空间的前提下，对数组进行去重，
 * 把不重复的数字在原有的数组中修改顺序，最终返回数组的长度
 *
 * 思路：
 * 总体来说比较简单，我们只需要遍历数组一次即可，
 *
 * 用额外的从0开始的一个变量，用来标记当前不重复数组已经更新的位置
 * 当遇到相邻不相等的时候，就把j的值+1，然后把i位置的值给赋值给
 * j，直到遍历数组结束即可
 *
 */

public class RemoveDuplicateSortedArray {
    public static int removeDuplicates(int[] nums) {
        if(nums.length==0){ return  0;}
        int j=0;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]!=nums[j]){
               j++;
              nums[j]=nums[i];
            }

        }

        return j+1;


    }

    public static void main(String[] args) {
//        int arr[]={1,1,2};
        int arr[]={0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates(arr));

        System.out.println(Arrays.toString(arr));


    }


}
