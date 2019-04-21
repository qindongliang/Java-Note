package data_structure.skip_list;

import java.util.Random;

/***
 * 采用数组实现的跳跃表
 */
public class SkipListUseArray {


    private static final int MAX_LEVEL=16;

    private int levelCount=1;

    private Node head=new Node();//声明头部节点

    private Random random=new Random();


    /***
     * 通过奇偶数的方式来决定随机节点的位置
     * @return
     */
    private int randomLevel(){
        int level=1;
        for (int i=1;i<MAX_LEVEL;i++){
            if(random.nextInt()%2==1){
                level++;
            }
        }
        return level;
    }


    public Node find(int value){
        Node p=head;
        for (int i = levelCount-1; i >=0; i--) {
            while (p.forwards[i]!=null&&p.forwards[i].data<value){
                p=p.forwards[i];
            }
        }
        if(p.forwards[0]!=null&&p.forwards[0].data==value){
            return p.forwards[0];
        }else{
            return null;
        }
    }

    public void delete(int value){
        Node[] update=new Node[levelCount];
        Node p=head;
        for (int i = levelCount-1; i >=0 ; i--) {
            while (p.forwards[i]!=null&&p.forwards[i].data<value){
                p=p.forwards[i];
            }
            update[i]=p;
        }

        if(p.forwards[0]!=null&&p.forwards[0].data==value){
            for (int i = levelCount-1; i >=0 ; i--) {
                if(update[i].forwards[i]!=null&&update[i].forwards[i].data==value){
                update[i].forwards[i]=update[i].forwards[i].forwards[i];
                }
            }
        }
    }


    public void insert(int value){

        int level=randomLevel();
        Node newData=new Node();

        newData.data=value;
        newData.maxLevel=level;

        Node update[]=new Node[level];

        for (int i = 0; i <level ; i++) {
            update[i]=head;
        }

        Node p=head;

        for (int i = level-1; i >=0 ; i--) {
            while (p.forwards[i]!=null&&p.forwards[i].data<value){
                p=p.forwards[i];
            }
            update[i]=p;
        }


        for (int i = 0; i < level; i++) {
            newData.forwards[i]=update[i].forwards[i];
            update[i].forwards[i]=newData;
        }

        if(levelCount<level){
            levelCount=level;
        }


    }


    public void printAll(){
        Node p=head;
        while (p.forwards[0]!=null){
            System.out.println(p.forwards[0]+" ");
            p=p.forwards[0];
        }
    }


    public static void main(String[] args) {

        SkipListUseArray list=new SkipListUseArray();
        list.insert(4);
        list.insert(41);
        list.insert(23);
        list.insert(8);
        list.insert(2);
        list.insert(6);


//        System.out.println(list);
        list.printAll();

        list.find(8);

    }





    public class Node{

        private int data=-1;
        private Node forwards[]=new Node[MAX_LEVEL];

        private int maxLevel=0;

        @Override
        public String toString() {
            StringBuilder sb=new StringBuilder();
            sb.append("data:").append(data);
            sb.append(" levels:").append(maxLevel);
            return sb.toString();
        }
    }




}
