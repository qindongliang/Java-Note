package leetcode.easy.math;

import java.util.Arrays;

/****
 * https://leetcode.com/problems/largest-perimeter-triangle/
 *
 * 给定一个int数组，求出这里面任意的三个数字能组成的三角形的最大周长。
 *
 * 原理：如果数字 a >= b >= c, a,b,c 可以得到一个三角形， 如果 a < b + c.
 *
 * 思路：
 *
 * 1，排序数组
 * 2，试着检查连续的三个数字能否组成一个三角形
 * 3，如果 A[n-1] < A[n-2] + A[n-3]，我们可以得到一个三角形
 * 4，如果A[n-1] >= A[n-2] + A[n-3] ，这个不满足三角形的条件
 *
 */
public class LargestPerimeterTriangle {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        //倒序遍历计算
        for (int i = A.length-1; i >1 ; i--) {
            //A[i]一定是最大的
            if(A[i]<A[i - 1] + A[i - 2]){
             return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

}
