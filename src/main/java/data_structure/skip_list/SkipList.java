package data_structure.skip_list;

import java.util.Random;

/***
 * https://github.com/dineshappavoo/SkipList/blob/master/src/skiplist/SkipList.java
 * https://github.com/kjiwa/java-skip-list/blob/master/SkipList.java
 * @param <K>
 * @param <V>
 */
public class SkipList<K extends Comparable<K>, V> {


    private Node head;

    private Random random;

    private long size;

    private double p;

    public SkipList(){
        head=new Node(null,null,0,null,null);
        random=new Random();
        size=0;
        p=0.5;
    }


    private long level(){

        long level=0;
        while (level<=size&&random.nextDouble()<p){
            level++;
        }
        return level;

    }


    public void add(K key,V value){

        long level=level();
        if(level>head.level){
            head=new Node(null,null,level,null,head);
        }

        Node current=head;
        Node last=null;

        while (current!=null){
            if(current.next==null||current.next.key.compareTo(key)>0){
                if(level>=current.level){
                    Node newNode=new Node(key,value,current.level,current.next,null);
                    if(last!=null){
                        last.down=newNode;
                    }

                    current.next=newNode;
                    last=newNode;
                }
                current=current.down;
                continue;

            }else if(current.next.key.equals(key)){
                current.next.value=value;
                return;
            }

            current=current.next;

        }

        size++;
    }


    public V serach(K key){

        Node current=head;
        while (current!=null){
            if(current.next==null||current.next.key.compareTo(key)>0){
                current=current.down;
                continue;
            }else if(current.next.key.equals(key)){
                return current.next.value;
            }
            current=current.next;
        }

        return null;

    }

    public V remove(K key){
        V value=null;
        Node current=head;
        while (current!=null){
            if(current.next==null||current.next.key.compareTo(key)>=0){
                if(current.next!=null&&current.next.key.equals(key)){
                    value=current.next.value;
                    current.next=current.next.next;
                    size--;
                }
                current=current.down;
                continue;
            }
            current=current.next;
        }
        return value;
    }



    public boolean containsKey(K key){
        return serach(key)!=null;
    }

    public long size(){
        Node current=head;
        long count=0;
        if(current!=null){
            while (current.down!=null){
                current=current.down;
            }

            while (current.next!=null){
                count++;
                current=current.next;
            }

        }

        return count;
    }



    public V findMin(){
        Node current=head;
        if(current==null){
            return null;
        }

        while (current.down!=null){
            current=current.down;
        }
        return current.next.value;
    }


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








    public static void main(String[] args) {


        SkipList<Integer,String> skipList=new SkipList<>();

        skipList.add(3,"");
        skipList.add(1,"");

        System.out.println();



    }


    class Node{

        public K key;

        public V value;

        public long level;

        public Node next;

        public Node down;

        public Node(K key, V value, long level, Node next, Node down) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.next = next;
            this.down = down;
        }
    }





}
