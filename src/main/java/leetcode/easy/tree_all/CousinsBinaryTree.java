package leetcode.easy.tree_all;

import java.util.LinkedList;
import java.util.Queue;

/***
 *
 * 题目连接：https://leetcode.com/problems/cousins-in-binary-tree/
 * 描述：给定两个数，让判断这两个数，是不是堂兄弟关系，堂兄弟的定义是
 * 这两个数的层级一样，但是有不同的父节点。
 *
 * 思路：使用BFS遍历，来迭代实现
 *
 *
 */
public class CousinsBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level1=-1;
        int level2=-1;
        int currLevel=-1;
        while (!queue.isEmpty()){
            currLevel++;
            int size=queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node=queue.poll();
                if(node.left!=null&&node.right!=null){
                    if(node.left.val==x&&node.right.val==y){
                     return false;
                    }

                    if(node.left.val==y&&node.right.val==x){
                        return false;
                    }
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

                if(node.val==x){
                    level1=currLevel;
                }
                if(node.val==y){
                    level2=currLevel;
                }
            }

            if(level1>0&&level2==level1){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
