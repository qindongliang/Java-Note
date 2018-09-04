package concurrent.tools.map;

import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {

        //基于红黑树的实现
        TreeMap<String,Integer> map=new TreeMap<>();

        map.put("a12",1);
        map.put("d6",11);
        map.put("a2",12);
        map.put("b2",3);


        System.out.println(map);


    }

}
