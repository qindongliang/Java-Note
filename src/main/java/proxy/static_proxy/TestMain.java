package proxy.static_proxy;

/***
 * 静态代理展示
 */
public class TestMain {


    public static void main(String[] args) {

        //真实角色
        Animal dog=new Dog();
        //代理角色
        ProxyRole proxyRole=new ProxyRole(dog);
        //代替执行
        proxyRole.run();

        System.out.println("=======================================");
        //真实角色
        Animal cat=new Cat();
        //代理角色
        proxyRole=new ProxyRole(cat);
        //代替执行
        proxyRole.run();


    }

}
