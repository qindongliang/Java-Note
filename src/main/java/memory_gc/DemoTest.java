package memory_gc;

/***
 *
 * 展示堆栈数据的分布
 *
 */
public class DemoTest {

    int y;// 分布在堆上

    public static void main(String[] args) {

        int x=1; //分配在栈上
        String name=new String("cat");//数据在堆上，name变量的指针在栈上
    }


}
