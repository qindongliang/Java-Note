package class_loader.passive_load;

public class ConstantExample {


    public static final int age=18;

    static {

       if(true){
           System.out.println(Thread.currentThread().getName()+" 开始初始化类");
           while (true){

           }

       }

    }


}
