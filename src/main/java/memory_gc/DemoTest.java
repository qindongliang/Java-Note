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
        String address="北京";//数据在常量池，属于堆空间，指针在栈
        Integer price=4;//包装类型同样是引用类型，编译时会自动装拆相，所以数据在堆上，指针在栈
    }


}
