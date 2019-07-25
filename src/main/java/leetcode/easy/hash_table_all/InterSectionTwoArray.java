package leetcode.easy.hash_table_all;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/****
 *
 *https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * 给定两个数组，求交集
 */
public class InterSectionTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> numbers=new HashSet<>();

        for (int n:nums1) numbers.add(n);

        int []res=new int[numbers.size()];

        int cursor=0;
        for (int n:nums2){
            //如果nums2包含同样的节点，返回true
            if(numbers.remove(n)){
                res[cursor++]=n;
            }
        }
        return Arrays.copyOfRange(res,0,cursor);
    }


    public static void main(String[] args) {

    }

}
