package leetcode.easy.array_all;

/****
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * 题目描述：给定一个升序排好的整数数组，现在给定任意一个整数，然后求出
 * 在这个数组里面找到两个相加可以等于该数的数，并返回他们的下标（从1开始非0）
 *
 * 解决思路：
 * 使用双指针法，依次取头尾相加，然后判断与targeNum的大小，如果大就从右向左移
 * 反之，则从左向右移直到找到特定的一对数字，然后返回其index+1即可
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
    int left=0;
    int right=numbers.length-1;
    while (left<right){
        if(numbers[left]+numbers[right]==target){
            return new int[]{left+1,right+1};
        }else if(numbers[left]+numbers[right]<target){
            left++;
        }else {
            right--;
        }
    }
    return new int[]{};
    }


    public static void main(String[] args) {

    }
}
