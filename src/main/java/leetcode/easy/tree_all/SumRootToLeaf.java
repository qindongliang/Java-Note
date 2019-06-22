package leetcode.easy.tree_all;

import java.util.Stack;

public class SumRootToLeaf {


    public static int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;

        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){

           TreeNode temp= stack.pop();

           if(temp.right!=null) {
               stack.push(temp.right);
           }
            if(temp.left!=null) {
                stack.push(temp.left);
            }



        }

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

        sumRootToLeaf(root);



    }



}
