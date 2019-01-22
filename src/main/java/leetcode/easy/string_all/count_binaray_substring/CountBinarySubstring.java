package leetcode.easy.string_all.count_binaray_substring;

/***
 *
 * 一个非常漂亮的解决思路：
 * https://leetcode.com/problems/count-binary-substrings/discuss/108625/PythonC%2B%2BJava-Easy-and-Concise-with-Explanation
 *
 * 比如00110011这个串，先统计连续出现0和1的次数分别是：2,2,2,2
 * 比如0011这个子串能计算连续子串的个数是 min(2,2) ，也就是 01 0011，由最小的连续串的个数决定的
 *
 * 只需要对连续两个子串的个数，求最小值就能计算出来，非常巧妙。
 *
 * 比如0110001111 连续的数字统计是[1,2,3,4]
 * 0001111  min(3,4)=3 => ("01", "0011", "000111")
 */
public class CountBinarySubstring {

    public static int countBinarySubstrings(String s) {
        int cur = 1, pre = 0, res = 0;
        for (int i = 1; i < s.length(); i++) {//从1开始计算
            if (s.charAt(i) == s.charAt(i - 1)){
                cur++;//如果和前一个相等，那么cur+1即可
            } else {//如果不相等，则和前一个去最小值
                res += Math.min(cur, pre);//
                pre = cur;//把cur赋值给上一次的值
                cur = 1;//当前继续从1开始
            }
        }
        //最后一次
        return res + Math.min(cur, pre);
    }

    public static void main(String[] args) {

        System.out.println(countBinarySubstrings("001"));
//        System.out.println(countBinarySubstrings("00110011"));


    }


}
