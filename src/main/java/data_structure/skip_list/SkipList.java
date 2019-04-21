package data_structure.skip_list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 * https://github.com/dineshappavoo/SkipList/blob/master/src/skiplist/SkipList.java
 * https://github.com/kjiwa/java-skip-list/blob/master/SkipList.java
 * @param <K>
 * @param <V>
 */
public class SkipList<K extends Comparable<K>, V> {


    //head节点不存储实际数据，表示层级
    private Node head;
    //构建随机数对象
    private Random random;
    //当前已经添加的数量
    private long size;
    //采用抛硬币的概率=0.5
    private double p;

    public SkipList(){
        head=new Node(null,null,0,null,null);
        random=new Random();
        size=0;
        p=0.5;
    }

    /****
     * 抛硬币策略决定新添加的数据，在第几层之下构建索引节点
     * 利用0-1之间的随机数是否小于0.5作为概率事件，如果大于
     * 0.5直接返回，否则就一直抛直到出现大于0.5概率事件，在
     * 不断抛的过程，使用level计数，level最大受限于当前的节点个数，
     * @return
     */
    private long level(){

        long level=0;
        double randomNumber=random.nextDouble();
        while (level<=size&&randomNumber<p){
            level++;
            randomNumber=random.nextDouble();
        }
        return level;

    }


    public void add(K key,V value){

        //抛硬币决定当然节点要构建的索引节点的层级
        long level=level();
        //如果新构建的level大于原head的层级，需要使用新的层级作为head，
        //旧的head，作为新的down节点
        if(level>head.level){
            head=new Node(null,null,level,null,head);
        }

        Node current=head;
        Node last=null;

        while (current!=null){
            //判断,下一个节点的key是否大于当前要插入的key
            if(current.next==null||current.next.key.compareTo(key)>0){
                //在大于的情况下判断新节点的层级是否大于当前对比的层级
                if(level>=current.level){
                    Node newNode=new Node(key,value,current.level,current.next,null);
                    if(last!=null){
                        last.down=newNode;
                    }
                    //追加当前节点
                    current.next=newNode;
                    last=newNode;
                }
                //下降一级更新
                current=current.down;
                continue;

            }else if(current.next.key.equals(key)){
                //如果是等于，就更新值，然后返回
                current.next.value=value;
                return;
            }
            //到这一步，说明新插入的值大于当前节点，那就继续向后遍历查询
            current=current.next;

        }
        //每新增一个节点，数量就加一
        size++;
    }


    public V serach(K key){

        Node current=head;
        while (current!=null){
            //如果next的值大于当前要查询的值，说明当前的值在左边，然后就下降，继续查找
            if(current.next==null||current.next.key.compareTo(key)>0){
                current=current.down;
                continue;
                //如果找到就返回
            }else if(current.next.key.equals(key)){
                return current.next.value;
            }
            //继续向后搜索
            current=current.next;
        }

        return null;

    }

    public V remove(K key){
        V value=null;
        Node current=head;
        while (current!=null){
            //判断是否在左边
            if(current.next==null||current.next.key.compareTo(key)>=0){
                //是的情况下，判断是否相等
                if(current.next!=null&&current.next.key.equals(key)){
                    //如果相等，就获取值
                    value=current.next.value;
                    //然后将引用覆盖掉
                    current.next=current.next.next;
                    size--;
                }
                //下沉继续处理
                current=current.down;
                continue;
            }
            //继续向右查询
            current=current.next;
        }
        return value;
    }



    public boolean containsKey(K key){
        return serach(key)!=null;
    }

    //统计当前跳跃表的节点个数，，可以使用size属性代替
    public long size(){
        Node current=head;
        long count=0;
        //head不为null
        if(current!=null){
            //一直下沉到最下面的一级
            while (current.down!=null){
                current=current.down;
            }
            //从左向右遍历统计
            while (current.next!=null){
                count++;
                current=current.next;
            }

        }

        return count;
    }


    //查询最小值
    public V findMin(){
        Node current=head;
        if(current==null){
            return null;
        }
        //下沉下去，最底层链表的第一个值
        while (current.down!=null){
            current=current.down;
        }
        return current.next.value;
    }


    //查询最大值
    public V findMax(){
        Node current=head;
        if(current==null){
            return null;
        }

        while (current.next.next!=null){
            current=current.next;
        }

        while (current.down!=null){
            current=current.down;
        }

        while (current.next.next!=null){
            current=current.next;
        }

        return current.next.value;

    }


    /***
     * 范围检索
     * @param start
     * @param end
     * @return
     */
    public List<V> findRange(K start,K end){

        List<V> list=new ArrayList<>();

        Node current=head;
        while (current!=null){
            //如果next的值大于当前要查询的值，说明当前的值在左边，然后就下降，继续查找
            if(current.next==null||current.next.key.compareTo(start)>0){
                current=current.down;
                continue;
                //如果找到就返回
            }else if(current.next.key.equals(start)){

                Node temp=current.next;
                //搜索范围
                while (temp!=null&&temp.key.compareTo(end)<=0){
                    list.add(temp.value);
                    temp=temp.next;
                }
                return list;
            }
            //继续向后搜索
            current=current.next;
        }
        return list;

    }







    public static void main(String[] args) {


        SkipList<Integer,String> skipList=new SkipList<>();

        skipList.add(3,"3");
        skipList.add(1,"1");
        skipList.add(11,"11");
        skipList.add(16,"16");
        skipList.add(4,"4");
        skipList.add(2,"2");
        skipList.add(8,"8");

        System.out.println();
//        skipList.remove(4);
//        System.out.println(skipList.serach(4));
//        System.out.println(skipList.size);;
//        System.out.println(skipList.findMin());
//        System.out.println(skipList.findMax());

        System.out.println(skipList.findRange(3,11));



    }


    class Node{

        public K key;//数据的key，通常情况下需要可比较排序

        public V value;//数据的value

        public long level;//记录当前节点的层级

        public Node next;//水平方向上的下一个节点的指针

        public Node down;//垂直方向上的下一个节点的指针

        public Node(K key, V value, long level, Node next, Node down) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.next = next;
            this.down = down;
        }
    }





}
