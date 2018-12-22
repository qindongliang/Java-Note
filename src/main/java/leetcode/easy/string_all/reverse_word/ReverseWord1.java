package leetcode.easy.string_all.reverse_word;

/**
 * 字符串反转例子
 *
 * Created by qindongliang on 2018/12/22.
 */
public class ReverseWord1 {


    public static String reverseString(String s) {
        char orgin[]=s.toCharArray();

        int len=orgin.length-1;
        int start=0;


        while(start<len){
            char temp=orgin[len];
            orgin[len]=orgin[start];
            orgin[start]=temp;
            len--;
            start++;

        }

        return new String(orgin);
    }


    public static void main(String[] args) {

        String str="A man, a plan, a canal: Panama";


        System.out.println(reverseString(str));


    }


}
