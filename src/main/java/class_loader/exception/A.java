package class_loader.exception;

/**
 * Created by qindongliang on 2018/9/26.
 */
public class A {

    public void hello(){

        System.out.println("A hello");
    }

}

 class B {

     public static void main(String[] args) {

         A a=new A();//如果A类的class文件，在运行时找不到，就会抛出NoClassDefFoundError异常。

     }

}
