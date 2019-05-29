package leetcode.easy.array_all;

/****
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/
 *
 * 题目描述：
 * 有两种特殊字符，第一种可以被表示使用单个bit 0，第二种可以是10 或者11
 *
 * 现在给定一个二进制数组，判断返回最后一个解码字符是否是1bit，或者不是
 *
 * 字符数组的最后一位总是0结束。
 *
 */
public class OneTwoBits {

    public static boolean isOneBitCharacter(int[] bits) {
        int n=bits.length-1,i=0;
        while (i<n){
            if(bits[i]==0){
                i++;
            }else {
                i=i+2;
            }
        }

        return i==n;

    }

    public static void main(String[] args) {
//        int arr[]={1, 1, 1, 0};
        int arr[]={ 0,0, 0};

        System.out.println(isOneBitCharacter(arr));

    }
}
