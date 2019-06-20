package leetcode.easy.tree_all;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 *
 * 题目描述：给定一个二叉树，让求出每层的节点的平均值，最后以一个list返回
 *
 * 思路：其实是考察二叉树的的层级遍历的知识点，迭代的方式非常简洁如下。
 *
 */
public class AverageLevelTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int size=queue.size();
            double sum=0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            result.add(sum*1.0/size);
        }

    return result;
    }


}
