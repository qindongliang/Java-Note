package leetcode.easy.tree_all;

import java.util.Stack;

/****
 *
 *
 * 链接：https://leetcode.com/problems/convert-bst-to-greater-tree/
 *
 * 描述：给定一个二叉搜索树，将其转换成一个更"大"的树，
 * 规则是原来的二叉搜索树的每一个node的value被改变成，
 * 在树里面所有大于该节点value的值的和。
 *
 * 解决思路：
 *
 * （1）迭代
 *
 * （2）递归
 *
 * 在二叉树里面比该值的大的节点一定在右边，所以我们可以直接
 * 轻易的遍历到最右侧的节点，然后倒回来求和，在赋值，
 * 同时在取左子树做同样的处理
 *
 *
 */
public class BSTreeToGreater {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();//从最顶级取数
                sum += node.val;
                node.val = sum;
                node = node.left;
            }
        }

        return root;
    }


    public TreeNode convertBST2(TreeNode root) {
        if (root == null) return null;
        convertBST2(root.right);
        root.val += sum;
        sum = root.val;
        convertBST2(root.left);
        return root;

    }


}
