package leetcode.easy.string_all;

/****
 *
 * https://leetcode.com/problems/valid-palindrome/
 *
 * 题目是用来考察输入的字符串是否为回文字符串，但相比之前的回文判断，这里
 * 多了点障眼法，并不是直接给一个串，而是给了一句话，由多个单词组成
 * 然后让我们判断，这一句话是否为回文串，里面加了一些干扰因素，比如空格，标点符号等
 * 虽然多了些干扰项，但解决思路与之前类型，这里采用双指针法，声明两个变量，分别从
 * 头和尾开始，计数，遇到数字或者字母就停下来，然后对比是否相等，这里注意要忽略大小写
 * ，如果相等就继续往中间走，否则就返回false

 */

public class ValidPalindrome3 {

    public static boolean isPalindrome(String s) {

        if(s==null||s.length()==0) return true;

        int start=0;
        int end = s.length()-1;

        while (start<=end){

            while (start<=end&&!Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while (start<=end&&!Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }

            if(start<=end && Character.toUpperCase(s.charAt(start)) != Character.toUpperCase(s.charAt(end)))
                return false;

            start++;
            end--;

        }

        return true;
    }

    public static void main(String[] args) {

        isPalindrome("A man, a plan, a canal: Panama");

    }


}
