package proxy.static_proxy;

public class ProxyRole implements Animal {

    private Animal proxy;

    public ProxyRole(Animal proxy) {
        this.proxy = proxy;
    }

    @Override
    public String run() {

        System.out.println(" before execute......  ");
        String result=proxy.run();
        System.out.println(result);
        System.out.println(" after execute......  ");

        return result;
    }
}
