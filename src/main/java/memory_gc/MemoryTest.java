package memory_gc;

public class MemoryTest {

    private static final int _1MB = 1024 * 1024;

    public static
    byte[] my=new byte[100*_1MB]; //100M


    public static void main(String[] args) throws InterruptedException {


        System.out.println(my.length);

        Thread.currentThread().join();

    }



}
