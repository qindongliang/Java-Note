package leetcode.easy.linklist_all;

/**
 * Created by qindongliang on 2018/8/19.
 */
public class MiddleLinkList {

    public ListNode middleNode(ListNode head) {

        int count=0;
        ListNode nodes[]=new ListNode[100];
        ListNode node;
        for(node=head;node!=null;node=node.next){
            nodes[count]=node;
            count++;
        }

        return nodes[count/2];
    }

    ListNode nodes[]=new ListNode[100];

      private ListNode head;

      private ListNode tail;

    private int count=0;

    public void add(int val){

        ListNode node=new ListNode(val);

        if(head==null){
            head=tail=node;
        }else {
            tail.next=node;
            tail=node;
        }
         nodes[count]=node;
//        System.out.println("ss:" + nodes[count].val);
        count++;
    }


    public void printAll(){

        ListNode node;
        for(node=head;node!=null;node=node.next){
            System.out.println(node.val);
        }
    }




    public static void main(String[] args) {

            MiddleLinkList middleLinkList =new MiddleLinkList();
            middleLinkList.add(5);//0
            middleLinkList.add(15);//1
            middleLinkList.add(45);//2
            middleLinkList.add(1);//3
            middleLinkList.add(67);//3
            middleLinkList.add(67);//3

        int middle=  middleLinkList.count/2 ;

        System.out.println(middleLinkList.nodes[middle]);




    }




}
