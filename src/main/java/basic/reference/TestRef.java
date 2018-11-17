package basic.reference;

public class TestRef {

   static class Dog{
       public String name;

       public Dog() {
       }

       public Dog(String name) {
            this.name = name;
        }
    }


    public static void change(Dog dog){
       dog.name="new_tom";
       dog=new Dog("CAT");
       dog.name="cat";
    }


    public static void swapDog(){
        Dog dog=new Dog("tom");
        System.out.println(dog.name);
        change(dog);
        System.out.println("==================after==================");
        System.out.println(dog.name);
    }


    public static void change(String point){
       point="new value";
    }

    public static void swapString(){
        String orgin="orgin";
        System.out.println(orgin);
        change(orgin);
        System.out.println("==================after==================");
        System.out.println(orgin);


    }

    public static void change(int value){
       value=-1;
    }

    public static void swapInt(){
       int orgin=100;
        System.out.println(orgin);
        change(orgin);
        System.out.println("==================after==================");
        System.out.println(orgin);
    }



    public static void main(String[] args) {

        swapDog();

//        swapString();

//        swapInt();





    }
}
