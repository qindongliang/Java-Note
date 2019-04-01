package data_structure.binary_tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class BST< T extends Comparable<T>> {

    public Node<T> root;

    public void insert(T data){
        root=insert(root, data); //递归插入
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

    public boolean search(T data){
      return   search(root,data);
    }

    public boolean search(Node<T> node,T data){
        if(node==null){
            return false;
        }
        if(compare(node.data,data)==0){
            return true;
        }else if(compare(data,node.data)<0) {
            return search(node.left,data);
        }else{
            return search(node.right,data);
        }

    }


    public void delete(T data){
        root=delete(root,data);
    }

    public Node<T> delete(Node<T> node,T data){

        if(node==null){
            throw new RuntimeException("删除的节点不存在");
        }else if(compare(data,node.data)<0){
            node.left=delete(node.left,data);
        }else if(compare(data,node.data)>0){
            node.right=delete(node.right,data);
        }else{//叶子节点，或者只拥有一个孩子节点的处理逻辑是一样的
            if(node.left==null){
                return node.right;
            }else if(node.right==null){
                return node.left;
            }else{
                //到这一步说明删除的节点拥有2个孩子节点
                //找到剩下左子树里面最大的节点，或者找到右子树里面最小的节点，这里使用的是前者
                //使用最大值覆盖当前要被删除的节点的值
                node.data=retrieveData(node.left);
                //最后删除，在剩下左子树里面刚才被替换到最大值的节点
                node.left=delete(node.left,node.data);
            }

        }

    return node;
    }


    private T retrieveData(Node<T> p)
    {
        while (p.right != null) p = p.right;

        return p.data;
    }


    public void inOrderiterator(Node<Integer> root){

        Stack<Node<Integer>> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        while (root!=null||!stack.isEmpty()){
            if(root!=null) {
                stack.push(root);
                root = root.left;
            }else{
                root=stack.pop();
                list.add(root.data);
                root=root.right;
            }
        }

        System.out.println(list);



    }




    public static void main(String[] args) {

        BST<Integer> bst=new BST<>();

        bst.insert(12);
        bst.insert(24);
        bst.insert(6);
        bst.insert(9);
        bst.insert(1);
        bst.insert(11);

//        bst.showAll();

//        System.out.println(bst.search(9));
//        bst.delete(6);
//        System.out.println("=============================");
        //中序递归
//        bst.showAll();
        //中序迭代
        bst.inOrderiterator(bst.root);

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
