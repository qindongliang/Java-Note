package concurrent.tools.concurrent_modify;

import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetTest {


    public static void main(String[] args) {


        CopyOnWriteArraySet<String> list=new CopyOnWriteArraySet<>();

        list.add("b");
        list.add("b");
        list.add("c");

        System.out.println(list);


    }

}
