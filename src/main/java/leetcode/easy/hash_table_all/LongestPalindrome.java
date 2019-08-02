package leetcode.easy.hash_table_all;

import java.util.HashSet;
import java.util.Set;

/****
 *
 * 给定一个字符串，求出这个字符串中能组成回文对的最大长度
 *
 * 思路分析：
 *
 * 如果一个字符串里面所有的字符串都成对出现，那么字符串的长度就是回文对的最大长度
 *
 * 如果一个字符串里面并不是所有的字符串都成对出现，那么我们只需要求出单独出现的字符的个数，
 * 用字符串的总长度减去单独字符串的个数再加1即可，因为加1可组成最大的回文对长度。
 *
 * 实现的代码如下：
 *
 */
public class LongestPalindrome {

    public int longestPalindrome2(String s) {

        int []count=new int[128];
        int length=0;
        for (char c:s.toCharArray()){
            if(++count[c]==2){
                length+=2;//成对出现就+2
                count[c]=0;
            }
        }
        return length==s.length()?length:length+1;//不等于就总长度，那么其最大回文长度必定等于length+1
    }

    public int longestPalindrome(String s) {

        Set<Character> set=new HashSet<>();
        for (char c:s.toCharArray()){
            if(set.contains(c)){//如果重复出现，就移除这个字符
                set.remove(c);
            }else{
                set.add(c);//记录不成对不出现的字符
            }
        }

        int odd=set.size();//求出字符串的长度

        return s.length()-(odd==0?0:odd-1);//计算最大个数

    }


    public static void main(String[] args) {

    }

}
