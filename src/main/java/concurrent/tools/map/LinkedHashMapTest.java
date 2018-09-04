package concurrent.tools.map;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {

    public static void main(String[] args) {

        // (1) 维护了插入数据的顺序
        // (2) 可以通过按访问顺序排序，如下声明，第三个参数控制
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(16,0.75f,true);
        map.put("21",1) ;
        map.put("12",2) ;
        map.put("3",3) ;
        map.put("74",4) ;
        map.put("75",5) ;

        //

        System.out.println(map.toString());


        System.out.println(map.get("21"));
        System.out.println(map.get("3"));

        System.out.println(map.toString());




    }
}
