package sort_algorithm.count_sort;

import java.util.Arrays;

/***
 * 证明，计数排序的稳定性
 */

public class ProveStableCountingSort {



    public static void main(String[] args) {

        //稳定的计数排序实现


        Student s1=new Student(2,"张三");
        Student s2=new Student(1,"张三1");
        Student s3=new Student(0,"张三2");
        Student s4=new Student(1,"张三3");

        Student students[]={s1,s2,s3,s4};

        System.out.println("排序前： "+Arrays.toString(students));

        int max = students[0].getGrade(), min = students[0].getGrade();
        for(Student st : students){
            max=Math.max(max,st.getGrade());
            min=Math.min(min,st.getGrade());
        }
       // System.out.println("max: "+max+" min: "+min);

        int countLen=max-min+1;

        int countArray[]=new int[countLen];

        //计数
        for(Student st:students){
            countArray[st.getGrade()-min]++;
        }
        //System.out.println("countArray："+Arrays.toString(countArray));

        //为了保持稳定性，需要对次数求和，从而可以做到对重复的元素，进行从右到左放置
        for (int i = 1; i <countArray.length ; i++) {
            countArray[i]=countArray[i]+countArray[i-1];
        }
        //System.out.println("sumCountArray："+Arrays.toString(countArray));

        //用来存储排序后的结果
        Student[] sortedResult=new Student[students.length];

        //这里必须从后向前遍历，只有这样出现重复的元素，才会保持顺序的把最后面的重复元素，永远放在最右边。
        //从而保证排序的稳定性
        //如果从前向后排序，重复元素的顺序，刚好相反，所以就不是稳定的算法
        for(int i=students.length-1;i>=0;i--){
            //得到sumCount
            int sumCount= countArray[students[i].getGrade()-min];
            //得到实际排序后的位置
            int sortedPos=sumCount-1;
            //向最终结果里面存放元素
            sortedResult[sortedPos]=students[i];
            //针对重复的元素，先放后面，然后减1，下次循环就会放在前面
            countArray[students[i].getGrade()-min]--;

        }

        System.out.println("排序后： "+Arrays.toString(sortedResult));




    }


}
