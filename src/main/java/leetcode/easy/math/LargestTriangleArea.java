package leetcode.easy.math;

/****
 *
 * https://leetcode.com/problems/largest-triangle-area/
 *
 * 给定一系列的点，求出任意三个点里面组成的三角形的面积最大
 *
 *
 */
public class LargestTriangleArea {

    public double largestTriangleArea(int[][] p) {
        double res = 0;
        for (int[] i: p)
            for (int[] j: p)
                for (int[] k: p)
                    res = Math.max(res, 0.5 * Math.abs(i[0] * j[1] + j[0] * k[1] + k[0] * i[1]- j[0] * i[1] - k[0] * j[1] - i[0] * k[1]));
        return res;
    }

}
