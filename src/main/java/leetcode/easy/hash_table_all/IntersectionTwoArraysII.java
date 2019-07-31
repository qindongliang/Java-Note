package leetcode.easy.hash_table_all;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 *
 * 求两个数组的交集2
 *
 */
public class IntersectionTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map=new HashMap<>();
        int maxSize=Math.min(nums1.length,nums2.length);

        int []result=new int[maxSize];
        int size=0;

        for(int i:nums1){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for (int i:nums2){
            if(map.getOrDefault(i,0)>0){
                result[size++]=i;
                map.put(i,map.get(i)-1);
            }
        }

        return Arrays.copyOf(result,size);
    }

    public static void main(String[] args) {

    }
}
