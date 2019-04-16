package data_structure.binary_tree;

/****
 * 红黑树代码实现
 * https://github.com/jrviray/CS_480_Project_06/blob/master/src/cpp/edu/cs480/project06/RedBlackTree.java
 * https://github.com/mckeeh3/red-black-tree/blob/master/src/main/java/RedBlackTree.java
 * https://www.geeksforgeeks.org/red-black-tree-set-2-insert/
 * https://www.cs.usfca.edu/~galles/visualization/RedBlack.html
 * @param <K>
 * @param <V>
 */
public class RBTree<K extends  Comparable<K>,V>   {
    private final static boolean RED = true;
    private final static boolean BLACK = false;

    private Node<K,V> root;

    private String prettyString;


    public void add(K key, V value) {

        Node<K,V> current=root;
        Node<K,V> parent=null;

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
            if(target.parent.isLeft()&&target.isLeft()){
                  leftLeftCase(target);//只右旋 10 7 18  5 3
            }else if(target.parent.isLeft()&&target.isRight()){
                  leftRightCase(target);//先左旋，然后右旋 10 7 18  5 6
            }else if(target.parent.isRight()&&target.isRight()){
                  rightRightCase(target);//只左旋 5 4 9 10 11
            }else if(target.parent.isRight()&&target.isLeft()){
                  rightLeftCase(target);//先右旋，然后左旋 5 4 9 12 10
            }


        }

    }

    public void leftRightCase(Node target){
         rotateLeft(target.parent);//左旋
         rotateRight(target.parent);//右旋
         target=target.left;
         rotateColor(target);

    }


    public void rightLeftCase(Node target){
        rotateRight(target.parent);//右旋
        rotateLeft(target.parent);//左旋
        target=target.right;
        rotateColor(target);
    }

    public void leftLeftCase(Node target){
         //左-左的情况，是需要右旋，右旋的节点是该节点的爷爷节点做为参照，具体见：https://www.geeksforgeeks.org/c-program-red-black-tree-insertion/
        rotateRight(target.grandParent());
        rotateColor(target);
    }

   public void  rotateColor(Node target){
       //变色
       if(target.isRed()&&target.parent.isRed()){
           target.parent.setBlack();//parent为黑，子节点为两个红
           if(target.isLeft()){
               target.parent.right.setRed();
           }else{
               target.parent.left.setRed();
           }
           root.parent=null;
       }
    }

    public void rightRightCase(Node target){

        rotateLeft(target.grandParent());
        rotateColor(target);

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
            }else {
                p.parent.left=l;//如果p原来是父的左孩子，就得把新的l接到原来p.parent.right
            }
            l.right=p;//设置右孩子
            p.parent=l;//设置父节点
        }

    }


    public void rotateLeft(Node p){

        if(p!=null){
            Node r=p.right;
            p.right=r.left;
            if(r.left!=null){
                r.left.parent=p;
            }
            r.parent=p.parent;
            if(p.isRoot()){
                root=r;
            }else if(p.isLeft()){
                p.parent.left=r;
            }else  {
                p.parent.right=r;
            }
            r.left=p;
            p.parent=r;
        }





    }

    private void setRoot(Node target){
        root=target;
        if(target!=null){
            root.setBlack();
        }
    }



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

    public void inorder(Node root) {
        if (root.key == null) {
            return;
        }
        inorder(root.left);

        System.out.println(root.key);

        inorder(root.right);

    }

    /***
     * 根据key搜索指定节点
     * @param k
     * @return
     */
    public Node<K,V> search(K k){
        Node<K,V> p=root;
        while (p.key!=null){
            int cmp=k.compareTo(p.key);
            if(cmp<0){
                p=p.left;
            }else if(cmp>0){
                p=p.right;
            }else {
                return p;
            }
        }
        return null;
    }


    public Node<K,V> successor(Node<K,V>  t){
            //找到右子树里面找到最小的
            Node<K,V> p=t.right;
            while (p.left.key!=null){
                p=p.left;
            }
            return p;
    }


    public void delete(K k){

    Node<K,V> p=search(k);
    if(p==null){ return;}

    if(p.left.key!=null&&p.right.key!=null){//拥有2个孩子节点
        Node<K,V> s=successor(p);//找到后继
        p.key=s.key; //改变p的key为s.key
        p.data=s.data;//改变p的data为s.data
        //注意上面是指针传递，所以p的内容已经被修改
        p = s;//这里又把s.内存地址赋值给p，对p上一个的内容的不会产生影响
    }
    //获取需要被替换掉的节点
    Node<K,V> replacement=p.left.key!=null?p.left:p.right;

    if(replacement!=null){
        //去掉找到的p
        replacement.parent=p.parent;

        //连接p.parent和末尾的节点
        if(p.parent==null){
            root=replacement;
        }else if(p.isLeft()){
            p.parent.left=replacement;
        }else{
            p.parent.right=replacement;
        }

        //p节点的所有的引用置为null，方便gc
        p.left=p.right=p.parent=null;
        //如果删除的是黑色节点，就会导致不平衡，所以需要修复
        if(p.isBlack()){
            fixAfterDeletion(replacement);
        }

    }else  if(p.parent==null){
            root=null;
    }else {//没有两个孩子，只有单个孩子，直接用父的引用直接其后面的即可
        if(p.isBlack()){
            fixAfterDeletion(p);//删掉的是黑色就得做均衡
        }

        if(p.parent!=null){
            if(p.isLeft()){
                p.parent.left=new Node<>();
            }else if(p.isRight()){
                p.parent.right=new Node<>();
            }
            p.parent=null;
        }

    }

    }

    private void fixAfterDeletion(Node<K,V> x){

        while (x!=root&&x.isBlack()){

            if(x.isLeft()){
                Node<K,V> sib=x.parent.right;
                if(sib.isRed()){//如果x的兄弟节点是红色
                    sib.setBlack();//给x的兄弟设置成黑色
                    x.parent.setRed();//给他们的父节点设置成红色
                    rotateLeft(x.parent);//左边删除了，所以左边少节点，需要左旋
                    sib=x.parent.right;//新的兄弟节点
                }
                //如果兄弟节点的孩子都是黑色，需要将其设置成红色
                if(sib.left.isBlack()&&sib.right.isBlack()){
                    sib.setBlack();
                    x=x.parent;//继续向上遍历修复
                }else {
                    if(sib.right.isBlack()){
                        //兄弟的右边是黑色，左边是红色
                        sib.left.setBlack();//需要将其左边设置黑色
                        sib.setRed();//sib父节点设置成红色
                        rotateRight(sib);//右旋
                        sib=x.parent.right;

                    }
                    sib.color=x.parent.color;
                    x.parent.setBlack();
                    sib.right.setBlack();
                    rotateLeft(x.parent);
                    x=root;
                }

            }else{
                //与if里面相反的逻辑
                Node<K,V> sib=x.parent.left;
                if(sib.isRed()){
                    sib.setBlack();
                    x.parent.setRed();
                    rotateRight(x.parent);
                    sib=x.parent.left;
                }

                if(sib.right.isBlack()&&sib.left.isBlack()){
                    sib.setRed();;
                    x = x.parent;
                }else {

                    if(sib.left.isBlack()){
                        sib.right.setBlack();
                        sib.setRed();;
                        rotateLeft(sib);
                        sib=x.parent.left;
                    }
                    sib.color=x.parent.color;
                    x.parent.setBlack();
                    sib.left.setBlack();
                    rotateRight(x.parent);
                    x=root;
                }

            }

        }
      x.setBlack();
    }




    public static void main(String[] args) {

        RBTree<Integer,Integer> rbTree=new RBTree();
//        rbTree.add(30,5);
        rbTree.add(20,4);
        rbTree.add(10,9);
        rbTree.add(30,10);
        rbTree.add(25,10);
        rbTree.add(35,10);
        rbTree.delete(20);
        rbTree.inorder(rbTree.root);

//        System.out.println(rbTree.search(1));


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

    class Node<K extends  Comparable<K>,V>{

        private K key;

        private V data;

        private Node<K,V> left;

        private Node<K,V> right;

        private Node<K,V> parent;

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





        public int compareTo(Node<K,V> node){
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
