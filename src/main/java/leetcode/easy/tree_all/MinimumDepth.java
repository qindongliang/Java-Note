package leetcode.easy.tree_all;

import java.util.Stack;

/****
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * 求二叉树里面最短路径的深度
 *
 */
public class MinimumDepth {

    public int minDepth1(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }


    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Stack<Integer> deep = new Stack<>();
        deep.push(1);
        int min = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {

            TreeNode cur = stack.pop();
            Integer depth = deep.pop();

            if (cur.left == null && cur.right == null) {
                min = Math.min(min, depth);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                deep.push(depth + 1);
            }

            if (cur.right != null) {
                stack.push(cur.right);
                deep.push(depth + 1);
            }


        }

        return min;
    }

}
