package design_pattern.callback.demo2;

import java.util.concurrent.TimeUnit;

public class Student  {


    public void doWrok(CallBack callBack) throws InterruptedException {
        System.out.println("学生开始做作业.....");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("学生完成作业了，通知老师查看");
        callBack.checkWork(); //通知老师查看作业
    }


    public void asynDoWrok(CallBack callBack) throws InterruptedException {
     //通过一个线程来异步的执行任务
     Runnable runnable= new Runnable(){
            @Override
            public void run() {
                System.out.println("学生开始做作业.....");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("学生完成作业了，通知老师查看");
                callBack.checkWork();
            }
        };

     Thread thread=new Thread(runnable);
     thread.start();

    }


}
