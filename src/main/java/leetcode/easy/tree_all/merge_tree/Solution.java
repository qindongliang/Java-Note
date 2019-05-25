package leetcode.easy.tree_all.merge_tree;

/**
 * Created by qindongliang on 2018/10/21.
 */
public class Solution {

   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }


 static void traveserTree(TreeNode node){

     if(node==null) return;

     System.out.print(node.val+" ");
     traveserTree(node.left);
     traveserTree(node.right);


 }

 public static TreeNode mergeTree(TreeNode t1,TreeNode t2){
     if(t1==null) return t2;
     if(t2==null) return t1;

     TreeNode newNode=new TreeNode(t1.val+t2.val);
     newNode.left=mergeTree(t1.left,t2.left);
     newNode.right=mergeTree(t1.right,t2.right);
     return  newNode;

 }


 public void combineTree(){
     TreeNode t1=new TreeNode(1);
     t1.left=new TreeNode(3);
     t1.right=new TreeNode(2);
     t1.left.left=new TreeNode(5);

     TreeNode t2=new TreeNode(2);
     t2.left=new TreeNode(1);
     t2.right=new TreeNode(3);
     t2.left.right=new TreeNode(4);
     t2.right.right=new TreeNode(7);

     TreeNode combineNode= mergeTree(t1,t2);

     traveserTree(combineNode);

 }

 public static void leetcode700SearchBST(){

     TreeNode t1=new TreeNode(4);
     t1.left=new TreeNode(2);
     t1.right=new TreeNode(7);
     t1.left.left=new TreeNode(1);
     t1.left.right=new TreeNode(3);


     TreeNode result= searchBST(t1,2);

     System.out.println(result);
     traveserTree(result);


 }

    /***
     * 需要注意二叉排序树的条件，根节点的值大于左边的值，小于右边的值，每个父节点都如此，
     * @param node
     * @param val
     * @return
     */
 public static TreeNode searchBST(TreeNode node,int val){
     if(node==null || node.val==val) return node;
     return  node.val<val?searchBST(node.right,val):searchBST(node.left,val);

 }



    public static void main(String[] args) {



        leetcode700SearchBST();


    }







}
