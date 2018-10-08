package proxy.jdk_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CountTimeProxyInvocation implements InvocationHandler {

    private Object target;

    public CountTimeProxyInvocation(Object target) {
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(proxy+"  "+method+" "+ args.toString());
        System.out.println("name："+proxy.getClass().getName());
        SaveClassToDisk.save(proxy.getClass().getName(),proxy.getClass(),"G:/$Proxy0.class");
        System.out.println(method+"  "+Arrays.toString(args));//传入的参数类型
        long start=System.nanoTime();
        System.out.println("调用之前.......");
//        Object result=ms.get(method.getName()).invoke(target,args);
        Object result=method.invoke(target,args);
        long cost=System.nanoTime()-start;
        System.out.println("调用之后，"+method.getName()+" 耗时： "+cost+" ns");

        return result;
    }
}
