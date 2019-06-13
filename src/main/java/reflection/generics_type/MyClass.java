package reflection.generics_type;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MyClass {

    public List<String> stringList = new ArrayList<>();



    public List<String> getStringList(){
        return this.stringList;
    }


    public void setList(List<Integer> list){

    }

    /****
     * 通过反射获取方法返回值的泛型类型
     * @throws Exception
     */
    public static void  getMethodReturnType() throws Exception{

        Method method=MyClass.class.getMethod("getStringList",null);
        System.out.println(method.getReturnType());
        Type retrunType=method.getGenericReturnType();
        System.out.println(retrunType);
        if(retrunType instanceof ParameterizedType){
            ParameterizedType type=(ParameterizedType)retrunType;
            Type[] typeArguments=type.getActualTypeArguments();
            for(Type typeArgument:typeArguments){
                Class typeArgClass=(Class)typeArgument;

                System.out.println("泛型类型："+typeArgClass);
            }
        }

    }

    public static void getMethodParameterTypes() throws Exception{
        Method method=MyClass.class.getMethod("setList",List.class);
        Type[] genericParameterTypes=method.getGenericParameterTypes();
        for (Type genericType:genericParameterTypes){
            if(genericType instanceof ParameterizedType){
                ParameterizedType parameterizedType=(ParameterizedType)genericType;
               Type[] types= parameterizedType.getActualTypeArguments();
               for (Type type:types){
                   Class realType=(Class) type;
                   System.out.println("方法参数的类型："+realType);
               }
            }
        }

    }


    public static void getGenericFieldTypes()throws Exception{

        Field field=MyClass.class.getField("stringList");
        Type genericsFieldType=field.getGenericType();
        if(genericsFieldType instanceof ParameterizedType){
            ParameterizedType parameterizedType=(ParameterizedType) genericsFieldType;
            Type[] fieldArgTypes=parameterizedType.getActualTypeArguments();
            for (Type fieldArgType:fieldArgTypes){
                Class fieldArgClass=(Class) fieldArgType;
                System.out.println("泛型字段的类型："+fieldArgClass);
            }
        }

    }








    public static void main(String[] args) throws Exception {
        getMethodReturnType();//获取方法返回值的泛型
        getMethodParameterTypes();//获取方法的参数的泛型
        getGenericFieldTypes();//获取泛型字段的类型
    }
}
