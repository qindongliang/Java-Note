package reflection.base;

public class BaseClass {

    public int baseInt;

    private static void method3() {
        System.out.println("Method3");
    }

    public static int method5() {
        System.out.println("Method5");
        return 0;
    }

    public int method4() {
        System.out.println("Method4");
        return 0;
    }

    public int method7() {
        System.out.println("Method7");
        return 0;
    }

    void method6() {
        System.out.println("Method6");
    }


    //member public enum
    public enum BaseClassMemberEnum {
    }

    // inner public class
    public class BaseClassInnerClass {
    }


}
