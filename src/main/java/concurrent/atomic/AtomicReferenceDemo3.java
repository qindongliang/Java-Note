package concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by qindongliang on 2018/8/5.
 */
public class AtomicReferenceDemo3 {


    private static AtomicReference<String> tail;
    private static AtomicReference<String> tail2=new AtomicReference<>(null);


    public static void main(String[] args) {


        System.out.println(tail2.getAndSet("ff"));

    }

}
