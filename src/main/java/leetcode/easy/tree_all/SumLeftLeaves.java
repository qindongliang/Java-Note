package leetcode.easy.tree_all;

import java.util.LinkedList;
import java.util.Queue;

/****
 *
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * 题目描述：给定一个二叉树，让求出所有该树左叶子节点的和
 *
 * 思路：其实该题比较简单，直接按照题意求解即可
 *
 *
 */
public class SumLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }

        sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left != null) {
                //证明是叶子节点
                if (temp.left.left == null && temp.left.right == null) {
                    sum += temp.left.val;
                }
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }

        }
        return sum;
    }

}
