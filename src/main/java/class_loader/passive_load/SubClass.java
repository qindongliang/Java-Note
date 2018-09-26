package class_loader.passive_load;

public class SubClass extends SuperClass {

    static {

        System.out.println("子类初始化了........");

    }

}
