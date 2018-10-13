package algorithm.recursion;

/**
 *
 * 使用递归算法实现阶乘的例子
 *
 * Created by qindongliang on 2018/10/13.
 */
public class FactorialRecursion {


    public static int factrial(int n){
        if(n<1){
            return 1;
        }
        return  n*factrial(n-1);

    }

    public static int factrialDetail(int n){
        if(n<1){
            System.out.println("拆解问题完毕，开始分而治之");
            return 1;
        }
        System.out.println("f("+n+")="+n+" * f("+(n-1)+")");
        int z= n*factrialDetail(n-1);

        System.out.println("f("+n+")="+z);

        return  z;

    }





    public static void main(String[] args) {

         factrialDetail(5);

    }
}
