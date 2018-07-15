package concurrent.live_lock_demo;

/**
 * Created by qindongliang on 2018/7/15.
 */
public class CommonResource {

    private Worker owner;

    public CommonResource(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }


    public  synchronized void setOwner(Worker worker){

        owner=worker;


    }
}
