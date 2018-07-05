package design_pattern.singleton;

/**
 * Created by qindongliang on 2018/7/5.
 */
public class SimpleSingleton {
    private static SimpleSingleton ourInstance = new SimpleSingleton();

    public static SimpleSingleton getInstance() {
        return ourInstance;
    }

    private SimpleSingleton() {
    }
}
