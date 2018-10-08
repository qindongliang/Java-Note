package proxy.jdk_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Map;

public class TestSimpleProxy {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException {


//        Map proxyInstance= Proxy.newProxyInstance()


        InvocationHandler handler=new SimpleInvocation();

        Class proxyClass=Proxy.getProxyClass(Map.class.getClassLoader(),Map.class);

        Map<String,String> map=(Map) proxyClass.getConstructor(InvocationHandler.class).newInstance(handler);

        map.put("xt","x");


        // 方式2


        Map map2=(Map) Proxy.newProxyInstance(TestSimpleProxy.class.getClassLoader(),new Class[]{Map.class},handler);

        map.put("1","2");






    }
}
