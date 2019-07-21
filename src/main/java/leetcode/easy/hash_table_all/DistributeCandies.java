package leetcode.easy.hash_table_all;

import java.util.HashSet;
import java.util.Set;

/****
 *
 * https://leetcode.com/problems/distribute-candies/
 *
 * 给定一个偶数长度的数组，假设是一堆糖果，现在要求平均分配给弟弟和妹妹，
 * 每一个数组的数字代表一种糖果，现在要求求出弟弟能获得不同糖果的最大类型
 *
 */
public class DistributeCandies {

    public int distributeCandies(int[] candies) {

        int total = candies.length;
        Set<Integer> kinds = new HashSet<Integer>();
        for (int i = 0; i < total; i++) {
            kinds.add(candies[i]);
        }
        if (kinds.size() > total / 2) {
            return total / 2;
        } else {
            return kinds.size();
        }


    }

    public static void main(String[] args) {

    }

}
