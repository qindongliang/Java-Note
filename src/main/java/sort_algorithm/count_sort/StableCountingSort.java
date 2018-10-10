package sort_algorithm.count_sort;

import java.util.Arrays;

public class StableCountingSort {


    public static void main(String[] args) {

        //稳定的计数排序实现


        Student s1=new Student(2,"张三");
        Student s2=new Student(1,"张三1");
        Student s3=new Student(1,"张三2");
        Student s4=new Student(1,"张三3");

        Student students[]={s1,s2,s3,s4};

        System.out.println(" 排序前： "+Arrays.toString(students));

        int maxValue=2;

        int countArray[]=new int[maxValue+1];

        for (int i = 0; i < students.length; i++) {
            countArray[students[i].getGrade()]++;//词频计数
        }


        System.out.println(Arrays.toString(countArray));

        int sum=0;

        //计数累加
        for (int i = 1; i < countArray.length; i++) {
            countArray[i]=countArray[i]+countArray[i-1];
        }
        System.out.println(Arrays.toString(countArray));


        int finalArray[]=new int[students.length];

        System.out.println("最终输出");

        for (int i = students.length-1; i >=0 ; i--) {



        }





    }


}
