package leetcode.easy.tree_all;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/****
 *
 * 题目连接：https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * 描述：给定一个数组组成的n维树，现在要上按层级遍历的方式，把树遍历一遍，并返回结果
 *
 * 两种方式：
 * （1）使用queue
 * （2）递归的方式
 */

public class LevelOrderTraversal {


    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res=new LinkedList<>();
        if(root==null) return res;

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> li=new LinkedList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                Node node=queue.poll();
                li.add(node.val);
                queue.addAll(node.children);
            }
            res.add(li);
        }

        return res;
    }



    public List<List<Integer>> levelOrder2(Node root) {

        List<List<Integer>> list = new ArrayList();
        dfs(root, list, 0);
        return list;
    }

    void dfs(Node n,List<List<Integer>> list,int depth){
        if(n==null){ return;}

        if(depth>=list.size()){
            list.add(new ArrayList<>());
        }
        list.get(depth).add(n.val);
        for(Node x:n.children){
            dfs(x,list,depth+1);
        }
    }


}
