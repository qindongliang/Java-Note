package singleton.create;

import java.io.*;

/**
 * Created by qindongliang on 2018/7/5.
 */
public enum EnumSingleton {

    SINGLETON;


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            CloneNotSupportedException {


//
//        EnumSingleton.SINGLETON.clone();//枚举的类克隆不支持
//
//       Class c=  Class.forName(EnumSingleton.class.getName());
//
//       c.newInstance();//枚举的类不能反射

        serializable();//序列化正常

    }



    public static void serializable(){

        try
        {
            EnumSingleton instance1 = EnumSingleton.SINGLETON;
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
            out.writeObject(instance1);
            out.close();

            // deserailize from file to object
            ObjectInput in
                    = new ObjectInputStream(new FileInputStream("file.text"));

            EnumSingleton instance2 = (EnumSingleton) in.readObject();
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


}
