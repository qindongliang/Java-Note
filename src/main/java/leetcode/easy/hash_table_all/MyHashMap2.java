package leetcode.easy.hash_table_all;

public class MyHashMap2 {

    private static final  double LOAD_FACTOR=0.75;

    private Node[] nodes;

    private int size;

    public MyHashMap2(){
        nodes=new Node[5];
        size=0;
    }


    public void put(int key,int value){

        int idx=hash(key);
         for (Node x=nodes[idx];x!=null;x=x.next){
             //更新操作
             if(x.key==key){
                 x.value=value;
                 return;
             }

         }
         //头插法，介入链表的头部
         nodes[idx]=new Node(key,value,nodes[idx]);

        size++;

        double loadFactor=(double)size/nodes.length;

        if(loadFactor>LOAD_FACTOR){
            rehash();
        }
    }

    public int get(int key){
        int idx=hash(key);
        for (Node x=nodes[idx];x!=null;x=x.next){
            if(x.key==key){
                return x.value;
            }
        }
        return -1;
    }


    public void remove(int key){
        int idx=hash(key);
        Node pre=new Node(-1,-1,nodes[idx]);
        for (Node prev=pre;prev.next!=null;prev=prev.next){
            if(prev.next.key==key){
                prev.next=prev.next.next;
                break;
            }
        }
        nodes[idx]=pre.next;
        size--;
    }



    private int hash(int key){
        return key%nodes.length;
    }


    private void rehash(){

        Node []tmp=nodes;

        nodes =new Node[tmp.length*2];

        size=0;

        for (Node head:tmp){

            for (Node x=head;x!=null;x=x.next){
                put(x.key,x.value);
            }

        }


    }





    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


}
