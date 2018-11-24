package leetcode.easy.tree.leetcode_669;

import leetcode.easy.tree.bean.binary_search_node.TreeNode;

/**
 * Created by qindongliang on 2018/11/24.
 */
public class Solution {



    public static TreeNode trimBST(TreeNode root, int L, int R) {
        //如果，节点等于nul，就返回nul
        if (root == null) return null;

        //如果当前的节点值，小于范围最小值，就返回右子树，否则就返回左子树
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        //
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }

    public static TreeNode iterator(TreeNode root, int L, int R) {

        if(root==null) return root;

        while (root.val<L||root.val>R){

            if(root.val<L){
                root=root.right;
            }

            if(root.val>R){
                root=root.left;
            }

        }

        TreeNode dummy=root;

        System.out.println(root.val);
        //remove the invaild nodes form left subtree


        while (dummy!=null){

            while (dummy.left!=null&&dummy.left.val<L){
                dummy.left=dummy.left.right;
            }

            dummy=dummy.left;

        }

        dummy=root;

        while (dummy!=null){

            while (dummy.right!=null&&dummy.right.val>R){
                dummy.right=dummy.right.left;
            }
            dummy=dummy.right;
        }




        return  root;


    }



    public static void main(String[] args) {

//        TreeNode node=TreeNode.getData1();
        TreeNode node=TreeNode.getData2();

        TreeNode.beforeTraverse(node);
        System.out.println("\n");
//
       TreeNode resultNode=trimBST(node,1,3);
        TreeNode.beforeTraverse(resultNode);


//        iterator(node,1,2);


    }

}
