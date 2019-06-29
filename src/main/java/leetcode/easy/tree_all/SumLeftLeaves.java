package leetcode.easy.tree_all;

import java.util.LinkedList;
import java.util.Queue;

public class SumLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;


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
