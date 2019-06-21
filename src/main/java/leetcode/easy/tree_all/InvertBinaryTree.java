package leetcode.easy.tree_all;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/***
 *
 * 链接：https://leetcode.com/problems/invert-binary-tree/
 * 描述：给定一颗二叉树，让反转其左右子树，比如：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 思路：
 *
 * （1）递归
 *
 * （2）使用栈进行深度遍历
 *
 * （3）使用队列进行广度遍历
 *
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode tempRight=root.right;
        root.right=invertTree(root.left);
        root.left=invertTree(tempRight);
        return root;
    }


    public TreeNode invertTreeIteratorDFS(TreeNode root) {
        if(root==null) return null;
//        Deque<TreeNode> stack=new LinkedList<TreeNode>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            TreeNode left=node.left;
            node.left=node.right;
            node.right=left;
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }

        }
        return root;
    }


    public TreeNode invertTreeIteratorBFS(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            TreeNode left=node.left;
            node.left=node.right;
            node.right=left;
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }


        }

        return root;
    }



}
