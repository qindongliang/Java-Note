package algorithm.recursion;

/**
 * Created by qindongliang on 2018/10/13.
 */
public class RecursionDemo {

    static int count=0;


    public static void test1(){
        if(count==5){
            System.out.println("=============拆解完毕，开始分治==================");
            return;
        }
        count++;
        System.out.println("递归调用，当前栈深度： "+count);
        test1();
        System.out.println("递归返回，当前栈深度： "+count--);



    }


    public static void main(String[] args) {


        test1();

    }


}
