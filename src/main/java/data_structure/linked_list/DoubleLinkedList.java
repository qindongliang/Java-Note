package data_structure.linked_list;

/***
 * Java实现的双向链表：
 * 包含头部插入，尾部插入
 * 递归遍历，迭代遍历
 */
public class DoubleLinkedList {

    private Node head;
    private Node tail;
    private int  size;


    class Node{
        public int val;
        public Node prev;
        public Node next;

        public Node(){

        }

        public Node(int val){
            this.val=val;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public boolean isEmpty(){
        return head==null;
    }


    public void addLast(int val){
        Node newNode=new Node();
        newNode.val=val;
        newNode.next=null;
        newNode.prev=tail;

        if(tail!=null){
            tail.next=newNode;
        }

        tail=newNode;

        if(head==null){
            head=tail;
        }

        size=size+1;


    }



    public void addFirst(int val){

        Node newNode=new Node();
        newNode.val=val;
        newNode.next=head;
        newNode.prev=null;

        if(head!=null){
            head.prev=newNode;
        }

        head=newNode;

        if(tail==null){
            tail=newNode;
        }

        size++;

    }

    /***
     * 递归方式的打印遍历
     * @param node
     */
    public void recursionShow(Node node){
        if(node==null){ return; }
        System.out.print(" "+node.val);
        recursionShow(node.next);
    }

    private void showAll(){
          recursionShow(this.head);
    }


    public void iteratorAll(){
        Node tmp=null;
        for(tmp=head;tmp!=null;){
            System.out.print(tmp.val+" ");
            tmp=tmp.next;
        }
    }

    /***
     * 从后向前遍历
     */
    public void reverseIteratorAll(){
        Node tmp=null;
        for(tmp=tail;tmp!=null;){
            System.out.print(tmp.val+" ");
            tmp=tmp.prev;
        }
    }

    public static void main(String[] args) {

        DoubleLinkedList list=new DoubleLinkedList();

        list.addLast(5);
        list.addLast(1);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);//尾部插入


//        list.addFirst(-5);//头部插入
//        list.addFirst(-2);

//        list.showAll();
        list.iteratorAll();
//        list.reverseIteratorAll();



    }




}
