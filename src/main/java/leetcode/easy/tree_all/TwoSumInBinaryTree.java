package leetcode.easy.tree_all;

import java.util.*;

/****
 *
 * 题目连接：https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * two sum的二叉搜索树版本。解法也是有两种：
 *
 * （1）使用迭代的BFS版本
 *
 * （2）使用递归的版本
 *
 *
 */
public class TwoSumInBinaryTree {
  static  Set<Integer> set=new HashSet<>();
    public static boolean findTarget(TreeNode root, int k) {

        if(root==null) return false;

        Queue<TreeNode> queue=new LinkedList<>();



        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(set.contains(k-node.val)){
                return true;
            }
            set.add(node.val);

            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }

        }

    return false;
    }



    public static boolean findTargetRecursion(TreeNode root, int k) {
        if(root==null) return false;

        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);

    }

}
