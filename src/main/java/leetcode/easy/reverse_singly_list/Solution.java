package leetcode.easy.reverse_singly_list;

import java.util.List;

/**
 * Created by qindongliang on 2018/8/26.
 */
public class Solution {

    private ListNode head;
    private ListNode tail;

    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }


  public void add(int val){
      ListNode tmp=new ListNode(val);
      if(head==null){
          head=tail=tmp;
      }else {
          tail.next=tmp;
          tail=tmp;

      }

  }


  public void showAll(ListNode head){
      ListNode tmp=head;
      while (tmp!=null){
          System.out.println(tmp.val);
          tmp=tmp.next;
      }

  }

  private ListNode reverse(ListNode head){

      ListNode tmp=head;
      ListNode prev=null;
      ListNode current=null;
      while (tmp!=null){
          current =tmp;
          tmp=tmp.next;
          current.next=prev;
          prev=current;
      }
      return current;

  }

  private void delete1(int val){

      if(head.val==val){
          head=head.next;
          return;
      }

      ListNode tmp=head;
      ListNode prev=null;
      while (tmp!=null){
          prev=tmp;
          tmp=tmp.next;
          if(tmp.val==val){
              prev.next=tmp.next;
              return;
          }
      }

  }

    private void delete2(int val){

        if(tail.val==val){
            tail=null;
            System.out.println("不支持删除tail节点");
            return;
        }


        ListNode tmp=head;
        while (tmp!=null){
            if(tmp.val==val){
                tmp.val=tmp.next.val;
                tmp.next=tmp.next.next;
                break;
            }
            tmp=tmp.next;

        }

    }


    public static void main(String[] args) {

        Solution solution=new Solution();
        solution.add(5);
        solution.add(10);
        solution.add(89);
        solution.add(-1);

//        solution.showAll(solution.reverse(solution.head));

//        solution.delete1(-1);
        solution.delete2(-1);

        solution.showAll(solution.head);


    }





}
