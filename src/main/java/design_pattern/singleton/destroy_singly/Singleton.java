package design_pattern.singleton.destroy_singly;

import java.io.Serializable;

public class Singleton implements Serializable,Cloneable {

    //在类初始化期间，执行由JVM保证线程安全
    private static Singleton singleton=new Singleton();


    //避免反射和多类加载器破坏
    private Singleton() {
            if (Singleton.singleton != null) {
                throw new InstantiationError("Creating of this object is not allowed.");
            }

    }

    public static Singleton getInstance(){
        return singleton;
    }

    //避免克隆破坏
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of this class is not allowed");
//        return super.clone();
    }

//    //避免反序列破坏
    protected Object readResolve() {
        return singleton;
    }



}
