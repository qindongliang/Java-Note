package leetcode.easy.math;

import java.util.Arrays;

/****
 *
 *
 *https://leetcode.com/problems/distribute-candies-to-people/
 *
 * 分糖果，拿着指定数量的糖果，分给n个人，第一个人分1个，第二个人分2个，第n个人分n个
 * 依次类推，直到把所有的糖果分完，求出每个人分糖果的数量。
 *
 */
public class DistributeCandiesToPeople {


    public static int[] distributeCandies(int candies, int num_people) {

        int res[]=new int[num_people];

        for (int i = 0; candies>0 ; i++) {
            res[i%num_people]+=Math.min(candies,i+1);
            candies=candies-(i+1);
        }

        return res;
    }

    public static void main(String[] args) {


        System.out.println(Arrays.toString(distributeCandies(10,3)));


    }

}
