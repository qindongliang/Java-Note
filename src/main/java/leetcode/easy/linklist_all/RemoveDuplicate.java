package leetcode.easy.linklist_all;


public class RemoveDuplicate {


    /***
     *  删除算法一
     *  1->1->2->3->3
     *  处理成
     *  1->2->3
     * @param thead
     */
    public static void delete1(MyLinkList.ListNode thead){
        MyLinkList.ListNode head=thead;
        while (head!=null&&head.next!=null){

            if(head.val==head.next.val){
                head.next=head.next.next;
            }else{
                head=head.next;
            }
        }
    }

    /****
     * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
     * @param thead
     */
    public static MyLinkList.ListNode delete2(MyLinkList.ListNode head){

        MyLinkList.ListNode dummy=new MyLinkList.ListNode(-1);
        dummy.next=head;


        MyLinkList.ListNode pre=dummy;

        MyLinkList.ListNode cur=head;

        while (cur!=null){

            while (cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }//找到第一个不相等的第一个节点，也就是cur.next

            if(pre.next==cur){
                pre=pre.next;
            }else{
                pre.next=cur.next;
            }
            cur=cur.next;

        }

        return dummy.next;
    }



    public static void main(String[] args) {


        MyLinkList list=new MyLinkList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);


        MyLinkList.showAll(delete2(list.head));





    }

}
