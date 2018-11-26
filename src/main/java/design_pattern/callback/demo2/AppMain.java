package design_pattern.callback.demo2;

public class AppMain {

    public static void main(String[] args) throws InterruptedException {

        Student student=new Student();//学生角色

        System.out.println("\n===============同步模式================");
        Teacher teacher=new Teacher(student);//老师角色
        //同步回调模式，老师给学生布置作业，老师等学生完成之后才能回家
        teacher.assignWork(true);

        System.out.println("\n===============异步模式================");
        //异步回调模式，老师给学生布置作业，布置完成之后就可以回家，学生完成之后会通知老师查看。
        teacher.assignWork(false);



    }

}
