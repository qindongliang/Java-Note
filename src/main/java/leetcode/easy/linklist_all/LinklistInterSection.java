package leetcode.easy.linklist_all;

/***
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * intersection of two singly linklist
 * 求两个单向链表的交点的位置
 *
 * 首先两个单向链表相交，一定不会是在头部，否则就成一个链表了，
 * 那么必定是尾部是相等的.
 *        1 -> 2 -> 21 -> 22 -> 23
 * 11 -> 12 -> 13 -> 21 -> 22 -> 23
 *
 * 解决方法有两种：
 *
 * 第一种方法：统计两个链表的长度，长度大的链表先跳过去之前的间隔，然后后面的依次比较引用地址
 *
 * 第二种方法：直接对两个链表进行两两相比，如果next=null，那么则拼接另一个链表到此链表上，继续循环比较，直到两端都比较一遍
 * 最终可得结果
 *
 */
public class LinklistInterSection {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while(a!=b){
            a=a==null?headB:a.next;
            b=b==null?headA:b.next;
        }
        return a;

    }


    public static ListNode getIntersectionNodeByLen(ListNode headA, ListNode headB) {

        //boundary check
        if(headA == null || headB == null) return null;

        int lenA=size(headA);
        int lenB=size(headB);

        while (lenA>lenB){
              headA=headA.next;
              lenA--;
        }

        while (lenA<lenB){
            headB=headB.next;
            lenB--;
        }

        // find the intersection until end
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

     return headA;
    }




    public static void show(ListNode head){

        while(head!=null){
            System.out.print(head.val+" -> ");
            head=head.next;
        }
        System.out.println();
    }

    public static int size(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }


    public static void main(String[] args) {

        ListNode link1=new ListNode(1);
        ListNode link2=new ListNode(2);

        link1.next=link2;



        //  3 -> 4

        ListNode link11=new ListNode(11);
        ListNode link12=new ListNode(12);
        ListNode link13=new ListNode(13);

        link12.next=link13;
        link11.next=link12;
        // 11 -> 12 -> 13

        ListNode link21=new ListNode(21);
        ListNode link22=new ListNode(22);
        ListNode link23=new ListNode(23);

        link22.next=link23;
        link21.next=link22;

        // 21 -> 22 -> 23

        link2.next=link21;
        // 1 -> 2 -> 21 -> 22 -> 23

        link13.next=link21;

        // 11 -> 12 -> 13 -> 21 -> 22 -> 23

        show(link1);

        show(link11);

        System.out.println(size(link1));
        System.out.println(size(link11));




        ListNode interSection=getIntersectionNode(link1,link11);
        ListNode interSection2=getIntersectionNodeByLen(link1,link11);

        System.out.println(interSection.val);
        System.out.println(interSection2.val);
//        System.out.println(interSection3.val);


    }





}
