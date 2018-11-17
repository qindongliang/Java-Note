package leetcode.easy.tree.bean.left_right_node;

public class TreeNode {

      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }


      public TreeNode getNodeData(){

          TreeNode node3=new TreeNode(3);
          TreeNode node5=new TreeNode(5);
          TreeNode node1=new TreeNode(1);
          TreeNode node6=new TreeNode(6);
          TreeNode node2=new TreeNode(2);
          TreeNode node7=new TreeNode(7);
          TreeNode node4=new TreeNode(4);
          TreeNode node9=new TreeNode(9);
          TreeNode node8=new TreeNode(8);

          node3.left=node5;
          node3.right=node1;
          node5.left=node6;
          node5.right=node2;
          node2.left=node7;
          node2.right=node4;
          node1.left=node9;
          node1.right=node8;


          return node3;
      }





}
