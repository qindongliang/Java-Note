package leetcode.easy.reverse_interger;

/**
 * Created by Administrator on 2018/7/10.
 */
public class Solution_Normal1 {


    public static int reverse(int x) {

        long temp=x;

        if(x<0){
            temp = temp * -1;
        }

       StringBuilder sb=new StringBuilder(String.valueOf(temp));
        long value=Long.parseLong(sb.reverse().toString());
        if(value>Integer.MAX_VALUE){
            return 0;
        }

        if (x<0){
          return (int)value * -1;

        }

        return  (int)value;

    }


    public static void main(String[] args) {


        System.out.println(reverse(-2147483648));
//        System.out.println(reverse(123));



    }

}
