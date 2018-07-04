package design_pattern.singleton;

/**
 * Created by qindongliang on 2018/7/4.
 *
 * 基于延迟加载的使用双检锁的单例模式
 *
 */
public class DoubleCheckSingleton {


    private volatile static DoubleCheckSingleton instance;

    //私有的构造方法
    private DoubleCheckSingleton() {
    }

    /***
     * 在多线程的环境下，获取对象单实例
     * @return
     */
    public static DoubleCheckSingleton getInstance(){

        if(instance==null){ //第一层检查

            synchronized (DoubleCheckSingleton.class){

                if(instance==null){ //第二层检查

                    instance=new DoubleCheckSingleton();

                }

            }

        }

        return instance;

    }



}
