package leetcode.easy.tree_all;

import java.util.LinkedList;
import java.util.Queue;

/*****
 *
 * 题目连接：https://leetcode.com/problems/univalued-binary-tree/
 *
 * 给定一个二叉树让判断整个树的节点值是不是都是相等的，如果相等就返回true，否则就返回false
 *
 * 思路：
 * 下面使用了两种方法：
 *
 * （1）第一种是迭代的方式
 *
 * （2）第二种是递归的方式
 *
 *
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode n=q.poll();
            if(n.val!=root.val){
                return false;
            }
            if(n.left!=null){
                q.add(n.left);
            }

            if(n.right!=null){
                q.add(n.right);
            }
        }
    return true;
    }


    public boolean dfs(TreeNode n,int val){
    if(n==null){
        return true;
    }

    if(n.val!=val){
        return false;
    }

    return dfs(n.left,val)&&dfs(n.right,val);

    }

    public boolean isUnivalTree2(TreeNode root) {

    return dfs(root,root.val);
    }



}
