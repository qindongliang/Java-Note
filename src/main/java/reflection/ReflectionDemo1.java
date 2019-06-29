package reflection;

import java.lang.reflect.Method;

public class ReflectionDemo1 {

    public static void m4() {

    }

    public static void main(String[] args) {


        Method[] methods = ReflectionDemo1.class.getMethods();

        for (Method method : methods) {

            System.out.println(method.getName());
        }

    }

    public void m1() {

    }

    public void m2() {

    }

    public void m3() {

    }

}
