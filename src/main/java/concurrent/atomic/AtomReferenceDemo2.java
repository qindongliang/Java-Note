package concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by qindongliang on 2018/8/5.
 */
public class AtomReferenceDemo2 {

    static class Person{

        public String name;
        public volatile boolean flag;

    }

    public static AtomicReference<Person> atomic=new AtomicReference<>();


    public static void main(String[] args) {

        Person p1=new Person();
        p1.name="abc";
        p1.flag=false;

        atomic.getAndSet(p1);

        new Thread(()->{

            Person temp=atomic.get();
            while (!temp.flag){

            }
            System.out.println("my .... end ");

        }).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        p1.flag=true;

        System.out.println("main end .....");


//
//        System.out.println(pOld);

    }




}
