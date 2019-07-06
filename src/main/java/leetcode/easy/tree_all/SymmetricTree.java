package leetcode.easy.tree_all;

import java.util.Stack;

/***
 *
 * https://leetcode.com/problems/symmetric-tree/
 *
 * 判断一颗二叉树是否为对称的二叉树
 *
 */
public class SymmetricTree {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);


    }


    public boolean isMirror(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);

    }


    public boolean isSymmetric1(TreeNode root) {

        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();

            if (t1 == null && t2 == null) continue;

            if (t1 == null || t2 == null || t1.val != t2.val) {
                return false;
            }

            stack.push(t1.left);
            stack.push(t2.right);

            stack.push(t1.right);
            stack.push(t2.left);


        }

        return true;

    }

}
