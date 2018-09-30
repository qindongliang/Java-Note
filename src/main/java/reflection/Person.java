package reflection;

public class Person {

    private String name;

    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

        System.out.println("name： "+name+"   age: "+age);
    }

    public String address="北京";

    String id;


    public void speak(String place,String status,int day){

        System.out.println(place+"   "+status+"    "+day);

    }


}
