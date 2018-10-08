package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountTimeProxyInvocation implements InvocationHandler {

    private final Map<String,Method>  ms=new HashMap<>();

    private Object target;


    public CountTimeProxyInvocation(Object target) {
        this.target = target;

        for(Method method:target.getClass().getDeclaredMethods()){
            String name=method.getName();
//            System.out.println(name);
            ms.put(name,method);
        }

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(proxy+"  "+method+" "+ args.toString());
//        System.out.println(proxy);
        System.out.println(method+"  "+Arrays.toString(args));
        long start=System.nanoTime();
        System.out.println("调用之前.......");
//        Object result=ms.get(method.getName()).invoke(target,args);
        Object result=method.invoke(target,args);
        long cost=System.nanoTime()-start;
        System.out.println("调用之后，"+method.getName()+" 耗时： "+cost+" ns");

        return result;
    }
}
