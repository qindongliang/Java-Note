package basic.reference;

public class StackCallDemo {


    static class Cat{
        public String name;
    }

    public void m1(){
        int x=20;
        m2(x);// call m2 method
    }


    public void m2(int x){
        boolean c;
        m3();//call m3 method
    }


    public void m3(){
        Cat cat=new Cat();
        //more code
    }


    public static void main(String[] args) {


        StackCallDemo stackDemo=new StackCallDemo();
        stackDemo.m1();

    }





}
