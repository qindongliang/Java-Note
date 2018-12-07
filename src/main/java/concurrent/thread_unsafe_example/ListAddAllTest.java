package concurrent.thread_unsafe_example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/***
 *测试ArrayList在多线程环境下扩容异常问题
 * cpu核数越多，几率越大
 */
public class ListAddAllTest {



    static class PutThread extends Thread{

        static List<String> list=new ArrayList<>();

        CountDownLatch latch;

        public PutThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {

            String data[]=new String[]{"1","2","3","4","5","6","7","8","9","10","11"};
            latch.await();//必须等到所有的线程到达之后，才能向下执行
            list.addAll(Arrays.asList(data));
            Thread.sleep(2000);//等待一会再结束，避免结束的块，共享数据会刷新到主内存里面
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        //使用 CountDownLatch 作共享锁
        CountDownLatch latch=new CountDownLatch(1);
        for (int i = 0; i < 40; i++) {
            PutThread pt=new PutThread(latch);
            pt.start();
        }
        //释放栅栏
        latch.countDown();






    }

}
