package algorithm;

/**
 * Created by qindongliang on 2018/7/15.
 * 判断是否为回文数字
 */
public class Palindrome_Number_Normal {


    public static boolean isPalindrome(int x) {

        //边界校验
        if(x<0) return false;
        //赋一个临时值
        int temp=x;
        //用来存储反转后的数字
        long reverse=0;
        while(temp>0){
            //对原数每次缩小10倍后取模，依次从右到左得到每个数字
            //循环的次数就是放大的倍数，每次乘以10加上余数就能够得到反转的数字
            reverse=reverse*10+temp%10;
            temp=temp/10;

        }
        //判断临街值
        if(reverse>Integer.MAX_VALUE) return false;


    return reverse==x;
    }


    public static void main(String[] args) {


       boolean flag= isPalindrome(12621);


        System.out.println(flag);




    }


}
