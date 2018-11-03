package data_structure.deep_first_search;

import java.util.Stack;

/**
 * 深度优先搜索
 * Created by qindongliang on 2018/11/3.
 */
public class DeepFirstSearch {

    static TreeNode<String> root=new TreeNode<>(50,"A");

    static {

        TreeNode<String> nodeB=new TreeNode<>(20,"B");
        TreeNode<String> nodeC=new TreeNode<>(60,"C");
        TreeNode<String> nodeD=new TreeNode<>(15,"D");
        TreeNode<String> nodeE=new TreeNode<>(30,"E");
        TreeNode<String> nodeF=new TreeNode<>(55,"F");
        TreeNode<String> nodeG=new TreeNode<>(70,"G");

        root.leftChild=nodeB;
        root.rightChild=nodeC;
        nodeC.leftChild=nodeF;
        nodeC.rightChild=nodeG;


        //树的组成--图示
        /**        A
         *     B       C
         *           F    G
         *
         *         50
         *     20      60
         *          55   70
         */
    }

    public static void maxDepth(TreeNode root){

        if(root==null){
            System.out.println("深度=0");
        }


        Stack<TreeNode> stack=new Stack<>();

        Stack<Integer>  value=new Stack<>();

        stack.push(root);

        value.push(1);

        int max=0;
//        System.out.println(stack+"  "+value);

        while (!stack.isEmpty()){
            System.out.println(stack+"   "+value);
            TreeNode node=stack.pop();//出栈
            int temp=value.pop();

            max=Math.max(temp,max);//得到最大值

            if(node.leftChild!=null){
                stack.push(node.leftChild);
                value.push(temp+1);
            }


            if(node.rightChild!=null){
                stack.push(node.rightChild);
                value.push(temp+1);
            }

//            System.out.println(value);

        }


        System.out.println("max deep length："+max);


    }

    public static void main(String[] args) {

        maxDepth(root);

    }


    static class TreeNode<T>{
        private int val;
        private T data;


        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int index, T data) {
            this.val = index;
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", data=" + data +
                    '}';
        }
    }




}
