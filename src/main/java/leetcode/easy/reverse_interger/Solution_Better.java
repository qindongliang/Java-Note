package leetcode.easy.reverse_interger;

/**
 * Created by qindongliang on 2018/7/10.
 */
public class Solution_Better {


    public static int reverse(int x) {

        int temp=x;

        if (x<0){
            temp=x* -1;
        }

        long reverse=0;

        while (temp>0){
            reverse=reverse*10+ temp%10;
            temp=temp/10;
        }

        if(reverse>Integer.MAX_VALUE) return 0;

        if(x<0) return (int)reverse* -1;


        return (int)reverse;

    }

    public static void main(String[] args) {


        System.out.println(reverse(-1563847412));







    }


}
