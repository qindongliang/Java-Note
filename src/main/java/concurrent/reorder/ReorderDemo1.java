package concurrent.reorder;

/***
 * jdk5开始，通过jsr133请求中增强了volatile关键字的语义
 * http://www.cs.umd.edu/~pugh/java/memoryModel/jsr-133-faq.html#volatile
 * 关于volatile禁止重排序的例子
 */
public class ReorderDemo1 {


    private int count=2;
    private boolean flag=false;
    private volatile boolean sync=false;

    public void write1()  {
        count=10;
        flag=true;//没有volatile修饰，实际执行顺序，有可能是flag=true先执行
    }

    public void read1()  {
        if(flag){
            System.out.print(count); // 有些jvm会打印10，有些jvm会打印2，这是不确定的
        }
    }


    public void write2() {
        count=10;
        sync=true;// 由于出现了volatile，所以这里禁止重排序
    }

    public void read2()  {
        if(sync){
            System.out.print(count); // 在jdk5之后，由volatile保证，count的值总是等于10
        }

    }




    public static void main(String[] args) {

        for(int i=0;i<300;i++){
            //实例化变量
            ReorderDemo1 reorderDemo1=new ReorderDemo1();
            //写线程
            Thread t1=new Thread(()-> { reorderDemo1.write1();});
            //读线程
            Thread t2=new Thread(()-> { reorderDemo1.read1(); });

             t1.start();
             t2.start();

        }




    }




}
