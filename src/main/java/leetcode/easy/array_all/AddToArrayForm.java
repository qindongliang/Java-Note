package leetcode.easy.array_all;

import java.util.LinkedList;
import java.util.List;

/***
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 *
 * 题目描述：给定非负整数x，以数组的形式表示，表示顺序由左到右。
 *
 * 例子数字1231，用数组表示就是[1,2,3,1]
 * 现在在给一个整数K，要求以数组的形式返回x+K的结果
 * 比如[1,2,0,0] + 34  应该返回[1,2,3,4]
 *
 *
 */
public class AddToArrayForm {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        //声明一个链表来存储结果
        List res=new LinkedList();
        //从数组的末尾向前遍历
        int i=A.length-1;
        //用于保存每位数字相加和溢出部分的数值，也就是大于10进位
        int carry=0;
        //三个条件限制循环
        while (i>=0||K>0||carry>0){
            //倒序取数组里面的数字，最小为0
            int a=i>=0?A[i--]:0;
            //取K的每一位，通过取模来依次得到
            int b=K%10;
            //K缩减范围
            K=K/10;
            //计算每一位相加
            int sum=a+b+carry;
            //得到溢出位，如果有
            carry=sum/10;
            //添加每个左边位数字
            res.add(0,sum%10);
        }
        //返回结果
        return res;
    }

    public static void main(String[] args) {
        int arr[]={9,9,9,9,9,9,9,9,9,9};
        int k=1;

        System.out.println(addToArrayForm(arr,k));
    }

}
