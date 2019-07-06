package reflection.base;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestReflection {

    public static void main(String[] args) throws Exception {


//        testGetSuperClass();

//        testPublicMemberClass();

//        testGetTypeInfomation();

//        getPublicMethods();

//        getPublicConstructors();


        Constructor constructor = Class.forName("reflection.base.BaseImpl").getDeclaredConstructor(String.class);

        constructor.setAccessible(true);
        BaseImpl obj = (BaseImpl) constructor.newInstance("你好");


        System.out.println(obj.str);


    }

    public static void testMethod() throws Exception {
        Method method = Class.forName("reflection.base.BaseImpl").getDeclaredMethod("method9");

        method.setAccessible(true);

        method.invoke(new BaseImpl(), null);

    }

    public static void testField() throws Exception {

        Field field = Class.forName("reflection.base.BaseImpl").getDeclaredField("privateString");

        System.out.println(field.getType());
        field.setAccessible(true);
        BaseImpl base = new BaseImpl(5);

        System.out.println(field.get(base));//读取字段的值

        field.set(base, "123");//赋值

        System.out.println(field.get(base));//读取字段的值
    }


    public static void getPublicConstructors() {


//        Constructor[] methods = BaseImpl.class.getDeclaredConstructors();
//        Constructor[] methods = BaseImpl.class.getConstructors();
//        Field[] fields = BaseImpl.class.getFields();
        Annotation[] annotations = BaseImpl.class.getAnnotations();
        System.out.println(Arrays.toString(annotations));

    }

    public static void getPublicMethods() {


        Method[] methods = BaseImpl.class.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

    }

    public static void testGetTypeInfomation() throws Exception {
        TypeVariable<?>[] typeParameters = Class.forName("java.util.HashMap").getTypeParameters();
        for (TypeVariable<?> t : typeParameters)
            System.out.println(t.getName());
    }

    public static void testPublicMemberClass() throws Exception {

//        Class<?>[] classes = BaseImpl.class.getClasses();
        Class<?>[] classes = BaseImpl.class.getDeclaredClasses();
        for (Class cls : classes) {
            System.out.println(cls);
        }


    }


    public static void testGetSuperClass() throws Exception {

        Class superCls = Class.forName("reflection.base.BaseImpl").getSuperclass();

        System.out.println(superCls);

        Class[] superInterface = Class.forName("reflection.base.BaseImpl").getInterfaces();

        for (Class cx : superInterface) {
            System.out.println(cx);
        }
        System.out.println(Object.class.getSuperclass());
        System.out.println(String[][].class.getSuperclass());
    }


    public static void testGetClass() throws Exception {
        //引用类型的获取类实例的方法

        Class cls = BaseImpl.class;//method1

        cls = new BaseImpl(5).getClass(); //method2

        cls = Class.forName("reflection.base.BaseImpl"); // method3

        System.out.println(cls.getCanonicalName());//获取类的全路径名


        //基本类型获取类实例的方法


        Class baseCls = boolean.class;
        System.out.println(baseCls.getCanonicalName());

        Class baseCls2 = Double.TYPE; // Double.TYPE

        System.out.println(baseCls2.getCanonicalName());

        //一维的double数组
        Class baseCls3 = Class.forName("[D");

        System.out.println(baseCls3.getCanonicalName());

        //二维的字符串数组
        Class baseCls4 = String[][].class;

        System.out.println(baseCls4.getCanonicalName());
    }


}
