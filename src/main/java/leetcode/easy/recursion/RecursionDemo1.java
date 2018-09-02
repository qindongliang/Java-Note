package leetcode.easy.recursion;

/**
 * Created by qindongliang on 2018/9/2.
 */
public class RecursionDemo1 {

    public static int getN(int n){
        if(n!=1){
            return n*getN(n-1);
        }else {
            return 1;
        }
    }

    public static void main(String[] args) {

        System.out.println(getN(5));

    }

}
