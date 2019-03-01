package leetcode.easy.string_all;
/***
 *https://leetcode.com/problems/repeated-substring-pattern/
 *
 * 给定一个字符串，判断这个字符串是否能由里面的重复的字符列组成
 *
 * 比如abab，就能由ab出现2次组成
 * 比如aba，就不行就不行
 * 写出一个算法用来判断输入的字符串是否可以由重复的子串组成
 * 是的话返回true，不行的话返回false
 */
public class RepeatedSubstring {

    public static boolean repeatedSubstringPattern(String str) {
        // abab abab
        String s = str + str;
        // abababab
        String sub=s.substring(1, s.length() - 1);
        //
        return sub.contains(str);
    }


    public static void main(String[] args) {

        System.out.println(repeatedSubstringPattern("abab"));


    }

}
