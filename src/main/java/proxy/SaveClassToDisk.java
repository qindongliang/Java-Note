package proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/***
 * 将class文件保存到磁盘上
 */
public class SaveClassToDisk {


    private static void save(String className, Class<?> cl, String path){
            //用于生产代理对象的字节码
            byte[] classFile = ProxyGenerator.generateProxyClass(className, cl.getInterfaces());
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
