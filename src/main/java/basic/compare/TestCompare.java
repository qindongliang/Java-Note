package basic.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCompare {

    static class NameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }


    public static void main(String[] args) {

        List<Person> list=new ArrayList<>();

        Person p1=new Person(23,"john");
        Person p2=new Person(43,"com");
        Person p3=new Person(5,"aim");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        Collections.sort(list);
//        Collections.sort(list,new NameComparator());
        for(Person person:list){
            System.out.println(person);
        }


    }


   class StringComparator implements Comparator<String>{

       @Override
       public int compare(String o1, String o2) {
           return -o1.compareTo(o2);
       }
   }


    @Test
    public void print(){

        List<String> list=new ArrayList<>();
        list.add("x");
        list.add("a");
        list.add("c");
        list.add("y");

//        Collections.sort(list);
        Collections.sort(list, new StringComparator());

        System.out.println(list);



    }


}
