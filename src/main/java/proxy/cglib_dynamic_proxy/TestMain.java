package proxy.cglib_dynamic_proxy;

import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.proxy.Enhancer;

import java.io.FileOutputStream;

public class TestMain {

    public static void main(String[] args) {


        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new MyInterceptor());
        //保存生成的字节码文件到磁盘上
        enhancer.setStrategy(new DefaultGeneratorStrategy(){
            @Override
            protected byte[] transform(byte[] b) throws Exception {
                FileOutputStream   out = new FileOutputStream("./hello.class");
                //将代理对象的class字节码写到硬盘上
                out.write(b);
                out.flush();
                out.close();

                return super.transform(b);
            }
        });
        Hello hello= (Hello) enhancer.create();

        hello.sayHello("你好");


    }

}
