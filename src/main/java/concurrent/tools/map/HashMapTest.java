package concurrent.tools.map;

import java.util.HashMap;

public class HashMapTest {

   static public class MyKey {
        String key;

        public MyKey(String key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            if(key.endsWith("1")){
                return 1;
            }
            return super.hashCode();
        }
    }


    public static void main(String[] args) {


        HashMap<MyKey,String> map=new HashMap<>(4);

        MyKey m1=new MyKey("71");
        MyKey m2=new MyKey("51");
        MyKey m3=new MyKey("31");
        MyKey m4=new MyKey("9");
        map.put(m1,"m1");
        map.put(m2,"m2");
        map.put(m3,"m3");
        map.put(m4,"m4");

        System.out.println(map.toString());


    }
}
