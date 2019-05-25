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

    /****
     * 下面的这种方法，相比前面两种，在非递增的时候可以快速失败，
     * 所以性能略好
     * @param A
     * @return
     */
    public boolean isMonotonic3(int[] A) {
        int direction=A[0]<=A[A.length-1]?-1:1;
        //升序=-1，降序 = 1
        for (int i = 0; i < A.length-1; i++) {

            //如果是升序，那么下面的函数必定是负负得正>=0，所以一直执行
            //如果出现一个降序的，就会变成正负得负，所以直接返回非单调

            //如果方向是降序，那么下面的函数必定是正正得正>=0，所以一直执行
            //如果出现一个升序的，就会变成负正得负<0，所以直接返回非单调

           if( (A[i]-A[i+1])*direction<0 ){
               return false;
           }
        }

        return  true;
    }



}
