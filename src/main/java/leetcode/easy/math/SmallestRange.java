package leetcode.easy.math;

/***
 *
 *https://leetcode.com/problems/smallest-range-i/
 *
 * no
 *
 * If min(A) + K < max(A) - K, then return max(A) - min(A) - 2 * K
 * If min(A) + K >= max(A) - K, then return 0
 *
 */
public class SmallestRange {

    public int smallestRangeI(int[] A, int K) {

        int mx=A[0];
        int mn=A[0];
        for (int a:A){
            mx=Math.max(mx,a);
            mn=Math.min(mn,a);
        }
        return Math.max(0,mx-mn-2*K);

    }

}
