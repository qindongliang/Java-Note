package leetcode.easy.string_all;

/***
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * 给定一个数组，计算他们的最长公共前缀字符串。
 *
 * 解决思路：
 *
 * 既然是最长公共字符串，那么根据木桶原理，最短的字符串一定是影响公共字符串的重要因素，
 * 所以下面的方式，我们应该首先寻找长度最短的字符串，然后从其下手。
 *
 * 找到最短的字符串之后，然后遍历所有的字符串，与其全串比较，如果匹配与下一个比较，如果不匹配则要
 * 对最短字符串长度去掉一个尾字符后继续判断，直到这两个字符串有公共部分，然后继续与下一个比较，依次
 * 比较完所有的串之后，最终返回结果。如果没有匹配，那么最终返回的是空字符串。
 *
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {


        if(strs.length<1 || strs==null){
            return "";
        }

        if(strs.length==1){
            return strs[0];
        }
        //find the shortest string

        int shortest=0;
        int len=strs[0].length();
        for (int i = 1; i <strs.length ; i++) {
            int curLen=strs[i].length();
            if(curLen<len){
                len=curLen;
                shortest=i;
            }
        }

        //find the longest common prefix
        String sub=strs[shortest];
        for (int i = 0; i < strs.length; i++) {

            while (strs[i].indexOf(sub)!=0){
                sub=sub.substring(0,sub.length()-1);
            }

        }


        return sub;
    }


    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));

//        System.out.println("abc".indexOf(""));

    }



}
