package gc;

public class Demo {

    private Object instance;

    public static void main(String[] args) {
        //引用计数器的垃圾回收思想，对于本身之间相互引用如下，可能没法回收，但其实他们已经无用了
        Demo a=new Demo();
        Demo b=new Demo();
        a.instance=b;
        b.instance=a;
        a=null;
        b=null;
    }

}
