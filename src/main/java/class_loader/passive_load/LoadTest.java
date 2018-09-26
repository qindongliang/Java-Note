package class_loader.passive_load;

public class LoadTest {
    public static void main(String[] args) {

          //例子一 仅仅触发父类初始化，不会触发子类的初始化
//        System.out.println(SubClass.value);


        // 例子二 声明数组也不会触发类的初始化
        //SubClass arrs[]=new SubClass[5];


        // 例子三 对于常量访问也不会触发
        System.out.println(ConstantExample.age);




    }
}
