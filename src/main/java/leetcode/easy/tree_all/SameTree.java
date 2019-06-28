package leetcode.easy.tree_all;

import java.util.LinkedList;
import java.util.Queue;

/****
 *
 * 题目连接：https://leetcode.com/problems/same-tree/
 * 描述：给定二个二叉树，让判断二颗树的值是否完全相等。
 *
 *
 */
public class SameTree {

    public boolean isSameTree2(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            return p == q;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;

    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode f = queue.poll();
            TreeNode s = queue.poll();
            if (f == null && s == null) {
                continue;
            } else if (f == null || s == null || f.val != s.val) {
                return false;
            }
            queue.add(f.left);
            queue.add(s.left);
            queue.add(f.right);
            queue.add(s.right);
        }

        return true;
    }

}
