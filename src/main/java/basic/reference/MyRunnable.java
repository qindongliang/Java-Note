package basic.reference;

public class MyRunnable implements Runnable {

    @Override
    public void run() {

    }


    public void one(){
        int local=45;
        MyShareObject copy=MyShareObject.shareInstance;


        two();
    }



    public void two(){

        Integer localVariable1 = new Integer(99);

    }


}
