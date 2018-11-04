package data_structure.tree_search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 深度优先搜索
 * Created by qindongliang on 2018/11/3.
 */
public class BinarySearch {

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

    //深度优先搜索 的 迭代版本的统计
    public static void dfsMaxDepth(TreeNode root){

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




    //递归版本的统计
    public static int recursionMaxDeepLength(TreeNode root){
        if(root==null) return 0;
       int leftLen= recursionMaxDeepLength(root.leftChild)+1;//左子树统计
       int rightLen= recursionMaxDeepLength(root.rightChild)+1;//右子树统计
       return Math.max(leftLen,rightLen);

    }

    public static void bfsMaxDepth(TreeNode root){

        if(root==null){
            System.out.println("root is null");
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int count=0;

        while (!queue.isEmpty()){

            int size=queue.size();

            while (size>0){

                TreeNode node=queue.poll();// remove the head of this queue

                if(node.leftChild!=null){
                    queue.offer(node.leftChild);
                }

                if(node.rightChild!=null){
                    queue.offer(node.rightChild);
                }


                size=size-1;
            }

            count=count+1;

        }


        System.out.println("bfs-max-depth: "+count);



    }



    public static void main(String[] args) {

       // dfsMaxDepth(root);//深度优先搜索的迭代版本
        bfsMaxDepth(root);//广度优先搜索的迭代版本


      //  System.out.println( recursionMaxDeepLength(root));//递归版本




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
