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
        //求左子树高度
        int left = backTrack(node.left);
        //求右子树的高度
        int right = backTrack(node.right);
        //如果他们的绝对值大于1，就说明不均衡
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        //如果符合均衡，就返回这个子树最大的高度，继续回溯判断
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {

    }

}
