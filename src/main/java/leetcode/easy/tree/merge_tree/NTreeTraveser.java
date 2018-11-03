package leetcode.easy.tree.merge_tree;
import java.util.*;
/**
 * Created by qindongliang on 2018/10/21.
 */
public class NTreeTraveser {


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public static void main(String[] args) {

        Node node5=new Node(5,null);
        Node node6=new Node(6,null);

        List<Node> list=new ArrayList<>();
        list.add(node5);
        list.add(node6);

        Node node=new Node(3,list);


        List<Node> mainly=new ArrayList<>();

        mainly.add(node);
        mainly.add(new Node(2,null));
        mainly.add(new Node(4,null));

        Node node1=new Node(1,mainly);


        //recursion(node1);//递归实现

        //iteratively(node1);//迭代实现（前序）[1, 3, 5, 6, 2, 4]


       // iteratively2(node1);//迭代实现（后序）[5, 6, 3, 2, 4, 1]

        recursion2(node1);




    }

    public  static void recursion(Node root){
        System.out.println(root.val);
        if(root.children!=null){
            for(Node tmp:root.children){
                recursion(tmp);
            }
        }else{
            return;
        }
    }

    public static   List<Integer> iteratively(Node root){

        List<Integer> list=new ArrayList<>();

        if(root==null) return list;

        //使用stack来保存数据
        Stack<Node> stack=new Stack<>();
        stack.add(root);

        while(!stack.empty()){
            root=stack.pop();
            list.add(root.val);

            if(root.children!=null){
                for (int i = root.children.size()-1; i >=0 ; i--) {
                    stack.add(root.children.get(i));
                }
            }
        }

        System.out.println(list);
        return list;


    }


    /***
     * 从底上下递归输出
     * @param root
     */
    public static  void recursion2(Node root){

        if(root==null) return;
        if(root.children!=null) {
            for (Node chd : root.children) {
                recursion2(chd);
            }
        }

        System.out.println(root.val);

    }


    public static   List<Integer> iteratively2(Node root){

        List<Integer> list=new ArrayList<>();

        if(root==null) return list;

        //使用stack来保存数据
        Stack<Node> stack=new Stack<>();
        stack.add(root);

        while(!stack.empty()){
            root=stack.pop();
            list.add(root.val);

            if(root.children!=null){
                for (Node chd:root.children) {
                    stack.add(chd);
                }
            }
        }
        Collections.reverse(list);
        System.out.println(list);
        return list;


    }

}