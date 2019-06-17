package leetcode.easy.tree_all;

import java.util.Stack;

/****
 *
 *题目连接： https://leetcode.com/problems/increasing-order-search-tree/
 *
 *
 * 给定义一个二叉搜索树，要求把树按中序升序，组装成一个新的树，并且所有的节点都得放在节点的右侧
 */

public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {

        TreeNode head=null;
        TreeNode pre=null;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while (cur!=null||!stack.isEmpty()) {
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }

            cur=stack.pop();
            if(head==null){
                head=cur;
            }

            cur.left=null;

            if(pre!=null){
                pre.right=cur;
            }

            pre=cur;
            cur=cur.right;
        }

        return head;
    }



    public TreeNode increasingBST2(TreeNode root) {

        return increasingBST(root,null);
    }


    public TreeNode increasingBST(TreeNode root,TreeNode tail) {
        if(root==null) return tail;

        TreeNode res=increasingBST(root.left,root);
        root.left=null;
        root.right=increasingBST(root.right,tail);

        return res;

    }


}
