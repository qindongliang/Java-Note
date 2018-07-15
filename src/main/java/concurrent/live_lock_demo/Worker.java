package concurrent.live_lock_demo;

/**
 * Created by qindongliang on 2018/7/15.
 */
public class Worker {

    private String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }


    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }


   public synchronized void work(CommonResource commonResource,Worker otherWorker)throws  Exception{

       while (active){

           if(commonResource.getOwner()!=this){
               wait(10);

               continue;
           }



           if(otherWorker.isActive()){


               System.out.println(getName()+" 让其他同学先执行："+otherWorker.getName());

               commonResource.setOwner(otherWorker);

               Thread.sleep(1000);
               continue;
           }


           System.out.println(getName()+"开始使用资源");

           active=false;

           commonResource.setOwner(otherWorker);


       }



    }




}
