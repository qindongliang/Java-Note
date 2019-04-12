package proxy.cglib_dynamic_proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import proxy.jdk_dynamic_proxy.SaveClassToDisk;

import java.lang.reflect.Method;

public class MyInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println(o.getClass().getName());
        System.out.println("调用了");

//        methodProxy.invokeSuper(o,objects);
//        SaveClassToDisk.save(o.getClass().getName(),o.getClass(),"G:/proxy.cglib_proxy.Hello$$EnhancerByCGLIB$$733c4bc0.class");
        SaveClassToDisk.save(o.getClass().getName(),o.getClass(),"./gxx.class");
        return null;
    }
}
