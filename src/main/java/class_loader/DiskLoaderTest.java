package class_loader;

/**
 * Created by qindongliang on 2018/9/24.
 */
public class DiskLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {


        String path="src/main/resources/class/Demo.class";
        DiskClassLoader diskClassLoader=new DiskClassLoader(path);

//       Class c=  diskClassLoader.loadClass(path);

        Class<?> c = Class.forName("Demo",false,diskClassLoader);

    }
}
