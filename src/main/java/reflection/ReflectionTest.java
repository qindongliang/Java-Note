package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    //非反射方式，获取类的内部信息
    public void test1(){

        Person person=new Person();

        Field[] fields = person.getClass().getDeclaredFields();
        //Field[] fields = person.getClass().getFields();// 仅仅是public修饰符的

        for(Field f:fields){
            System.out.println(f);
        }


    }


    public static void main(String[] args)throws Throwable {


       Class c=  Class.forName("reflection.Person");

       Person p1= (Person) c.newInstance();//默认的无参数构造函数
        //访问带参数的方法
       Method m= c.getDeclaredMethod("speak",new Class[]{String.class,String.class,int.class});
       m.invoke(p1,"洛阳","不错",7);

       //调用有参构造函数
       System.out.println("========================================");
       Constructor c2=c.getConstructor(new Class[]{String.class,int.class});
       Person p2= (Person)c2.newInstance("你好",45);


       Person p3=new Person();
       Person p4=new Person();

        System.out.println(p3.getClass()==p4.getClass());







    }
}
