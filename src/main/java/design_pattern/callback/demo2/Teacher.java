package design_pattern.callback.demo2;

public class Teacher implements CallBack {

    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    /***
     *
     * @param isSync true=同步回调 false=异步回调
     * @throws InterruptedException
     */
    public void assignWork(boolean isSync) throws InterruptedException {
        System.out.println("老师分配作业完成....");
        if(isSync){
            student.doWrok(this);//同步通知做作业
        }else{
            student.asynDoWrok(this);//异步通知做作业
        }
        System.out.println("老师回家了....");
    }


    @Override
    public void finshed() {
        System.out.println("老师收到通知并查看了学生的作业!");
    }
}
