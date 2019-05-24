package leetcode.easy.linklist_all;

public class MyLinkList {

    public ListNode head;
    public ListNode tail;

    public void add(int val){
        ListNode tmp=new ListNode(val);
        if(head==null){
            head=tail=tmp;
        }else {
            tail.next=tmp;
            tail=tmp;

        }

    }

    public void addNode(ListNode node){
        ListNode tmp=node;
        if(head==null){
            head=tail=tmp;
        }else {
            tail.next=tmp;
            tail=tmp;

        }

    }


    public static void showAll(ListNode head){
        if(head==null){
            System.out.println("空的链表.....");
            return;
        }
        ListNode tmp=head;
        while (tmp!=null){
            System.out.print(tmp.val+" ");
            tmp=tmp.next;
        }
        System.out.println();
    }




    public static ListNode buildLinkList(){
        MyLinkList list=new MyLinkList();
        list.add(1);
        list.add(1);
        list.add(1);

        return list.head;
    }


    public static void main(String[] args) {

        MyLinkList list=new MyLinkList();
        list.add(3);
        list.add(90);
        list.add(4);
        list.add(31);
        list.showAll(list.head);


    }




}
