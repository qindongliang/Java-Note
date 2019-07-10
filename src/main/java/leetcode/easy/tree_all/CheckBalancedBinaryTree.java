package leetcode.easy.tree_all;

/****
 *
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * 题目描述：检查一棵树是否为平衡的二叉树
 *
 *
 */
public class CheckBalancedBinaryTree {

    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {

        if (root == null) return isBalanced;

        backTrack(root);
        return isBalanced;
    }

    public int backTrack(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int left = backTrack(node.left);
        int right = backTrack(node.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {

    }

}
