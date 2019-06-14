package leetcode.medium.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/****
 *
 * 题目连接：https://leetcode.com/problems/reveal-cards-in-increasing-order/
 * 题目描述：
 * 给定一个int数组，模拟成一副扑克牌，对其排完序之后，取第一张，然后把第二张
 * 放回底部，依次类推，最终变成另外一种顺序
 *
 */

public class RevealCardsIncreasingOrder {

    public static int[] deckRevealedIncreasing(int[] deck) {

        int n=deck.length;
        Arrays.sort(deck);//排序

        Queue<Integer> q=new LinkedList<Integer>();
        //顺序插入下标
        for (int i = 0; i < n; i++) {
            q.add(i);
        }

        int []res=new int[n];
        //遍历整个index
        for (int i = 0; i < n; i++) {
            //结果数组[index]=依次从排序好的集合里面取数
            int poll=q.poll();
            System.out.println(poll);
            res[poll]=deck[i];//取出头部
            q.add(q.poll());//将第二排在尾部
        }

    return res;
    }


    public static void main(String[] args) {

        int arr[]={17,13,11,2,3,5,7};
        //2,3,5,7,11,13,17

        int  result[]=deckRevealedIncreasing(arr);

        System.out.println(Arrays.toString(result));

    }
}
