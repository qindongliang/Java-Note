package leetcode.easy.array_all;

/****
 *
 * 题目描述：给定一个数组，让找出一个基准index，使得左半数字的和等于右半部分的和
 * 不包括基准数字。
 *
 * 解题思路：
 *
 * 先循环一次求出数组的总和。
 *
 * 然后再循环一次，从后一位开始，才统计前一位数字，使用一个left变量，来存储左半部分的和
 * 然后每一次判断左半部分的和，是否与sum-left-arr[i]也就是右半部分的和相等，如果相等
 * 就返回index，也就是我们要找的pivot
 */
public class FindPivotIndex {


    public static int pivotIndex(int[] nums) {
        int sum=0;
        int left=0;
        for (int num:nums){
            sum+=num;
        }

        for (int i = 0; i < nums.length; i++) {
           if(i!=0){
               left+=nums[i-1];
           }
           if(sum-left-nums[i]==left){
               return i;
           }
        }
        return -1;

    }

    public static void main(String[] args) {
        int arr[]={1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(arr));
    }
}
