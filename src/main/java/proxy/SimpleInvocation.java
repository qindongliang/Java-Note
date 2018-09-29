package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SimpleInvocation implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" method： "+method.getName());
        show();
        return 42;

    }

    public void show(){

        System.out.println("123");

    }
}
