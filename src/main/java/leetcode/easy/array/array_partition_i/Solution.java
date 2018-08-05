package leetcode.easy.array.array_partition_i;

import java.util.Arrays;

/**
 * Created by qindongliang on 2018/8/5.
 */
public class Solution {
    public static int arrayPairSum(int[] nums) {
       Arrays.sort(nums);
        return  getSum(nums);
    }


    public  static  int getSum(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i=i+2){
            sum=sum+nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        int [] nums={-1,4,3,2,6,8};

        System.out.println(getSum(nums));

    }


}
