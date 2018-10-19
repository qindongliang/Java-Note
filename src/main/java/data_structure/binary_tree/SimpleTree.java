package data_structure.binary_tree;

public class SimpleTree<T> {



    static TreeNode<String> root=new TreeNode<>(50,"A");

    static {

        TreeNode<String> nodeB=new TreeNode<>(20,"B");
        TreeNode<String> nodeC=new TreeNode<>(60,"C");
        TreeNode<String> nodeD=new TreeNode<>(15,"D");
        TreeNode<String> nodeE=new TreeNode<>(30,"E");
        TreeNode<String> nodeF=new TreeNode<>(55,"F");
        TreeNode<String> nodeG=new TreeNode<>(70,"G");

        root.leftChild=nodeB;
        root.rightChild=nodeC;
        nodeB.leftChild=nodeD;
        nodeB.rightChild=nodeE;
        nodeC.leftChild=nodeF;
        nodeC.rightChild=nodeG;

        //树的组成--图示
        /**        A
         *     B       C
         *  D    E   F    G
         *
         *         50
         *     20      60
         *  15   30  55   70
         */
    }





 static class TreeNode<T>{
        private int val;
        private T data;


        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int index, T data) {
            this.val = index;
            this.data = data;
        }


    }


    public static TreeNode insert(TreeNode myroot,int val){

        if(myroot==null){
            myroot=new TreeNode<String>(val,val+"");
        }else{
            if(val<myroot.val){
                myroot.leftChild=insert(myroot.leftChild,val);
            }else{
                myroot.rightChild=insert(myroot.rightChild,val);
            }
        }
        return  myroot;
    }


    public static void beforeTraverse(TreeNode node){
      if(node==null){
          return;
      }
        System.out.print(node.val +" ");
        beforeTraverse(node.leftChild);
        beforeTraverse(node.rightChild);

    }


    public static void afterTraverse(TreeNode node){
        if(node==null){
            return;
        }

        afterTraverse(node.leftChild);
        afterTraverse(node.rightChild);
        System.out.print(node.val +" ");
    }

    public static void middleTraverse(TreeNode node){
        if(node==null){
            return;
        }
        middleTraverse(node.leftChild);
//        System.out.print(node.data+" ");
        System.out.print(node.val +" ");
        middleTraverse(node.rightChild);
    }


    public static void allTraverse(TreeNode root){
        //前序，中序，后序，指的是root节点的位置

        System.out.println("前序遍历");
        beforeTraverse(root);//从A开始遍历，先打印值，先遍历左后遍历右，叫先序遍历

        System.out.println("\n后序遍历");
        afterTraverse(root);//从A开始，先遍历左后遍历右，在最后打印值，叫后序遍历

        System.out.println("\n中序遍历：");
        middleTraverse(root);//从A开始，先遍历左后遍历右，在中间打印值，叫中序遍历
    }


    public static void addTreeData(){
        int a[]={44,11,20,15,32,60,7,9,8};
        TreeNode root = new TreeNode(a[0],a[0]+"");
        for(int i=1;i<a.length;i++){
            insert(root,a[i]);
        }

        allTraverse(root);
    }

    public static void main(String[] args) {
        addTreeData();


    }





}
