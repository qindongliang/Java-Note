package leetcode.easy.array_all;

import java.util.Arrays;

/***
 *
 * 描述：给定一个数组，让里面的0给前部移动到数组的一端。
 * 并保持数组里面之前的数字顺序
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[index++]=nums[i];
            }
        }

        while (index<nums.length){
            nums[index++]=0;
        }


    }

    public static void main(String[] args) {
        int arr[]={2,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

    }

}
