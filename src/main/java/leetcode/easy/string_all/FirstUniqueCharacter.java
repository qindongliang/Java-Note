package leetcode.easy.string_all;

/**
 * 给定一个字符串，求出这个字符串里面第一个是唯一出现的字符
 *
 *
 */

public class FirstUniqueCharacter {


    public static int firstUniqChar(String s) {

        int array[]=new int[26];

        //先遍历一遍，求出每个字母所在位置的词频
        for (int i=0;i<s.length();i++) {
            int index=s.charAt(i)-'a';
            array[index]++;
        }

        //第二次按字符串顺序判断其词频是多少，如果是1，说明其只出现过一次，即符合要求
        for (int i=0;i<s.length();i++) {
            if(array[s.charAt(i)-'a']==1){
                return i;
            }
        }

        return  -1;
    }


    public static void main(String[] args) {

        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));

    }



}
