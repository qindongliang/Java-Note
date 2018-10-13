package algorithm.recursion;

/**
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233
 * 斐波那契数列（意大利语：Successione di Fibonacci），黄金分割数列。
 *
 * Created by qindongliang on 2018/10/13.
 */
public class FibonacciRecursion {


    public static int fibonacci(int n){
        if(n<0){
            throw new IllegalArgumentException("传入参数不合法");
        }
        if(n<=2) {
            return 1;
        };
        //先计算第一个递归函数
        int plusItem1=fibonacci(n-1);
        int plusItem2=fibonacci(n-2);
        int sum=plusItem1+plusItem2;

        return sum;

    }

    public static void main(String[] args) {

        System.out.println(fibonacci(4));

    }

}
