package leetcode.easy.linklist_all;

/**
 * Created by Administrator on 2018/7/10.
 */
public class AddTwoNumbers {


    public static class ListNode{

        int val;
        ListNode next;
        ListNode(int x){
            val=x;
        }

    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // virtual node or dummy node
        ListNode dummyHead=new ListNode(0);

        ListNode p=l1;
        ListNode q=l2;
        ListNode curr=dummyHead;
        int carry=0;
        // as long as one node is not empty
        while(p!=null || q!=null){

            //判断p是否为空，如果不是null就取val的值，如果是null设置成0
            //determine if it is null, take val if it is not null or set it to zero if it is null
            int x= (p!=null)?p.val:0;
            int y= (q!=null)?q.val:0;

            int sum=carry+x+y;
            carry=sum/10;

            curr.next=new ListNode(sum%10);

            curr=curr.next;

            if(p!=null) p=p.next;
            if(q!=null) q=q.next;

        }

        if(carry>0){
            curr.next=new ListNode(carry);
        }

        return dummyHead.next;



    }


    public static void main(String[] args) {


        AddTwoNumbers addTwoNumbers =new AddTwoNumbers();

        ListNode xt= addTwoNumbers.addTwoNumbers(new ListNode(243),new ListNode(564));

        System.out.println(xt.val);


    }


}
