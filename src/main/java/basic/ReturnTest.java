package basic;

/**
 * Created by qindongliang on 2018/7/22.
 */
public class ReturnTest {

    static {

        System.out.println("静态块初始化.....  ");

    }
    public  String name=getNameValue();
    public static int count=getValue();



    {
        System.out.println("构造块会执行吗.....");
    }

    public String getNameValue(){
        System.out.println("成员变量初始化赋值");
        return "实例初始化赋值";
    }

    public static int  getValue(){
        System.out.println("静态变量初始化赋值");
        return  6;
    }





    public ReturnTest(){

        System.out.println(" 被初始化了...... ");
    }





    public static int  case1(){
        int count=10;
        try{
            System.out.println("try");
            return count;
        }finally {
            count=count+50;
            System.out.println("finally: "+count);
        }

    }

    public static StringBuilder case2(){
        StringBuilder sb=new StringBuilder();
        try{
            System.out.println("try");
            return sb.append("try");
        }finally {
             sb.append("+finally");
            System.out.println("finally: "+sb.toString());
        }

    }



    private static int counter=1;


    private static int getInc(){


        counter++;

        return counter;
    }






    public static void main(String[] args) throws ClassNotFoundException {


//        System.out.println( case1() );
//        System.out.println( case2() );
//        System.out.println( case3() );


//        System.out.println(case21());
//          test1();


//        System.out.println(getInc());
//        System.out.println(getInc());






    }




}
