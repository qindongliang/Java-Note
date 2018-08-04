package data_structure.linked_list;

/**
 * singlylikedlist exmpale
 https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html
 */


public class SinglyLinkedList {

        private Node head;


        public void addFirst(int data){
            Node newNode = new Node();
            newNode.value=data;
            head=newNode;
        }

        public boolean isEmpyt(){
            return head==null;
        }

        public void add(int data){

            if(head==null){
                addFirst(data);//fisrt add
            }else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                // current.next = null , we think it is a last node
                Node newNode = new Node();
                newNode.value = data;
                //add last node
                current.next = newNode;
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

        SinglyLinkedList single=new SinglyLinkedList();
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
