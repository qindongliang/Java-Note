package class_loader.passive_load;

public class LoadTest {
    public static void main(String[] args) {

//        System.out.println(SubClass.value); //仅仅触发父类初始化，不会触发子类的初始化

        SubClass arrs[]=new SubClass[5]; //声明数组，不会触发该类

        SuperClass arrs2[]=new SuperClass[4];//声明数组，不会触发该类


    }
}
