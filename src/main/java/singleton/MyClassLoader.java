package singleton;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class MyClassLoader extends ClassLoader {

    private String classFilePath;

    public MyClassLoader(String path) {
//        super(null);
        this.classFilePath=path;
    }




    @Override
    protected Class<?> findClass(String name) {
         byte[] bytes=getClassBytes();
         String className="singleton."+getClassName(classFilePath);
        return defineClass(className,bytes,0,bytes.length);
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


    private byte[] getClassBytes()  {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            // 这里要读入.class的字节，因此要使用字节流
            FileInputStream fis = new FileInputStream(new File(classFilePath));
            FileChannel fc = fis.getChannel();

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
        }catch (Exception e){
            e.printStackTrace();
        }

        return baos.toByteArray();
    }
}
