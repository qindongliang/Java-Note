package class_loader;

/**
 * Created by qindongliang on 2018/9/24.
 */
public class ThreadContextTest {



    public static void showAllParent(ClassLoader c){

        ClassLoader cl=c;

        while (cl!=null){
            System.out.println(cl);
            cl=cl.getParent();
        }
        System.out.println(cl);
    }


    public static class MyCustomClassLoader extends ClassLoader{

        public MyCustomClassLoader() {

            System.out.println("加载了");
        }

        @Override
        public String toString() {
            return "MyCustomClassLoader is print";
        }
    }



    public static void main(String[] args) {

        showAllParent(ThreadContextTest.class.getClassLoader());


//        System.out.println(ThreadContextTest.class.getClassLoader());

        System.out.println("====================");

        Thread.currentThread().setContextClassLoader(new MyCustomClassLoader());

        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                showAllParent(Thread.currentThread().getContextClassLoader());

            }
        };

        Thread t1=new Thread(runnable);

        t1.start();



    }


}
