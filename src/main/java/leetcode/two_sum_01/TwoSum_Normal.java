package leetcode.two_sum_01;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by qindongliang on 2018/7/2.
 *
 * performance normal
 *
 * 最常见的写法，由于需要遍历整个数组，所以性能一般
 *
 */
public class TwoSum_Normal {


    public static int[] twoSum(int nums[],int target){

        if(nums==null||nums.length<2){
            return null;
        }

        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }

            }

        }
        return null;
    }



    @Test
    public  void test(){
        int nums[]={2,7,11,5};
        int target=9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }


}
