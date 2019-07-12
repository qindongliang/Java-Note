package leetcode.easy.tree_all;

import java.util.Stack;

/****
 *
 *
 * https://leetcode.com/problems/path-sum/
 *
 */
public class PathSum1 {


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        stack.push(root);
        sums.push(sum);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            int value = sums.pop();
            if (cur.left == null && cur.right == null && cur.val == value) {
                return true;
            }
            if (cur.right != null) {
                stack.push(cur.right);
                sums.push(value - cur.val);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                sums.push(value - cur.val);
            }

        }

        return false;

    }


}
