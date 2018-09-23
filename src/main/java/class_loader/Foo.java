package class_loader;

/**
 * Created by qindongliang on 2018/9/23.
 */
public class Foo {



    private int bar = getIntValue();

    public int getIntValue(){
        System.out.println("父类成员变量初始化");
        return 4;
    }

    private static int baz = 4;

    static {
        baz = 2;
        System.out.println("父类静态块");
    }

    public Foo() {
        bar = 5;
        System.out.println("父类构造函数 ");
    }

    {

        bar = 1;
        System.out.println("父类构造块 ");
    }



    public static void main(String[] args) {

//        Foo foo = new Foo();
//        System.out.println(foo.bar);
//        System.out.println(Foo.baz);

        Too  too=new Too();


    }
}

class Too extends Foo{

    private int count=getCount();

    private int getCount(){
        System.out.println("子类成员变量初始化");
        return 4;
    }



    static {
        System.out.println("子类静态块");
    }
    {
        System.out.println("子类构造块");
    }
    public Too() {

        System.out.println("子类构造函数");
    }
}
