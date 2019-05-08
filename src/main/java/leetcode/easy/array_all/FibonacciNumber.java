package leetcode.easy.array_all;

/****
 * https://leetcode.com/problems/fibonacci-number/
 * 斐波那契数列的迭代版本和递归版本
 */
public class FibonacciNumber {

    public static int fib(int N) {
        if(N<=1){
            return N;
        }

        int a=0;
        int b=1;
        while (N-->1){
            int sum=a+b;
            a=b;
            b=sum;
        }
        return b;
    }




    public static int fib2(int N) {
        if(N<=1){
            return N;
        }
        return fib2(N-1)+fib2(N-2);
    }


    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib2(10));
    }


}
