package basic;

/**
 * Created by qindongliang on 2018/9/23.
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        //默认是类初始化，可以选择关闭
//        Class c= Class.forName("basic.ReturnTest");


        //关闭类的初始化
        Class c1= Class.forName("basic.ReturnTest",true,ReturnTest.class.getClassLoader());
//        c1.newInstance();//实例初始化
    }


}
