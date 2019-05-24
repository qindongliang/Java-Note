package leetcode.easy.linklist_all;


public class RemoveDuplicate {


    /***
     *  删除算法一
     *  1->1->2->3->3
     *  处理成
     *  1->2->3
     * @param thead
     */
    public static void delete1(ListNode thead){
        ListNode head=thead;
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
     * @param head
     */
    public static ListNode delete2(ListNode head){

        //指针一个虚拟head
        ListNode dummy=new ListNode(-1);
        dummy.next=head;


        ListNode pre=dummy;

        ListNode cur=head;

        while (cur!=null){

            //如果是连续出现的数字，该段代码可以找到最后一个重复的数字赋值到cur里面
            while (cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }//找到第一个不相等的第一个节点，也就是cur.next

            //移动pre指针到不重复的第一个节点上
            if(pre.next==cur){
                pre=pre.next;
            }else{//把不重复的第一个元素，挂到pre指针的next上
                pre.next=cur.next;
            }
            //cur指针移动
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
