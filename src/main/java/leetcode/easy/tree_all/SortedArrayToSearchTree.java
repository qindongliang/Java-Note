package leetcode.easy.tree_all;

import java.util.Stack;

/****
 *
 * 连接：https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 题目描述：给定义升序的int数组，让写程序将其转成一颗严格平衡的二叉树
 *
 * 思路：对数组的中间截断，然后在每一段的中间截断，赋值到左右节点即可
 *
 */

public class SortedArrayToSearchTree {

    public static class Node {
        TreeNode node;
        int left;
        int right;

        public Node(TreeNode node, int left, int right) {
            this.node = node;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = helper(nums, 0, nums.length - 1);

        return head;

    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }


    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(0);

        Stack<Node> stack = new Stack<>();
        Node node = new Node(root, 0, nums.length - 1);
        stack.push(node);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            int mid = cur.left + (cur.right - cur.left) / 2;
            cur.node.val = nums[mid];
            if (cur.left < mid) {
                cur.node.left = new TreeNode(0);
                stack.push(new Node(cur.node.left, cur.left, mid - 1));
            }

            if (cur.right > mid) {
                cur.node.right = new TreeNode(0);
                stack.push(new Node(cur.node.right, mid + 1, cur.right));
            }

        }

        return root;
    }
}
