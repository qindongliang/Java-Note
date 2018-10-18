package singleton.destroy_singly;

import java.io.*;
import java.lang.reflect.Constructor;

public class TestDestroySingleton {
    public static void main(String[] args) throws Throwable {


        // 创建对象的方式：
        // new
        // 反射
        // 克隆
        // 序列化
        // 自定义类单独加载


//        reflectDestory();
//        serializableDestory();
//          cloneDestory();

        classLoaderDestroy();
    }

    /***
     * 通过反射破坏单例模式
     * @throws Throwable
     */
    public static void reflectDestroy()throws Throwable{

        //可以访问私有构造器
        Constructor const1= Singleton.class.getDeclaredConstructor();
        const1.setAccessible(true);
        Singleton singletion1=(Singleton)const1.newInstance();
//        System.out.println(singletion1);
    }


    public static void classLoaderDestroy() throws Exception {
        String path="src/main/resources/class/Singleton.class";

        //系统类加载的
        Singleton orgin=Singleton.getInstance();

        //自定义类加载器
        MyClassLoader myClassLoader=new MyClassLoader(path);
        Class c= myClassLoader.loadClass("");
        //反射创建的
        Class cf=Class.forName(Singleton.class.getName());

        System.out.println("反射的类对比当前的类："+(cf==Singleton.class));
        System.out.println("自定义类加载加载的类对比当前的类："+(c==Singleton.class));

//        Constructor cr= c.getDeclaredConstructor();
//        cr.setAccessible(true);
//        Object s2=  cr.newInstance();
//
//        System.out.println(s2.getClass());



    }


    public static void serializableDestroy(){

        try
        {
            Singleton instance1 = Singleton.getInstance();
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
            out.writeObject(instance1);
            out.close();

            // deserailize from file to object
            ObjectInput in
                    = new ObjectInputStream(new FileInputStream("file.text"));

            Singleton instance2 = (Singleton) in.readObject();
            in.close();

            System.out.println("instance1 hashCode:- "
                    + instance1.hashCode());
            System.out.println("instance2 hashCode:- "
                    + instance2.hashCode());
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    private static void cloneDestroy()throws Throwable{
        Singleton instance1 = Singleton.getInstance();

        Singleton s2=(Singleton) instance1.clone();

        System.out.println(instance1);
        System.out.println(s2);

    }

}
