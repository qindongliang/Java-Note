package leetcode.easy.palindrome_number;

/**
 * Created by qindongliang on 2018/7/15.
 */
public class Palindrome_Number_Normal {


    public static boolean isPalindrome(int x) {


        if(x<0) return false;

        int temp=x;
        long reverse=0;
        while(temp>0){
            reverse=reverse*10+temp%10;
            temp=temp/10;

        }

        if(reverse>Integer.MAX_VALUE) return false;


    return reverse==x;
    }


    public static void main(String[] args) {


       boolean flag= isPalindrome(12621);


        System.out.println(flag);




    }


}
