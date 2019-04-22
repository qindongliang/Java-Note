package data_structure.skip_list;

import java.util.Random;

/***
 * 采用数组实现的跳跃表
 */
public class SkipListUseArray {


    public class Node{

        private int value;
        private Node next[];//指向下一个节点
        private int level;//跨越几层

        public Node(int value, int level ){
            this.value=value;
            this.level=level;
            this.next=new Node[level];
        }

        @Override
        public String toString() {
            StringBuilder sb=new StringBuilder();
            sb.append("value:").append(value);
            sb.append(" levels:").append(level);
            return sb.toString();
        }
    }



    private static final int MAX_LEVEL=16;

    private int levelCount=1;

    private Node head=new Node(-1,MAX_LEVEL);//声明头部节点，充当辅助

    private Random random=new Random();

    int size=0;



    /***
     * 通过奇偶数的方式来生成随机生成层级
     * @return
     */
    private int getLevel(){
        int level=1;
        while (true){
            int r=random.nextInt();
            if(r%2==0){
                level++;
            }else {
                break;
            }
        }
        System.out.println("本次生成的level："+level);
        return level;
    }

    public void insert(int value){

        int level=getLevel();
        //新生成的节点
        Node newData=new Node(value, level);
        //update用于记录要插入的节点的前驱
        Node update[]=new Node[level];

        Node temp=head;

        for (int i = level-1; i >=0 ; i--) {
            while (temp.next[i]!=null&&temp.next[i].value <value){
                temp=temp.next[i];
            }
            update[i]=temp;
        }

        //把新增的节点，加到前驱节点的后面即可
        for (int i = 0; i < level; i++) {
            newData.next[i]=update[i].next[i];
            update[i].next[i]=newData;
        }

        if(levelCount<level){
            levelCount=level;
        }

        size++;
    }



    public Node find(int value){
        Node p=head;
        //从高到底按层级搜索
        for (int i = levelCount-1; i >=0; i--) {
            while (p.next[i]!=null&&p.next[i].value <value){
                p=p.next[i];
            }
        }
        //最后找到的节点，判断下是否等于输入的然后就返回
        if(p.next[0]!=null&&p.next[0].value ==value){
            return p.next[0];
        }else{
            return null;
        }
    }

    public void delete(int value){
        Node[] update=new Node[levelCount];
        Node p=head;
        //找到所有查询value的前驱节点
        for (int i = levelCount-1; i >=0 ; i--) {
            while (p.next[i]!=null&&p.next[i].value <value){
                p=p.next[i];
            }
            update[i]=p;
        }

        if(p.next[0]!=null&&p.next[0].value ==value){
            size--;
            for (int i = levelCount-1; i >=0 ; i--) {
                if(update[i].next[i]!=null&&update[i].next[i].value ==value){
                 //设置当前节点的后缀的等于删除的后缀即可
                update[i].next[i]=update[i].next[i].next[i];
                }
            }
        }
    }





    public void printAll(){
        Node p=head;
        while (p.next[0]!=null){
            System.out.println(p.next[0]+" ");
            p=p.next[0];
        }
    }


    public static void main(String[] args) {

        SkipListUseArray list=new SkipListUseArray();

        list.insert(10);
        list.insert(12);
        list.insert(14);
        list.insert(20);
        list.insert(8);
        list.insert(7);
        list.insert(3);
        list.insert(1);



//        System.out.println(list);
        list.printAll();

        list.find(8);

    }









}
