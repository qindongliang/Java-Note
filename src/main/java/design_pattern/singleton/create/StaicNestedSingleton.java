package design_pattern.singleton.create;

/**
 * Created by qindongliang on 2018/7/5.
 */
public class StaicNestedSingleton {

    private StaicNestedSingleton() {
    }

    public static StaicNestedSingleton get() {
        return Holder.instance;
    }

    private static class Holder {
        public static final StaicNestedSingleton instance = new StaicNestedSingleton();
    }



}


