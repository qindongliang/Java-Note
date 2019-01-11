package concurrent.reorder;

/***
 *
 * 单线程下重排序，如果破坏了as-if-serial语义，
 * 比如下面的代码，虽然a和b没有直接依赖，但是如果b先执行的时候
 * 发生了异常，那么a的值是1还是3？
 * 实际上是3，发生异常的时候JVM对异常处理机制的重排序做了一种特殊的处理
 *
 */
public class ReorderDemo2 {


    public static void main(String[] args) {


        int a = 1;
        int b = 2;

        try {
            a = 3;           //A
            b = 1 / 0;       //B
        } catch (Exception e) {

        } finally {
            System.out.println("a = " + a);
        }

    }

}
