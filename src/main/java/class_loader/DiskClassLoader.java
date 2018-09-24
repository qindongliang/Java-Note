package class_loader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by qindongliang on 2018/9/22.
 */
public class DiskClassLoader extends ClassLoader {
    private String path;

    public DiskClassLoader(String path) {
        this.path = path;
    }

    static {

        System.out.println("触发静态初始化.....");
    }

    public static void main(String[] args) throws Exception, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        String path="src/main/resources/class/Demo.class";
        DiskClassLoader diskClassLoader=new DiskClassLoader(path);
        diskClassLoader.test1();// 以loadClass方式获取实例
        System.out.println("=============================");
        diskClassLoader.test2();// 以反射方式获取实例

    }


    public  void test1() throws  Exception{
        Class c= this.loadClass(path);
        Object obj=c.newInstance();
        Method method=c.getDeclaredMethod("say",null);
        method.invoke(obj,null);
    }


    public  void test2() throws Exception {
        Class<?> c = Class.forName("Demo",false,this);
        Object obj = c.newInstance();
        Method method=c.getDeclaredMethod("say",null);
        method.invoke(obj,null);

    }





    private byte[] getClassBytes() throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(new File(path));
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }



    public  String getClassName(String path){
        //如果是一个路径，就截取类名字
        if(path.indexOf('.')!=-1){
            int start=path.lastIndexOf('/');
            int end=path.lastIndexOf('.');
            String className=path.substring(start+1,end);
            return className;
        }else{//否则就直接返回
            return path;
        }
    }


    @Override
    protected Class<?> findClass(String path) throws ClassNotFoundException {

        String className=getClassName(path);
        try {
            byte [] data= getClassBytes();
            return defineClass(className,data,0,data.length);
        }catch (Exception e){
        e.printStackTrace();
        }

        return super.findClass(className);
    }





}
