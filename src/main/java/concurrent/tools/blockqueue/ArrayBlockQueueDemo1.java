package concurrent.tools.blockqueue;

import java.util.Comparator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by qindongliang on 2018/9/1.
 */
public class ArrayBlockQueueDemo1 {

    static BlockingQueue<String> queue1=new ArrayBlockingQueue<String>(4);
    static BlockingQueue<String> queue2=new LinkedBlockingQueue<>(4);
    static BlockingQueue<User> queue3=new PriorityBlockingQueue<>(1);


    public static void main(String[] args) throws InterruptedException {


        User u1=new User("tom",23);
        User u2=new User("jack",13);
        User u3=new User("lady",34);

        queue3.put(u1);
        queue3.put(u2);
        queue3.put(u3);


        System.out.println(queue3.take());
        System.out.println(queue3.take());
        System.out.println(queue3.take());
        System.out.println(queue3.take());




    }


    public static class User implements Comparable<User> {

        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int compareTo(User o) {
            return this.age-o.age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }




    public static void testArrayQueue(BlockingQueue queue) throws InterruptedException {
        queue.put("a");
        queue.put("b");
        queue.put("c");
        queue.put("d");

//        System.out.println(queue.size());

        System.out.println(queue.take());
        System.out.println(queue.peek());

    }



}
