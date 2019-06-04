package leetcode.easy.array_all;

/***
 *  https://leetcode.com/problems/maximum-subarray/
 *
 * 题目描述：给定一个数组，求连续最大的和，并返回这个和
 *
 */

public class MaxinumSubArray {

    public static int maxSubArray(int[] nums) {
        //初始化最大值为int的最大值
        int max=Integer.MIN_VALUE;
        int sum=0;
        //遍历整个数组
        for (int i = 0; i < nums.length; i++) {
            //如果sum小于0
            if(sum<0){
                //重置sum为当前数字
                sum=nums[i];
            }else{
                //否则就继续累加
                sum+=nums[i];
            }
            //判断sum值是否大于历史最大值，如果大于就重置
            if(sum>max){
                max=sum;
            }

        }
     return max;
    }

    public static void main(String[] args) {
        int  arr[]={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));

    }
}
