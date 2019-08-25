package leetcode.easy.math;

/****
 *
 * https://leetcode.com/problems/binary-gap/
 *
 * 给定一个正整数N，让求出把这个N转成二进制后的字符串里面，
 * 求里面每遇到两个1之间的最大距离，
 *
 * 比如：22，转成二进制后如下：10110
 *
 * 里面出现了三个1，第1对连续1的距离是2，第2对的是1
 *
 * 所以返回结果就是2。
 *
 * 下面的解题思路是：
 *
 * d代表从右边1开始到下一个1的的距离，res保存距离，遇到新的1对
 * 只需要取最大值即可。
 *
 */
public class BinaryGap {

    public static int binaryGap(int N) {
//        System.out.println("二进制串："+Integer.toBinaryString(N));
        int res = 0;
        for (int d = -32; N > 0; N /= 2, d++)
            if (N % 2 == 1) {
                res = Math.max(res, d);
                d = 0;
            }
        return res;
    }

    public static void main(String[] args) {


        System.out.println(binaryGap(22));

    }


}
