package proxy.cglib_dynamic_proxy;

import java.io.Serializable;

// 必须实现序列化，否则无法将字节码保存到磁盘上
public class Hello implements Serializable {

    public String sayHello(String str){
        System.out.println("hello");
        return  "hello world!"+str;
    }

}
