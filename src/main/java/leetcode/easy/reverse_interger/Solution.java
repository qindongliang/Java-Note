package leetcode.easy.reverse_interger;

/**
 * Created by Administrator on 2018/7/10.
 */
public class Solution {


    public static int reverse(int x) {

        if(x==Integer.MIN_VALUE){
            return 0;
        }


        boolean is_negative=false;
        if(x<0){
            is_negative=true;
            x=x * -1;
        }

       StringBuilder sb=new StringBuilder(String.valueOf(x));
        long value=Long.parseLong(sb.reverse().toString());
        if(value>Integer.MAX_VALUE|| value<Integer.MIN_VALUE){
            return 0;
        }

        if (is_negative){
          return (int)value * -1;

        }



        return  (int)value;

    }


    public static void main(String[] args) {


        System.out.println(reverse(-2147483648));



    }

}
