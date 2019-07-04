package leetcode.easy.tree_all;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/****
 *https://leetcode.com/problems/binary-tree-paths/
 *
 * 描述: 找出二叉树里面所有的路径，并返回到一个list里面，节点之间使用->分割
 *
 *
 */

public class BinaryTreePath {


    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> answer=new ArrayList<>();
        if(root!=null){
         searchBST(root,"",answer);
        }
      return answer;

    }

    private static void searchBST(TreeNode root,String path,List<String> anser){

        if(root.left==null&&root.right==null) anser.add(path+root.val);
        if(root.left!=null){
            searchBST(root.left,path+root.val+"->",anser);
        }
        if(root.right!=null){
            searchBST(root.right,path+root.val+"->",anser);
        }
    }

    public static List<String> binaryTreePaths1(TreeNode root) {
        List<String> res=new LinkedList<>();
        if(root==null) return res;
        Stack<PO> stack=new Stack<>();

        stack.push(new PO(root,""+root.val));

        while (!stack.isEmpty()){
            PO p=stack.pop();
            if(p.node.left==null&&p.node.right==null){
                res.add(p.path);
            }

            if(p.node.left!=null){
                stack.add(new PO(p.node.left,p.path+"->"+p.node.left.val));
            }

            if(p.node.right!=null){
                stack.add(new PO(p.node.right,p.path+"->"+p.node.right.val));
            }
        }
        return res;
    }

    public static void main(String[] args) {

        TreeNode t1=new TreeNode(1);
        t1.left=new TreeNode(2);
        t1.left.left=new TreeNode(3);
        t1.left.right=new TreeNode(4);

        t1.right=new TreeNode(5);


        System.out.println(binaryTreePaths(t1));



    }

    static class PO{
        public TreeNode node;
        public String path;

        public PO(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }


}
