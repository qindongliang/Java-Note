package leetcode.easy.tree_all;

import java.util.Stack;

/****
 *
 * 链接：https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 *
 * 描述：给定一个二叉树，让遍历出所有的路径，这个路径是个二进制的数字，然后转成10进制后求和
 *
 * 思路：
 *
 * （1）使用递归
 *
 * （2）使用迭代，迭代版本稍微复杂点，因为需要封装一个数据结构
 *
 *
 */
public class SumRootToLeaf {

    static class Pair<U,V>{
        public  U first;
        public  V second;

        public Pair(){

        }

        public Pair(U first,V second){
            this.first=first;
            this.second=second;
        }


    }

    public static boolean isLeaf(TreeNode node){
        return node.left==null&&node.right==null;
    }


    public static int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;
        int sum=0;
        Stack<Pair<TreeNode,String>> stack=new Stack<>();

        stack.push(new Pair<TreeNode,String>(root,""));

        while (!stack.isEmpty()){
            Pair<TreeNode,String> pair=stack.pop();
            TreeNode curr=pair.first;
            String sb=pair.second;
            sb=sb+curr.val;

            if(isLeaf(curr)){ //leaf node
                sum+=Integer.parseInt(sb,2);

            }
            if(curr.right!=null) stack.push(new Pair<>(curr.right,sb));
            if(curr.left!=null) stack.push(new Pair<>(curr.left,sb));


        }

      return sum;
    }


    public static int sumRootToLeafRecursion(TreeNode root ,StringBuilder sb) {
        if(root==null) return 0;
        sb.append(root.val);
        if(isLeaf(root)){
            System.out.println(sb.toString());
        }
        sumRootToLeafRecursion(root.left,sb);
        sumRootToLeafRecursion(root.right,sb);
        sb.deleteCharAt(sb.length()-1);
        return 0;
    }


    public static int sumRootToLeafRecursion(TreeNode root) {
        sumRootToLeafRecursion(root,new StringBuilder(""));

        return 0;
    }


    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode s1=new TreeNode(0);
        TreeNode s2=new TreeNode(0);
        TreeNode s3=new TreeNode(1);
        TreeNode s4=new TreeNode(1);
        TreeNode s5=new TreeNode(0);
        TreeNode s6=new TreeNode(1);

        root.left=s1;
        root.right=s4;

        s1.left=s2;
        s1.right=s3;

        s4.left=s5;
        s4.right=s6;

        System.out.println(sumRootToLeaf(root));

//        sumRootToLeafRecursion(root);


    }



}
