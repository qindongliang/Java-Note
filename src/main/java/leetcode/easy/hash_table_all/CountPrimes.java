package leetcode.easy.hash_table_all;

/****
 *
 * https://leetcode.com/problems/count-primes/
 *
 * 给定一个数字n，求在n之内这个范围内素数的个数
 *
 */
public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            //统计素数的的个数
            if (notPrime[i] == false) {
                count++;
                //把合数置为true
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
