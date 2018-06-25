package note.concurrent;

/**
 * 重排序问题
 */
public class ReorderingProblem {

    private  int a=1;
    private boolean flag=true;



    private void mthon1(){

        flag=false;
        a=2;

    }

    public void mthon2(){
        if(flag){
            System.out.println(a);
        }
    }


    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < 100; i++) {

            ReorderingProblem reorder=new ReorderingProblem();

            Thread t1=new Thread(()->{
                reorder.mthon1();
            });

            Thread t2=new Thread(()->{
                reorder.mthon2();
            });

            t1.start();
            t2.start();


            // 如何解决？

            // 使用同步方法

        }





    }



}
