package data_structure.binary_tree;

/****
 * 红黑树代码实现
 * https://github.com/jrviray/CS_480_Project_06/blob/master/src/cpp/edu/cs480/project06/RedBlackTree.java
 * https://github.com/mckeeh3/red-black-tree/blob/master/src/main/java/RedBlackTree.java
 * https://www.geeksforgeeks.org/red-black-tree-set-2-insert/
 * @param <K>
 * @param <V>
 */
public class RBTree<K extends  Comparable<K>,V>   {
    private final static boolean RED = true;
    private final static boolean BLACK = false;

    private Node root;

    private String prettyString;


    public void add(K key, V value) {

        Node current=root;
        Node parent=null;

        if(root==null){
            root=new Node(key,value,RED);
            root.color=BLACK;
        }else{

            while (current.key!=null){

                parent=current;

                if(key.compareTo(current.key)>0){
                    current=current.right;
                }else{
                    current=current.left;
                }

            }

            //能到此处说明current.key=null
            Node newNode=new Node(key,value,RED);
            newNode.parent=parent;//parent赋值
            if(key.compareTo(parent.key)<0){
                parent.left =newNode;//左孩子
            }else if(key.compareTo(parent.key)>0){
                parent.right =newNode;//右孩子
            }
            //进行矫正
            addFixTree(newNode);

        }


    }




    public void addFixTree(Node target){
        //新添加的节点都是红色
        if(target.parent.isBlack()){//父节点颜色是黑色，没有违背任何红黑树性质，直接返回
            return;
        }else if(target.uncle().isRed()){
            //如果叔叔节点是红色，那么只需要变色即可=> 父节点和叔叔全变黑色，爷爷节点变黑色，然后
            //从爷爷节点开始，重复此步骤，对整棵树的可能修改的颜色进行校正
            recolor(target);
        }else if(target.uncle().isBlack()){
            //如果叔叔节点的颜色是黑色，需要分四种情况做旋转，这一点与AVL树的情况类似
            //1.左旋 2.右旋  3.左右旋 4.右左旋
            //这个地方不需要判断是否null

            //left-left case
            if(target.isLeft()&&target.parent.isLeft()){
             leftLeftCase(target);
            //left(parent)-right(child) case
            }else if(target.isRight()&&target.parent.isLeft()){

            //right-right case
            }else if(target.isRight()&&target.parent.isRight()){

            //right(parent)-left(child) case
            }else if(target.isLeft()&&target.parent.isRight()){

            }


        }

    }

    public void leftLeftCase(Node target){
         //左-左的情况，是需要右旋，右旋的节点是该节点的爷爷节点做为参照，具体见：https://www.geeksforgeeks.org/c-program-red-black-tree-insertion/
        rotateRight(target.grandParent());

        if(target.isRed()&&target.parent.isRed()){//双红
            target.parent.setBlack();//parent为黑，子节点为两个红
            if(target.isLeft()){
                target.parent.right.setRed();
            }else{
                target.parent.left.setRed();
            }
            root.parent=null;
        }


    }

    /****
     *
     * @param p
     */
    public void rotateRight(Node p){

        if(p!=null) {

            Node l = p.left;
            p.left = l.right;
            if (l.right != null) l.right.parent = p; //设置parent节点
            l.parent=p.parent;
            if(p.isRoot()){//如果p是root
                root=l;
            }else if(p.isRight()){
                p.parent.right=l;//如果p原来是父的右孩子，就得把新的l接到原来p.parent.right
            }else if(p.isLeft()){
                p.parent.left=l;//如果p原来是父的左孩子，就得把新的l接到原来p.parent.right
            }
            l.right=p;//设置右孩子
            p.parent=l;//设置父节点
        }

    }


    public void rotateLeft(Node target){
        if(target!=null){
            Node right=target.right;
            if(target.isRoot()){

            }






        }
    }

    private void setRoot(Node target){
        root=target;
        if(target!=null){
            root.setBlack();
        }
    }

//    private void replace(Node target, Node replacement) {
//        if (target.isRoot()) {
//            setRoot(replacement);
//        } else {
//            if (target.getLeft()) {//左孩子
//                target.parent.left = replacement;
//            } else {
//                target.parent.right = replacement;
//            }
//        }
//        if (replacement != null) {
//            replacement.parent = target.parent;
//        }
//    }


    public void recolor(Node target){
        if(target.isRoot()){
            target.setBlack();
            return;
        }
        //进来该方法的targe的颜色一定是红色的，所以不需要在判断
        //recolor方法会调用递归多次，需要需要判断父节点是否为黑色，黑色不需要进行染色处理
        if(target.parent.isBlack()){
            return;
        }

        //走到这里targe.parent 肯定是红色的

        Node uncle=target.uncle();
        //
        if(uncle!=null && uncle.isRed()){
            target.parent.setBlack();
            uncle.setBlack();
            Node grandParent=target.grandParent();
            //能进到这个方法，肯定grandParent不为null，取uncle的时候判断了
            grandParent.setRed();
            recolor(grandParent);//递归变色
        }else {
            //走到这里，说明是本身是红色，父节点是红色，叔叔为黑，连续的双红，需要做修正
            addFixTree(target);
        }
    }

    public static void main(String[] args) {

        RBTree rbTree=new RBTree();
        rbTree.add(4,41);
        rbTree.add(5,51);
        rbTree.add(3,31);
        rbTree.add(2,21);
        rbTree.add(1,21);


        System.out.println("12");
    }





    public Object remove(Comparable key) {
        return null;
    }


    public Object lookup(Comparable key) {
        return null;
    }


    public String toPrettyString() {
        return null;
    }

    class Node{

        private K key;

        private V data;

        private Node left;

        private Node right;

        private Node parent;

        private boolean color;

        public Node(){
            this.key=null;
            this.data=null;
            this.color=BLACK;//新添加的Node的节点颜色为黑色
        }

        public Node(K key,V data,boolean color){
            this.key=key;
            this.data=data;
            this.color=color;
            this.left =new Node();
            this.right =new Node();
        }

        public boolean hasRightChild(){
            if(this.right !=null){ return true; }
            return false;
        }

        public boolean isLeft(){
            if(this.parent.left ==this)  {return true;}
            return false;
        }

        public boolean isRight(){
            if(this.parent.right ==this)  {return true;}
            return false;
        }

        //找爷爷节点
        public Node grandParent(){
            if(parent!=null){
                return parent.parent;
            }
            return null;
        }

        public boolean isRoot(){
            return parent==null;
        }

        public boolean isBlack(){
            return this.color==BLACK;
        }

        public boolean isRed(){
            return this.color==RED;
        }

        public void setBlack(){
            this.color=BLACK;
        }

        public void setRed(){
            this.color=RED;
        }

        // 找叔叔节点
        public Node uncle(){
            Node grandParent=grandParent();
            if(grandParent==null){
                return null;
            }else if(parent==grandParent.left){
                return grandParent.right; //父节点是左，那么父节点的右边是叔叔节点
            }else {
                return grandParent.left; // 父节点本身是右，那么父节点的左边是叔叔节点
            }
        }





        public int compareTo(Node node){
            return this.key.compareTo(node.key);
        }

        public String nodeColor(){
            String color="";
            if(this==null||this.color==BLACK){
                color="B";
            } else if(this.color==RED){
                color="R";
            }
            return color;
        }


        @Override
        public String toString() {

            String retString="";
            if(this.key==null){
                retString ="nil";
            }else{
                retString=this.key+"="+nodeColor();
            }

            return retString;
        }
    }



}
