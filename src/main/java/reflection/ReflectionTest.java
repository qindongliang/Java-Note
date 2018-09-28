package reflection;

import java.lang.reflect.Field;

public class ReflectionTest {

    public static void main(String[] args) {

        Person person=new Person();

        Field[] fields = person.getClass().getDeclaredFields();
        //Field[] fields = person.getClass().getFields();// 仅仅是public修饰符的


        for(Field f:fields){
            System.out.println(f);
        }



    }
}
