package sort_algorithm.count_sort;

public class Student {

    private int grade;
    private String name;

    public Student() {
    }

    public Student(int grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "grade=" + grade +
                ", name='" + name + '\'' +
                '}';
    }
}
