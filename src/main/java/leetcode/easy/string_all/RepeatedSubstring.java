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

    public static boolean repeatedSubstringPattern1(String str) {
        // abab abab
        String s = str + str;
        // abababab
        String sub=s.substring(1, s.length() - 1);
        //
        return sub.contains(str);
    }

    // 方法2  主要思路是对于任意一个字符串序列，如果它是由重复的字符串组成，那么这个
    // 子串的长度肯定是字符串长度的公约数，所以拿字符串的长度依次遍历除以所有的数
    // 找出每一个子串，然后根据这个offset截取判断就行，最后i的值如果整除肯定是字符串的长度
    public static boolean repeatedSubstringPattern(String str) {
        int len= str.length();
        for (int i=1;i<=len/2;i++){
            if(len%i!=0){
                continue;
            }
            String pattern=str.substring(0,i);

            int offset=i;
            int j=i+offset;
            while (j<=len){
                if(!str.substring(i,j).equals(pattern)){
                    break;
                }
                i+=offset;
                j+=offset;
            }
            if(i==len){
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        System.out.println(repeatedSubstringPattern("abcabcabc"));


    }

}
