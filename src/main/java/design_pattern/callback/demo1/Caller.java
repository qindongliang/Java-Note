package design_pattern.callback.demo1;



public class Caller {


    private void registed(CallBack callBack){
        callBack.methodToCallBack();
    }


    public void work(String task,CallBack callBack){

        System.out.println("任务执行完了");

        callBack.methodToCallBack();

    }


    public static void main(String[] args) {

        Caller caller=new Caller();

        CallBack callback=new CallBackImpl();// instance callback

        caller.work("execute task",callback);



    }


}
