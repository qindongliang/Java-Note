package leetcode.easy.hash_table_all;

/****
 *
 * 在一个长度2N的数组中，有一个数字重复了N次，其他数字都不重复
 *找出这个重复的数字
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 */
public class Size2NElement {


    public int repeatedNTimes1(int[] A) {

        int[] count = new int[10000];

        for (int num : A) {
            if (count[num]++ == 2) {
                return num;
            }
        }

        return -1;
    }


    public int repeatedNTimes(int[] A) {

        int[] a = new int[10000];

        for (int i = 0; i < A.length; i++) {
            a[A[i]]++;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] >= A.length / 2) {
                return i;
            }
        }
        return 0;
    }
}
