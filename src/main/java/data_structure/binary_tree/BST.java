package data_structure.binary_tree;

import java.util.Comparator;

public class BST< T extends Comparable<T>> {

    public Node<T> root;

    public void insert(T data){
        root=insert(root, data);
    }

    public Node<T> insert(Node<T> p, T data){

        if(p==null){
            return new Node<>(data,null,null);
        }

        if(compare(p.data,data)==0){
            return p;
        }

        if(compare(data,p.data)<0){
            p.left=insert(p.left,data);
        }else {
            p.right=insert(p.right,data);
        }

        return p;
    }

    private void showAll(){
        inOrder(root);

    }

    private void inOrder(Node<T> node){
        if(node==null) return;
        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }

    public static void main(String[] args) {

        BST<Integer> bst=new BST<>();

        bst.insert(12);
        bst.insert(24);
        bst.insert(6);
        bst.insert(9);
        bst.insert(1);

        bst.showAll();

    }


    private Comparator comparator;

    private int compare(T x, T y){
        if(comparator==null){
            return x.compareTo(y);
        }else {
            return comparator.compare(x,y);
        }
    }



   static class Node<T>{
        public T data;
        public Node<T> left;
        public Node<T> right;

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

       @Override
       public String toString() {
           return "Node{" +
                   "data=" + data +
                   '}';
       }
   }


}
