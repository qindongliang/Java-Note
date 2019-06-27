package leetcode.easy.tree_all;

import java.util.Stack;

/****
 *
 * 题目连接：https://leetcode.com/problems/minimum-absolute-difference-in-bst/submissions/
 * 描述：给定一个二叉搜索树，让求出，树里面的绝对值最小的值是多少
 *
 *
 */

public class MinimumAbsoluteDifference {

    int min = Integer.MAX_VALUE;
    TreeNode pre;

    public int getMinimumDifference2(TreeNode root) {

        findMin(root);
        return min;
    }


    private void findMin(TreeNode root) {
        if (root == null) {
            return;
        }
        getMinimumDifference2(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        getMinimumDifference2(root.right);
    }


    public int getMinimumDifference(TreeNode root) {


        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();

                if (pre != null) {
                    min = Math.min(min, cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right;
            }


        }

        return min;


    }
}
