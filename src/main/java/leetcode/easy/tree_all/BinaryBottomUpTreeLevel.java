package leetcode.easy.tree_all;

import java.util.*;

/***
 *
 * 链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 思路：给定一个二叉树，让按层级遍历的方式，从底向订的方式，输出每一层的数据。
 *
 * 比如：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出结果：
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 *
 *
 */

public class BinaryBottomUpTreeLevel {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> levelData = new LinkedList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.poll();
                levelData.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }


            }
            ((LinkedList<List<Integer>>) list).addFirst(levelData);//method 1
//           list.add(0,levelData);//method 2

        }
        return list;
    }


    public static List<List<Integer>> levelOrderBottom1(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> levelData = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.poll();
                levelData.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }


            }
            list.add(levelData);

        }
        Collections.reverse(list);
        return list;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        System.out.println(levelOrderBottom(root));


    }

}
