package reflection.base;

public class BaseImpl extends BaseClass implements BaseInterface {


    public int publicInt;
    public String str;
    protected boolean protectedBoolean;
    Object defaultObject;
    private String privateString = "private string";

    public BaseImpl() {
    }

    public BaseImpl(int publicInt) {
        this.publicInt = publicInt;
    }

    private BaseImpl(String str) {
        this.str = str;
    }


    @Override
    public void method1() {
        System.out.println("  BaseImpl method1  ");
    }

    @Override
    public int method2(String str) {

        System.out.println("  BaseImpl method2  ");
        return 0;
    }


    @Override
    public int method4() {
        System.out.println(" Method4 override ");

        return 0;
    }

    @Override
    void method6() {
        System.out.println(" Method4 override ");
    }

    private void method9() {
        System.out.println(" Method9 override ");
    }


    enum E {}

    public interface G {
    }

    public class A {
    }

    private class B {
    }

    protected class C {
    }

    class D {
    }

    public class F {
    }


}
