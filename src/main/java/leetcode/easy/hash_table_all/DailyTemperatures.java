package leetcode.easy.hash_table_all;

import java.util.Stack;

/****
 *
 *
 *https://leetcode.com/problems/daily-temperatures/
 *
 * 给定一个代表温度的数组，现在让求出数组里面的每一天的温度，距离下一次温暖的天的中间间隔是多少。
 *
 * 思路：采用栈来保存，每一天的数据，然后取最新的与前面的每一个一次比较，求出距离，并设置。
 */

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack=new Stack<>();
        int []ret=new int[T.length];//初始化结果数组
        for (int i = 0; i < T.length; i++) {
            //栈里面必须有数据且最新的这个值要大于历史上最大的那个
            while (!stack.isEmpty()&&T[i]>T[stack.peek()]){
                //取出这条数据
                int idx=stack.pop();
                //设置该位置上的计算的距离最高温度的天数是多少
                ret[idx]=i-idx;
            }
            //入栈
            stack.push(i);
        }
        //返回结果集
        return ret;

    }

    public static void main(String[] args) {

    }
}
