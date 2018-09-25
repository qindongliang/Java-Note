package class_loader.exception;

/**
 * Created by qindongliang on 2018/9/25.
 */
public class Loading {

    static double i=1/0;//故意使得类初始化失败

    public static void print(){

        System.out.println("123");
    }

}
