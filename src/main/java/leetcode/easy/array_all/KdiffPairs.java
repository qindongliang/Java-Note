package leetcode.easy.array_all;

import java.util.HashMap;
import java.util.Map;

/****
 *
 * 题目描述：https://leetcode.com/problems/k-diff-pairs-in-an-array/
 * 给定一个int数组，并给定一个数字k，然后求出这个数组里面，有多少对唯一的两个数字
 * 相减的和等于k，返回这个数字。
 * 例如：[3, 1, 4, 1, 5], k = 2
 * 这里面返回的就2对，（1，3）和 （3，5）
 */
public class KdiffPairs {

    public static int findPairs(int[] nums, int k) {

        if(nums==null||nums.length==0||k<0) return 0;

        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for (int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> kv:map.entrySet()){
            if(k==0){
                if(kv.getValue()>=2){
                    count++;
                }
            }else {
                if(map.containsKey(kv.getKey()+k)){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int arr[]={1, 3, 1, 5, 4};
        int k=0;
        System.out.println(findPairs(arr,k));

    }
}
