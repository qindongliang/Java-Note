package leetcode.easy.array_all;

import java.util.HashMap;
import java.util.Map;

/****
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * 给定一组卡牌，让求出里面相同数字的所有分组，分组的数量不得小于2
 *
 * 思路：遍历一遍数组，求出每个数字的数量
 * 然后，对数量之间求出最大公约数，最后如果最大公约数2即可。
 */
public class KindDeckCards {

    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> count=new HashMap<>();
        for (int i :deck) {
            count.put(i,count.getOrDefault(i,0)+1);
        }
        int res=0;
        for (int i:count.values()){
            res=gcd(i,res);
        }

        return res>1;
    }

    //最大公约数算法->辗转相除法
    public static   int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }


    public static void main(String[] args) {
        int arr[]={0,0,0,1,1,1,2,2,2};
        System.out.println(hasGroupsSizeX(arr));

    }
}
