package leetcode.easy.middle_linklist;

import java.util.List;

/**
 * Created by qindongliang on 2018/8/19.
 */
public class Solution {

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

      //Definition for singly-linked list.
      public class ListNode {
          int val;
        ListNode next;
          ListNode(int x) { val = x; }

          @Override
          public String toString() {
              return val+"";
          }
      }

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

            Solution solution=new Solution();
            solution.add(5);//0
            solution.add(15);//1
            solution.add(45);//2
            solution.add(1);//3
            solution.add(67);//3
            solution.add(67);//3

        int middle=  solution.count/2 ;

        System.out.println(solution.nodes[middle]);




    }




}
