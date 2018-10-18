package proxy.jdk_dynamic_proxy;


import java.io.FileOutputStream;
import java.io.IOException;

/***
 * 将class文件保存到磁盘上
 */
public class SaveClassToDisk {


    public static void save(String className, Class<?> cl, String path){
            //用于生产代理对象的字节码，在编译时候报错，所以放弃使用
//            byte[] classFile = ProxyGenerator.generateProxyClass(className, cl.getInterfaces());
            byte[] classFile = null;
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(path);
                //将代理对象的class字节码写到硬盘上
                out.write(classFile);
                out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



}
