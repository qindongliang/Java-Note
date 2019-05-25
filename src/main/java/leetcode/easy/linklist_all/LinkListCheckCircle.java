package leetcode.easy.linklist_all;

/**
 * Created by qindongliang on 2018/8/26.
 */
public class LinkListCheckCircle {

    private ListNode head;
    private ListNode tail;



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


  // -1 4 5 1 1 2 1


  //删除链表里面所有指定值的元素，比如
    // 1 2 6 3 4 5 6 删除后就是 3 6 5
    // 1 , 1
    //一般
  private void delete1(int val){

      //采用一个虚拟的头节点
      ListNode fakeHead=new ListNode(-1);

      //它的下一个节点是head
      fakeHead.next=head;
      //head作为当前节点
      ListNode curr=head;
      //设置虚拟节点为上一个节点
      ListNode prev=fakeHead;

      while(curr!=null) {
          //如果当前的值等于要删除的值
          if (curr.val == val) {
              //把虚拟头节点的next指为当前的下一个,不切换引用继续循环
              prev.next = curr.next;
          } else {
              //否则就把虚拟头节点指向下一个节点，代表前面的值没有要删除的
              prev=prev.next;
          }
          //切换当前节点的引用为下一个
          curr=curr.next;
      }

      head=fakeHead.next;


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
                         //MyLinkList(1);
        LinkListCheckCircle linkListCheckCircle =new LinkListCheckCircle();
        linkListCheckCircle.addNode(node1);
        linkListCheckCircle.addNode(node2);
        linkListCheckCircle.addNode(node3);
        linkListCheckCircle.addNode(node4);
        linkListCheckCircle.addNode(node5);
        linkListCheckCircle.addNode(node1);
//        linkListCheckCircle.addNode(node2);

        ListNode  solw= linkListCheckCircle.head;

        ListNode  fast= linkListCheckCircle.head;

        while (fast!=null&&fast.next!=null){
            solw=solw.next;
            fast=fast.next.next;
            if(solw==fast) return true;
        }

        return false;


    }


    public ListNode buildCircleLinkList(){

        LinkListCheckCircle linkListCheckCircle =new LinkListCheckCircle();

        ListNode  n1=new ListNode(13);

        ListNode  n2=new ListNode(4);

        ListNode  n3=new ListNode(25);

        ListNode  n4=new ListNode(16);

        ListNode  n5=new ListNode(33);

        ListNode  n6=new ListNode(72);


        n6.next=n3;


        linkListCheckCircle.addNode(n1);
        linkListCheckCircle.addNode(n2);
        linkListCheckCircle.addNode(n3);
        linkListCheckCircle.addNode(n4);
        linkListCheckCircle.addNode(n5);
        linkListCheckCircle.addNode(n6);


        return linkListCheckCircle.head;
    }

    public void detectCircle(){

        ListNode head=buildCircleLinkList();

        ListNode slow=head;
        ListNode fast=head;

        while (slow!=null&&fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){//有环
                break;
            }
        }

        if(fast==null||fast.next==null){
            System.out.println("该链表没有环！");
        }else {
            System.out.println("链表存在闭环！");
        }

        slow=head;
        //开始找环的入口点
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        System.out.println("环的值是："+slow.val);
    }

    public static void main(String[] args) {

        LinkListCheckCircle linkListCheckCircle =new LinkListCheckCircle();
        linkListCheckCircle.detectCircle();


    }

    public static void main3(String[] args) {
//        System.out.println(hasCycle(null));

//        LinkListCheckCircle linkListCheckCircle=new LinkListCheckCircle();

//        linkListCheckCircle.add(1);
//        linkListCheckCircle.add(2);
//        linkListCheckCircle.add(1);
//        linkListCheckCircle.add(2);
//        linkListCheckCircle.add(1);
//        linkListCheckCircle.add(1);
//        linkListCheckCircle.add(4);
//        linkListCheckCircle.add(5);
//        linkListCheckCircle.add(1);

//        linkListCheckCircle.delete1(1);


//        showAll(linkListCheckCircle.head);

//        System.out.println(linkListCheckCircle.isPalindrome());
        LinkListCheckCircle linkListCheckCircle =new LinkListCheckCircle();

        linkListCheckCircle.add(11);
        linkListCheckCircle.add(2);
        linkListCheckCircle.add(4);
        linkListCheckCircle.add(8);
        linkListCheckCircle.add(0);

//        showAll(linkListCheckCircle.head);
        printEndToStart(linkListCheckCircle.head);


//        System.out.println(linkListCheckCircle.isPalindrome());
    }


    private static void printEndToStart(ListNode head){
        if(head==null){ return; }
        printEndToStart(head.next);
        System.out.println(head.val);
    }




    public boolean isPalindrome(){

        ListNode solw=head;

        ListNode fast=head;

        while (fast!=null&&fast.next!=null){
            solw=solw.next;
            fast=fast.next.next;
        }

        if(fast!=null){
            solw=solw.next;
        }

        solw=reverse(solw);//反转剩下的部分
        fast=head;

        while (solw!=null){
            if(fast.val!=solw.val){
                return false;
            }
            fast=fast.next;
            solw=solw.next;
        }



        return true;
    }





    public static void main1(String[] args) {

        LinkListCheckCircle linkListCheckCircle =new LinkListCheckCircle();
        linkListCheckCircle.add(1);
        linkListCheckCircle.add(1);
        linkListCheckCircle.add(1);
        linkListCheckCircle.add(2);
        linkListCheckCircle.add(3);
        linkListCheckCircle.add(3);
        linkListCheckCircle.add(4);




//        showAll(linkListCheckCircle.head);

//        showAll(linkListCheckCircle.duplicateSortedListBetter(linkListCheckCircle.head));











    }





}
