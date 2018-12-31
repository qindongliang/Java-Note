package basic.assert_test;

/**
 * Created by qindongliang on 2018/12/31.
 */
public class DemoAssert {


    public static String get(){
        return "abccacd";
    }


    public static void checkName(String name){
        assert name!=null:"name is empty";
    }

    public static void checkAge(int age){
        assert age>0 && age<=18;
    }


    public static void main(String[] args) {

        checkName(null);//测试校验

//        checkAge(25)



    }
}
