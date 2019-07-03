package leetcode.easy.tree_all;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/****
 *
 * 链接：https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * 求二叉树左右子树的最大直径和
 *
 *
 */
public class DiameterBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;

    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        stack.push(root);
        int max = 0;
        int length = 0;

        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t != null) {
                Integer left = map.get(t.left);
                Integer right = map.get(t.right);

                if (left != null && right != null) {
                    map.put(t, Math.max(left, right) + 1);
                    max = Math.max(max, left + right);
                } else {
                    stack.push(t);
                    stack.push(t.right);
                    stack.push(t.left);

                }
            } else {
                map.put(null, 0);
            }
        }


        return max;
    }
}
