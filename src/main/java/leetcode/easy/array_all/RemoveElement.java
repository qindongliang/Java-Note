package leetcode.easy.array_all;

import java.util.Arrays;

/****
 * https://leetcode.com/problems/remove-element/
 *
 * 题目描述：给定一个数组，然后给定一个值，
 * 要求不分配额外的空间，删除这个值的数据，然后在原数组里面返回新的数组，并且返回新数组的长度
 *
 * 如：Given nums = [3,2,2,3], val = 3,
 *
 * 删除3，3之后，返回新数组等于[2，2，3，3] ，len=2即可。
 *
 * 解题思路：
 *
 * 循环遍历整个数组，遇到不等于val的值，直接将其移动到数组的首位，然后计数器加一，
 * 直到遍历结束，所有不等于val的数值，其实都被移动到数组的前面了，这部分
 * 数据，就是我们需要的结果。
 *
 */

public class RemoveElement {

    public static int removeElement(int[] A, int elem) {

        System.out.println(Arrays.toString(A));
        int m = 0;
        for(int i = 0; i < A.length; i++){

            if(A[i] != elem){
                A[m] = A[i];
                m++;
            }
        }

        System.out.println(Arrays.toString(A));

        return m;
    }

    public static void main(String[] args) {
//     int arr[]= {3,2,2,3};
     int arr[]= {0,1,2,2,3,0,4,2};

        System.out.println(removeElement(arr,2));
    }
}
