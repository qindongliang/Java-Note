package data_structure.binary_tree;

public class SimpleTree<T> {







 static class TreeNode<T>{
        private int index;
        private T data;


        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int index, T data) {
            this.index = index;
            this.data = data;
        }


    }



    public static void beforeTraverse(TreeNode node){
      if(node==null){
          return;
      }
        System.out.print(node.data+" ");
        beforeTraverse(node.leftChild);
        beforeTraverse(node.rightChild);

    }


    public static void afterTraverse(TreeNode node){
        if(node==null){
            return;
        }

        afterTraverse(node.leftChild);
        afterTraverse(node.rightChild);
        System.out.print(node.data+" ");
    }

    public static void middleTraverse(TreeNode node){
        if(node==null){
            return;
        }
        afterTraverse(node.leftChild);
        System.out.print(node.data+" ");
        afterTraverse(node.rightChild);

    }

    public static void main(String[] args) {

        TreeNode<String> root=new TreeNode<>(1,"A");
        TreeNode<String> nodeB=new TreeNode<>(1,"B");
        TreeNode<String> nodeC=new TreeNode<>(1,"C");
        TreeNode<String> nodeD=new TreeNode<>(1,"D");
        TreeNode<String> nodeE=new TreeNode<>(1,"E");
        TreeNode<String> nodeF=new TreeNode<>(1,"F");
        TreeNode<String> nodeG=new TreeNode<>(1,"G");

        root.leftChild=nodeB;
        root.rightChild=nodeC;
        nodeB.leftChild=nodeD;
        nodeB.rightChild=nodeE;
        nodeC.leftChild=nodeF;
        nodeC.rightChild=nodeG;


        /**        A
         *     B       C
         *  D    E   F    G
         *
         */

        //前序，中序，后序，指的是root节点的位置
        //从A开始遍历，先打印值，先遍历左后遍历右，叫先序遍历
        System.out.println("前序遍历");
        beforeTraverse(root);
        System.out.println("\n后序遍历");
        //从A开始，先遍历左后遍历右，在最后打印值，叫后序遍历
        afterTraverse(root);
        System.out.println("\n中序遍历：");
        //从A开始，先遍历左后遍历右，在中间打印值，叫中序遍历
        middleTraverse(root);


    }


}
