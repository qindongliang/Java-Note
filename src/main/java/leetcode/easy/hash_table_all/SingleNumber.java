package leetcode.easy.hash_table_all;

/****
 *
 * https://leetcode.com/problems/single-number/
 *
 * 一个数组中，只有一个所有的数字都出现了2次，唯有一个数字只出现了一次，
 * 现在要求找出这个数字，并且不适用额外的空间
 *
 * 思路：适用xor异或运算，两个相等的数异或结果等于0，0异或任何数等于任何数
 *
 * 利用这个特征既可以轻松求解
 *
 *
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result=0;
        for (int num:nums){
            result=result^num;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(0^3);
    }

}
