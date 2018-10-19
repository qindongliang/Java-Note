package data_structure.binary_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/****
 * 构建堆的特点：
 * （1）符合完全二叉树的定义，最底的一层可以缺少节点，并新增的集中在左边，此外其他的层必须都是满的
 * （2）任意父节点的值，是左右子树的最大值,此外左右孩子的大小关系不做任何要求
 * （3）可以采用数组实现
 * （4）已知父节点i的位置，那么 左孩子=2*i，右孩子=2*i+1
 * （5）已知左节点/右节点的位置i，那么父节点位置=i/2 注意结果是向下取整
 */
public class MinHeap {

     List<Integer> minHeap;

    public MinHeap() {
        this.minHeap = new ArrayList<Integer>();
        minHeap.add(0,null);
    }

    /***
     * 维持一个容量固定的topN队列
     * @param n
     */
    public void topN(int n){
        List<Integer> topN=new ArrayList<>();
        topN.add(0,null);
        n=Math.min(3, minHeap.size()-1);
        for(int i=1;i<=n;i++){
            topN.add(getMinValue());
            delete(getMinValue());
        }
        this.minHeap =topN;

    }

    public void insert(Integer value){
        //新插入的元素，放在数组最后，保持完全二叉树的特性
        minHeap.add(value);

        //获取最后一个元素在数组中的索引位置，从1开始
        int index= minHeap.size()-1;
        //父节点的位置
        int parentIndex=index/2;



        //在数组范围内，比较这个插入值和其父节点的大小关系，大于父节点则用父节点替换当前值
        //index位置上升
        while (index>1){

            int parent= minHeap.get(parentIndex);//获取父节点的值

            if(compare(value,parent)>=0){
                break;
            }else{
                //如果当前的值大于父节点的值，就把父节点的值，赋值给当前节点
                minHeap.set(index,parent);

                index=parentIndex;//改变index的位置
                parentIndex=index/2;//改变父节点的位置

            }


        }
        //把新加入的值，放到其合适的位置
        minHeap.set(index,value);
    }


    public Integer getMinValue(){
        if (minHeap.size()==1){
            System.out.println("当前是空堆");
             return  null;
        }else{
            return minHeap.get(1);
        }
    }

    /***
     *
     * @param a
     * @param b
     * @return 负数代表小于，0代表等于，正数代表大于
     */
    private int compare(Integer a,Integer b){
        return a.compareTo(b);
    }






    public static void main(String[] args) {

        //维护一个topN的最大值
        MinHeap maxHeap=new MinHeap();
        maxHeap.insert(1);
        maxHeap.insert(92);
        maxHeap.insert(11);
        maxHeap.insert(58);
        maxHeap.insert(41);
        maxHeap.insert(2);
        maxHeap.insert(-1);
        maxHeap.insert(120);

        maxHeap.topN(3);//取最小的top3
//        System.out.println(minHeap.minHeap);
        System.out.println(maxHeap.getMinValue());
//
//        System.out.println("================最大堆排序==================");
//
        maxHeap.heapSort();



    }

    public  void  heapSort(){
        int []sorted=new int[minHeap.size()-1];
        int count=0;
        for (int k = 1; k <=sorted.length; k++) {
            int maxValue=getMinValue();
            sorted[count++]=maxValue;
            delete(maxValue);
//            System.out.println(minHeap);
        }
        System.out.println(Arrays.toString(sorted));
    }


    /***
     * 堆的任意值的删除
     * @param value
     * @return
     */
    public boolean delete(Integer value){

       if(minHeap.isEmpty()){
           return false;
       }

       int index = minHeap.indexOf(value);
       if(index==-1){return  false;}

       int lastIndex= minHeap.size()-1;

       //得到最后一个元素的值
       Integer temp= minHeap.get(lastIndex);
       minHeap.set(index,temp);//用最后一个元素的值，替换被删除的位置

       int parent;

       for(parent=index; parent*2<= minHeap.size()-1; parent=index){

           //当前节点左孩子的下标
           index=parent*2;
           //如果左节点不是最后一个元素，就说明一定有右子树，同时比较，左右子树，
           if(index!= minHeap.size()-1 && compare(minHeap.get(index), minHeap.get(index+1))>0){
                //如果能够进入这个方法体，说明右孩子比左孩子大，所以index更新
               index=index+1;
           }

           if(compare(temp, minHeap.get(index))<0){
               //进入这个循环体，说明当前堆顶元素，大于右孩子
               //也就是说大于左右孩子，则不用调整，直接退出;
               break;
           }else{
               // 子树上移，替换当前节点
               minHeap.set(parent, minHeap.get(index));
           }

       }
        //parent的值归位
        minHeap.set(parent,temp);
        minHeap.remove(lastIndex);//删除最后一个无用的元素

      return true;
    }





}
