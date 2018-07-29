package basic;

/**
 * Created by qindongliang on 2018/7/22.
 */
public class ReturnTest {








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






    public static void main(String[] args) {


//        System.out.println( case1() );
//        System.out.println( case2() );
//        System.out.println( case3() );


//        System.out.println(case21());
//          test1();


        System.out.println(getInc());
        System.out.println(getInc());

    }




}
