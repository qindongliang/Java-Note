package leetcode.easy.math;

/****
 *https://leetcode.com/problems/complement-of-base-10-integer/
 *
 * 待验证
 *
 *
 *
 */
public class ComplementBaseInteger {

    public int bitwiseComplement(int N) {
        int X = 1;
        while (N > X) X = X * 2 + 1;
        return X - N;
    }

}
