package concurrent.tools.concurrent_modify;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModifyTest {

    private static void foreachDel(List<String> list){
        for(String str:list){
            if(str.equals("a")){
                list.remove(str);
            }
        }
    }

    private static void iteritorDel(List<String> list){
        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            String item=iterator.next();
            if(item.equals("a")){
                iterator.remove();

            }
        }

        System.out.println(list);
    }

    public static void main(String[] args) {



        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        iteritorDel(list);

        CopyOnWriteArrayList<String> copyList=new CopyOnWriteArrayList<>();
        copyList.add("b");
        copyList.add("b1");
        copyList.add("b2");

        Iterator<String> itor=copyList.iterator();
        while(itor.hasNext()){
            String str=itor.next();
            if(str.equals("b")){
                itor.remove();
            }
        }






    }

}
