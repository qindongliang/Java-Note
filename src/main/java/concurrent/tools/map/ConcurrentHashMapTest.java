package concurrent.tools.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {


    public static void main(String[] args) {


        ConcurrentHashMap<HashMapTest.MyKey,String> map=new ConcurrentHashMap<>(2);

        HashMapTest.MyKey m1=new HashMapTest.MyKey("71");
        HashMapTest.MyKey m2=new HashMapTest.MyKey("51");
        HashMapTest.MyKey m3=new HashMapTest.MyKey("31");
        HashMapTest.MyKey m4=new HashMapTest.MyKey("9");
        map.put(m1,"m1");
        map.put(m2,"b1");
        map.put(m3,"b2");
        map.put(m4,"m4");

        System.out.println(map);



    }
}
