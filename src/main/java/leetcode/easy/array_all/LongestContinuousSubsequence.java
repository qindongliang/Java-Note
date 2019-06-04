package leetcode.easy.array_all;

/****
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 *
 * 题目描述：找出数组里面连续自增的最大长度
 * 比如 [1,3,5,4,7]，连续自增的长度是1，3，5 所以长度为3
 *
 */
public class LongestContinuousSubsequence {

    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) return 0;
        int max=1;
        int count=1;
        //从1开始遍历，直接与后面的比较
        for (int i = 1; i < nums.length; i++) {
            //如果大于前一位，那么就是自增，所以计数+1
            if(nums[i]>nums[i-1]){
                count++;
                //如果自增大于最大值，就赋值最大值
                if(count>max){
                    max=count;
                }
            }else {
                count=1;//重置为1
            }
        }

        return max;

    }


    public static void main(String[] args) {
     int arr[]={1,3,5,4,7};
        System.out.println(findLengthOfLCIS(arr));
    }
}
