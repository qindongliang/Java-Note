package data_structure.linked_list;

/**
 * singlylikedlist exmpale
 https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html
 */


public class SinglyLinkedList2 {

        // point first
        private Node head;

        // ponit last
        private Node tail;

        public boolean isEmpyt(){
            return head==null;
        }


        public void add(int data){
            Node temp=new Node();
            temp.value=data;
            if(head==null){
                head=temp;
                tail=temp;
            }else{
                tail.next=temp;//
                tail=temp;
            }

        }

        public void printAll(){
            Node temp=head;
            while(temp!=null){
                System.out.println(temp.value);
                temp=temp.next;
            }
        }


    public static void main(String[] args) {

        SinglyLinkedList2 single=new SinglyLinkedList2();
        single.add(12);
        single.add(11);
        single.add(9);
        single.add(25);
        System.out.println("===========================");
        single.printAll();


    }


    class Node{
        public int value;
        public Node next;
    }



}
