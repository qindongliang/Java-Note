package leetcode.easy.array_all;

/****
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 * 题目描述：给定一个int数组，找出是否存在一个最大值数字，其值是第二大数字的两倍
 *
 * 思路：
 *
 * 声明两个变量保留，最大值和次大值，循环的时候求出并赋值，
 * 直到遍历结束，判断次大值的两倍是否小于等于最大值
 *
 */

public class LargestNumberTwice {

    public static int dominantIndex(int[] nums) {
        int max=-1;
        int index=-1;
        int second=-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>max){
                second=max;
                max=nums[i];
                index=i;
            }else if(nums[i]>second){
                second=nums[i];
            }
        }
        return second*2<=max?index:-1;

    }

    public static void main(String[] args) {

        int arr[]={3, 6, 1, 0};

        System.out.println(dominantIndex(arr));


    }
}
