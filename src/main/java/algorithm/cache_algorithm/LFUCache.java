package algorithm.cache_algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/****
 * 实现一个 LFU 缓存
 * Least Frequently Used，最不经常使用策略
 */
public class LFUCache {

    private   int capacity;//缓存队列的容量值

    private Map<Integer,AccessRate> cache;//保存缓存数据

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache=new HashMap<>();
    }

    public void put(int key,int value){
        AccessRate v=cache.get(key);
        if(v==null){//第一次插入

            if(cache.size()==capacity){//容量已超
                cache.remove(getEvictKey());//驱逐被淘汰的数据
            }
            //新增
            v=new AccessRate(key,value,1,System.nanoTime());
            cache.put(key,v);
            log("add",v);
        }else{
            //更新状态
            v.value=value;
            v.hitCount=v.hitCount+1;
            v.lastTime=System.nanoTime();
            cache.put(key,v);
            log("update",v);
        }


    }



    public int get(int key){
        AccessRate v=cache.get(key);
        if(v!=null){
            v.hitCount=v.hitCount+1;
            v.lastTime=System.nanoTime();
            log("query",v);
            return v.value;
        }
        log("query",new AccessRate(key));
        return -1;
    }

    public void remove(int key){
        AccessRate v=cache.remove(key);
        if(v!=null){
            log("remove",v);
        }else{
            log("remove",new AccessRate(key));
        }

    }


    //记录操作明细，方便理解
    public void log(String operator,AccessRate accessRate){
        if(accessRate.isNotNull()){
            System.out.println(operator+" => "+accessRate.toString()+" "+deatail());
        }else {
            System.out.println(operator+" => the key "+accessRate.key+" not exist"+" "+deatail());
        }


    }

    public String deatail(){
        StringBuilder sb=new StringBuilder();
        sb.append("当前缓存中有效的key=");
        for (AccessRate accessRate:cache.values()){
            sb.append(accessRate.key+"，");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    //获取缓存里面，需要被淘汰的数据，复杂度O（N），可用优先级队列（堆）进行优化
    public Integer getEvictKey(){
        AccessRate min= Collections.min(cache.values());
        log("evict",min);
        return min.key;
    }




    class AccessRate implements Comparable<AccessRate> {

        private   Integer key;//访问的数据key
        private   Integer value;//访问数据的value
        private   Integer hitCount;//记录访问次数
        private   Long lastTime;//最新的访问时间



        public AccessRate(Integer key, Integer value, Integer hitCount, Long lastTime) {
            this.key = key;
            this.value = value;
            this.hitCount = hitCount;
            this.lastTime = lastTime;
        }

        public AccessRate() {
        }

        public AccessRate(Integer key) {
            this.key=key;
        }

        public boolean isNotNull(){
            return key!=null&&value!=null;
        }

        @Override
        public int compareTo(AccessRate o) {
            int firstSort=hitCount.compareTo(o.hitCount);
            if(firstSort!=0){////如果命中次数不相等，使用命中次数排序
                return firstSort;
            }else {//如果命中次数相等，就使用访问的时间进行排序
                return lastTime.compareTo(o.lastTime);
            }
        }

        @Override
        public String toString() {
            return "AccessRate{" +
                    "key=" + key +
                    ", value=" + value +
                    ", hitCount=" + hitCount +
                    ", lastTime=" + lastTime +
                    '}';
        }
    }


    public static void main(String[] args) {

        LFUCache cache=new LFUCache(3);

        cache.put(1,1);// 添加 1
        cache.put(2,2);// 添加 2
        cache.get(1);// 访问 1
        cache.get(2);// 访问 2
        cache.put(3,3);// 添加 3
        cache.put(4,4);// 缓存满，先淘汰访问次数少的3，然后再添加 4
        cache.get(5);// 访问 5
        cache.remove(4); // 移除 4
        cache.remove(4);// 移除 4



    }





}
