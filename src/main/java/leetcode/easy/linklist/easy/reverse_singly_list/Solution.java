package leetcode.easy.linklist.easy.reverse_singly_list;

import java.util.List;

/**
 * Created by qindongliang on 2018/8/26.
 */
public class Solution {

    private ListNode head;
    private ListNode tail;

    public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return val+"";
        }
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


    public static ListNode mergeSortedList(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;

        if(l1.val<l2.val){
            l1.next=mergeSortedList(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeSortedList(l2.next,l1);
            return l2;
        }


    }


    public static ListNode merge2SortedList(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode dummyHead=new ListNode(0);
        ListNode tail=dummyHead;

        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                tail.next=l1;
                l1=l1.next;
            }else {
                tail.next=l2;
                l2=l2.next;
            }
            tail=tail.next;
        }

        if(l1!=null){
            tail.next=l1;
        }
        if(l2!=null){
            tail.next=l2;
        }



        return dummyHead.next;


    }

    //对排序好的链表去重，一般的代码
    public static ListNode duplicateSortedListNormal(ListNode head){


        ListNode currentNode=head;
        while (currentNode!=null){
            ListNode next=currentNode.next;
            if(next==null){
                break;
            }
            if(currentNode.val==next.val){
                currentNode.next = next.next;
            }else {
                currentNode = currentNode.next;
            }
        }

        return head;

    }


    //对排序好的链表去重，简洁的代码
    public static ListNode duplicateSortedListBetter(ListNode head){


        ListNode currentNode=head;
        while (currentNode!=null&&currentNode.next!=null){
          if(currentNode.val==currentNode.next.val){
              currentNode.next=currentNode.next.next;
          }else {
              currentNode=currentNode.next;
          }
        }
        return head;

    }

    //判断链表是否有环
//    方式一：相对速度法。
//    fast 的 速度是 2 ，slow 的速度是 1 ，二者的相对速度是 2 - 1 = 1 。
//    所以，如果有环的话，必定会出现 fast 追上 slow 的情况。
    public static boolean hasCycle(ListNode head){

        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
                         //ListNode(1);
        Solution solution=new Solution();
        solution.addNode(node1);
        solution.addNode(node2);
        solution.addNode(node3);
        solution.addNode(node4);
        solution.addNode(node5);
        solution.addNode(node1);
//        solution.addNode(node2);

        ListNode  solw=solution.head;

        ListNode  fast=solution.head;

        while (fast!=null&&fast.next!=null){
            solw=solw.next;
            fast=fast.next.next;
            if(solw==fast) return true;
        }

        return false;


    }

    public static void main(String[] args) {
        System.out.println(hasCycle(null));
    }



    public static void main1(String[] args) {

        Solution solution=new Solution();
        solution.add(1);
        solution.add(1);
        solution.add(1);
        solution.add(2);
        solution.add(3);
        solution.add(3);
        solution.add(4);




//        showAll(solution.head);

//        showAll(solution.duplicateSortedListBetter(solution.head));











    }





}
