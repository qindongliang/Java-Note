package leetcode.easy.array_all;

/***
 * Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 *
 * 描述：给定一个二进制的数组，求里面连续出现1的最大次数
 *
 */
public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                count++;
            }else {
                max=Math.max(max,count);
                count=0;
            }
        }
        return Math.max(count,max);
    }

    public static void main(String[] args) {
        int a[]={1,1,0,1,0,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(a));
    }
}
