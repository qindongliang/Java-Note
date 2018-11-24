package leetcode.easy.tree.bean.binary_search_node;

/**
 * Created by qindongliang on 2018/11/24.
 */
public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode(int x) { val = x; }



    public static void beforeTraverse(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.val +" ");
        beforeTraverse(node.left);
        beforeTraverse(node.right);

    }


    public static TreeNode getData1(){

        TreeNode node1=new TreeNode(1);
        TreeNode node0=new TreeNode(0);
        TreeNode node5=new TreeNode(2);

        node1.left=node0;
        node1.right=node5;


        return node1;




    }



    public static TreeNode getData2(){

        TreeNode node3=new TreeNode(3);
        TreeNode node0=new TreeNode(0);
        TreeNode node4=new TreeNode(4);
        TreeNode node2=new TreeNode(2);
        TreeNode node1=new TreeNode(1);

        node3.left=node0;
        node3.right=node4;

        node0.right=node2;


        node2.left=node1;

        return node3;




    }

}
