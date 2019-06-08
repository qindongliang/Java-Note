package leetcode.easy.array_all;

/****
 * https://leetcode.com/problems/maximum-average-subarray-i/
 * 题目描述：给定一个int数组，给定一个数字k，找出长度等于这个数字，连续相加后和的平均值最大。
 *
 * 思路：
 * 先遍历前k个数字，求出其和。然后从k开始，sum的值+依次相加最新的一个，并减去原来4个里面，最
 * 左边的一个，然后比较sum和max值的大小，直到遍历结束。
 */
public class MaximumAverageSubarray {
    public static double findMaxAverage(int[] nums, int k) {

        long sum=0;
        for (int i = 0; i <k ; i++) {
            sum+=nums[i];
        }

        long max=sum;

        for (int i = k; i <nums.length ; i++) {
            sum+=nums[i]-nums[i-k];
            max=Math.max(max,sum);
        }
        return max/1.0/k;
    }

    public static void main(String[] args) {
        int arr[]={1,12,-5,-6,50,3};


        System.out.println(findMaxAverage(arr,4));


    }
}
