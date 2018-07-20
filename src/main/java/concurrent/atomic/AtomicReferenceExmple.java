package concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Administrator on 2018/7/20.
 */
public class AtomicReferenceExmple {

    static AtomicReference<Person> p=new AtomicReference<Person>(new Person(20));

    static volatile int count=20;


    /***
     * 简单更新
      */
    public static void simpleUpdate(){

        System.out.println(" 之前： "+p.get().getAge());

        Person current,person;

        do{
            current=p.get();
            person=new Person(30);

        }while (!p.compareAndSet(current,person));


        System.out.println(" 之后： "+p.get().getAge());
    }


    public static void main(String[] args) throws InterruptedException {

        testCompareSet(300000);

        System.out.println("only volatile is error : "+count+ " only atomic is right  "+p.get().getAge());


    }

    public static void testCompareSet(int loop_count) throws InterruptedException {
        //set 方法等同于volatile的读写语义
        Thread t1=new Thread(()->{
            for (int i = 0; i <loop_count; i++) {
                count=count+10;
                Person current_person,new_person;
                do{
                    current_person=p.get();
                    new_person=new Person(current_person.getAge()+10);
                }while (!p.compareAndSet(current_person,new_person));

            }


        });



        Thread t2=new Thread(()->{

            for (int i = 0; i <loop_count; i++) {
                count=count-10;
                Person current_person,new_person;
                do{
                    current_person=p.get();
                    new_person=new Person(current_person.getAge()-10);
                }while (!p.compareAndSet(current_person,new_person));

            }


        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }





    public static void testSet() throws InterruptedException {
        //set 方法等同于volatile的读写语义
        Thread t1=new Thread(()->{
            for (int i = 0; i <300; i++) {
                p.set(new Person(p.get().getAge()+10));
                count=count+10;
            }


        });



        Thread t2=new Thread(()->{

            for (int i = 0; i <300; i++) {
                p.set(new Person(p.get().getAge()-10));
                count=count-10;

            }


        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }











}
