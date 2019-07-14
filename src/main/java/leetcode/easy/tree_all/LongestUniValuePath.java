package leetcode.easy.tree_all;

import java.util.Stack;

/****
 *
 * https://leetcode.com/problems/longest-univalue-path/
 *
 * 最同一个值的最长连续出现次数
 *
 *
 */

public class LongestUniValuePath {

    int result = 0;

    public int longestUnivaluePath(TreeNode root) {

        pathHelper(root);
        return result;

    }

    private int pathHelper(TreeNode root) {
        if (root == null) return 0;
        int left = pathHelper(root.left);
        int right = pathHelper(root.right);

        left = root.left != null && root.val == root.left.val ? left + 1 : 0;
        right = root.right != null && root.val == root.right.val ? right + 1 : 0;

        result = Math.max(left + right, result);

        return Math.max(left, right);
    }


//    public int longestUnivaluePath1(TreeNode root) {
//
//        if (root == null) return 0;
//
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//
//        Stack<Integer> deep = new Stack<>();
//        deep.push(1);
//        int max = 0;
//
//        while (!stack.isEmpty()) {
//
//            TreeNode cur = stack.pop();
//            Integer depth = deep.pop();
//
//           int left=0;
//           int right=0;
//            if (cur.left != null) {
//                stack.push(cur.left);
//
//                if(cur.val==cur.left.val){
//                    deep.push(depth + 1);
//                    left=depth+1;
//                }else {
//                    deep.push(0);
//                }
//
//
//            }
//
//            if (cur.right != null) {
//                if(cur.val==cur.right.val){
//                    deep.push(depth + 1);
//                    right=depth+1;
//                }else {
//                    deep.push(0);
//                }
//            }
//
//            max=Math.max(left+right,max);
//
//        }
//
//        return max;
//    }


    public static void main(String[] args) {

    }

}
