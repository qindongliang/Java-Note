package proxy.jdk_dynamic_proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCountTimeProxy {

    private static void testMap(){
        Map map= (Map) Proxy.newProxyInstance(TestCountTimeProxy.class.getClassLoader(),
                new Class[]{Map.class},//必须接口类型，可以有多个接口
                new CountTimeProxyInvocation(new HashMap())
        );

        map.put("t",12);
        map.get("1");
        map.size();
    }

    private static void testList(){

        List list= (List) Proxy.newProxyInstance(TestCountTimeProxy.class.getClassLoader(),
                new Class[]{List.class}, //必须是接口才行
                new CountTimeProxyInvocation(new ArrayList<>())
        );

        list.add("1");
        list.contains("d");
    }


    private static void testString(){

        CharSequence str= (CharSequence) Proxy.newProxyInstance(TestCountTimeProxy.class.getClassLoader(),
                new Class[]{CharSequence.class}, //必须是接口才行
                new CountTimeProxyInvocation(new String())
        );

        str.length();
    }




    public static void main(String[] args) throws Exception {


//        testList();
        testMap();
//        testString();







    }

}
