package basic;

/**
 * Created by qindongliang on 2018/6/23.
 */
public class StringConcatPermanceTest {


    public static void main(String[] args) {



        final int loop_count=10000;

        // 1 +
        String s1="s1";
        long startTime=System.nanoTime();

        for (int i = 0; i < loop_count; i++) {
            s1=s1+Integer.toString(i);
        }
        long duration=System.nanoTime()-startTime;
        System.out.println(" + cost: "+duration/1000+" 微秒 ");



        // 2 concat
        String s2="s2";
        startTime=System.nanoTime();
        for (int i = 0; i < loop_count; i++) {
            s2=s2.concat(Integer.toString(i));
        }
        duration=System.nanoTime()-startTime;
        System.out.println(" concat cost: "+duration/1000+" 微秒 ");


        // 3 stringbuffer
        StringBuffer s3=new StringBuffer("s3");
        startTime=System.nanoTime();
        for (int i = 0; i < loop_count; i++) {
            s3.append(Integer.toString(i));
        }
        duration=System.nanoTime()-startTime;
        System.out.println(" StringBuffer cost: "+duration/1000+" 微秒 ");



        // 4 stringbuilder
        StringBuilder s4=new StringBuilder("s4");
        startTime=System.nanoTime();
        for (int i = 0; i < loop_count; i++) {
            s4.append(Integer.toString(i));
        }
        duration=System.nanoTime()-startTime;
        System.out.println(" StringBuilder cost: "+duration/1000+" 微秒 ");









    }


}
