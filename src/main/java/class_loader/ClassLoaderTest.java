package class_loader;

/**
 * Created by qindongliang on 2018/9/20.
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
//        https://blog.csdn.net/briblue/article/details/54973413

        showClassLoaderPath();


    }
    public static void showClassLoaderForeachPath(){

        System.out.println();
        //BoostrapClassLoader
        String[] split=System.getProperty("sun.boot.class.path").split(":");
        for(String data:split){
            System.out.println(data);
        }

        System.out.println("===================");
        //ExeClassLoader
        String[] split1=System.getProperty("java.ext.dirs").split(":");
        for(String data:split1){
            System.out.println(data);
        }




        System.out.println("===================");
        //AppClassLoader
        String[] split2=System.getProperty("java.class.path").split(":");
        for(String data:split2){
            System.out.println(data);
        }

        System.out.println("================");
    }

    public static  void showClassLoaderPath(){

        System.out.println(ClassLoaderTest.class.getClassLoader());
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent());
        System.out.println(ClassLoaderTest.class.getClassLoader().getParent().getParent());
//        System.out.println(ClassLoaderTest.class.getClassLoader().getParent().getParent().getParent());
        System.out.println("------------------------------------");
        System.out.println(int.class.getClassLoader());
        System.out.println(String.class.getClassLoader());

    }
}
