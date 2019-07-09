package leetcode.easy.tree_all;

import java.util.Stack;

/****
 *
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
 * 给定两棵树s和t，现在判断t是否属于s的一颗子树
 *
 */
public class SubtreeAnotherTree {

    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public boolean isSubtree2(TreeNode s, TreeNode t) {
        String sAppend = generatePreOrderString(s);
        String tAppend = generatePreOrderString(t);
        System.out.println(sAppend);
        System.out.println(tAppend);
        return sAppend.contains(tAppend);

    }

    public String generatePreOrderString(TreeNode s) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                sb.append(",#");
            } else {
                sb.append(",").append(node.val);
            }

            if (node != null) {
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return sb.toString();
    }

}
