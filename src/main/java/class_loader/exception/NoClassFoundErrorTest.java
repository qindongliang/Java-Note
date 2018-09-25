package class_loader.exception;

/**
 * Created by qindongliang on 2018/9/25.
 */
public class NoClassFoundErrorTest {

    public static void main(String[] args) {

        try {
            double i=Loading.i;
        }catch (Throwable e){//此处，必须用Throwable，用Exception会直接退出。
            System.out.println(e);
        }


        //继续使用
        Loading.print();


    }

}
