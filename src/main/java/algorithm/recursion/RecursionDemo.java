package algorithm.recursion;

/**
 * Created by qindongliang on 2018/10/13.
 */
public class RecursionDemo {

    static int count1=0;
    static int count2=0;


    public static void test1(){
        if(count1==5){
            System.out.println("=============递归1拆解完毕，开始分治==================");
            return;
        }
        count1++;
        System.out.println("递归方法1调用，当前栈深度： "+count1);
        test1();
        System.out.println("递归方法1返回，当前栈深度： "+count1--);
    }


    public static void test2(){

        if(count2==5){
            System.out.println("=============递归2拆解完毕，开始分治==================");
            return;
        }
        count2++;
        System.out.println("递归方法2调用，当前栈深度： "+count2);
        test2();
        System.out.println("***********递归方法2返回，当前栈深度： "+count2--+"**************");
        test1();
//        System.out.println("递归返回，当前栈深度： "+count2--);
    }



    public static void main(String[] args) {


//        test1();

        test2();

    }


}
