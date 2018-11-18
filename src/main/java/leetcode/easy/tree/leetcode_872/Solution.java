package leetcode.easy.tree.leetcode_872;

import leetcode.easy.tree.bean.left_right_node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qindongliang on 2018/11/18.
 */
public class Solution {


    public static boolean leafSimilar(TreeNode root1,TreeNode root2){
        //比较两颗子树的叶子节点是否相似
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();

        dfs(root1,list1);
        dfs(root2,list2);

        return list1.equals(list2);
    }

    public static void dfs(TreeNode n,List<Integer> list){
        if(n==null) return;
        if(n.left==null&&n.right==null){
            list.add(n.val);//叶子节点
        }
        dfs(n.left,list);//左边递归
        dfs(n.right,list);//右边递归

    }


    public static void main(String[] args) {
        leafSimilar(TreeNode.getRoot(),TreeNode.getRoot());
    }


}
