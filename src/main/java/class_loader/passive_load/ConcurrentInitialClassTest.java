package class_loader.passive_load;

public class ConcurrentInitialClassTest {


    public static void main(String[] args) {



        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 开始启动.....  ");
                new ConstantExample();//静态类会初始化

            }
        };


        Thread t1=new Thread(runnable);
        Thread t2=new Thread(runnable);

        t1.start();
        t2.start();




    }


}
