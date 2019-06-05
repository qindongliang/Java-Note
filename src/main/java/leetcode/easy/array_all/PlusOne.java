package leetcode.easy.array_all;

import java.util.Arrays;

/***
 * https://leetcode.com/problems/plus-one/submissions/
 *题目描述：
 * 给定一个非负数的整形数组，让它+1后，计算新的结果也保存到新的数组里面
 *
 */
public class PlusOne {

    //常规解法
    public static int[] plusOne(int[] digits) {

        //保留，每次进位后的数
        int carry=1;

        for (int i = digits.length-1; i >=0 ; i--) {
            if( digits[i]+carry <=9){
                digits[i]=digits[i]+carry;
                carry=0;
             return digits;
            }else {
               int rem= (digits[i]+1)%10;
                digits[i]=rem;
                carry=1;
            }
        }

        if(carry>0){
            int arr[]=new int[digits.length+1];
            arr[0]=carry;
            for (int i = 0; i < digits.length; i++) {
                arr[i+1]=digits[i];
            }
            return arr;
        }
    return digits;
    }

    /**
     * 一种比较简单且有效的解法
     * */
    public int[] plusOne2(int[] digits) {

        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }
        //能走到这一步的，一定是999...相关的数字，所以直接处理就行
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {

        int []arr={9,9,9};

        System.out.println(Arrays.toString(plusOne(arr)));


    }
}
