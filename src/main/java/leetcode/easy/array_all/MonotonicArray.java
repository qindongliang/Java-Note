package leetcode.easy.array_all;

/***
 * 判断一个数组序列，是否为单调的递增或者递减序列
 * https://leetcode.com/problems/monotonic-array/
 * https://leetcode.com/problems/monotonic-array/discuss/207057/4-lines-beats-99
 */
public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        int inc=1;
        int dec=1;
        for (int i = 1; i <A.length ; i++) {

            int diff=A[i]-A[i-1];
            if(diff>0){
                inc++;
            }else if(diff<0){
                dec++;
            }else { // equals
                inc++;dec++;
            }
        }

        return inc==A.length||dec==A.length;
    }


    public boolean isMonotonic2(int[] A) {
        boolean inc=true;
        boolean dec=true;
        for (int i = 1; i <A.length ; i++) {
            inc&=A[i]>=A[i-1];
            dec&=A[i]<=A[i-1];
        }

        return inc||dec;
    }





}
