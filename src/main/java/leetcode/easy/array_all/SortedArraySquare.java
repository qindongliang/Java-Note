package leetcode.easy.array_all;

import java.util.Arrays;

/***
 *
 *  问题连接：https://leetcode.com/problems/squares-of-a-sorted-array/discuss/221922/Java-two-pointers-O(N)
 *
 *  问题描述： 对于一个排序好的从小到大的数组，要对每一个数做完平方后再对整个数组重新排序。
 *
 *  解决思路：
 *
 *  由于包含负数，我们可以用双指针的方式，对首尾的数开始遍历判断，通过求绝对值，肯定有一个是最大的值，然后我们判断出来哪一个大，然后通过首尾进行替换位置即可，直接把结果放在返回的数组里面，
 *  直到遍历结束，就排好序了，总体耗时O(n)复杂度
 *
 */
public class SortedArraySquare {

    public static int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(sortedSquares( new int[]{-4,-1,0,3,10})));

    }

}
