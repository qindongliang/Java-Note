package leetcode.easy.array_all;

import java.util.ArrayList;
import java.util.List;

/****
 *
 * https://leetcode.com/problems/self-dividing-numbers/
 *
 *  Self Dividing Numbers
 *
 *  给定一个数字范围，left和right，遍历其中的每一个数字
 *
 *  比如这个数字是123，那么这个数字本身，如果能除尽1，2，3，那么该数字就符合规则，
 *  如果数字里面包括0，就结束。
 *
 */
public class SelfDividingNumbers {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();
        for (int i = left; i <=right ; i++) {
            if(isGood(i)){
                list.add(i);
            }
        }
      return list;
    }


    private static boolean isGood(int temp){
        int x=temp;

        while (x!=0){
            int n=x%10;//取出数字的每一位
            //判断如果这位数字等于0，或者除不尽就直接返回false
            if(n==0|| temp%n != 0){
                return false;
            }
            //继续向下除10
            x=x/10;
        }
        //如果x==0就返回true
        return true;

    }



    public static void main(String[] args) {

        selfDividingNumbers(1,22);

    }

}
