package leetcode.easy.array_all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/****
 *https://leetcode.com/problems/degree-of-an-array/
 *
 * 题目描述：
 *
 * 给定一个非负，非空的数组，找到该数组里面，词频最大的数字就是该数组的度
 * 然后，在连续的子数组里面，找到子数组长度最小的那个，并返回其的度。
 *
 *
 * 思路：
 *
 * 用一个Map+List，
 *
 * 第一步先遍历数组，进行分组，并存储数字相同的元素的下标
 *
 * 第二步，进行遍历找到词频最大的度。
 *
 * 第三步，使用子数组里面的最后的元素减去第一个元素得到的值，比较大小，并取
 * 最小也就是最短的那个。
 *
 *
 */
public class DegreeArray {


    public static int findShortestSubArray(int[] nums) {
        Map<Integer, ArrayList<Integer>> map=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                ArrayList<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(nums[i],list);
            } else{
                map.get(nums[i]).add(i);
            }
        }


        int count=0;

        for(Map.Entry<Integer,ArrayList<Integer>> kv:map.entrySet()){
            ArrayList<Integer> value=kv.getValue();
            if(value.size()>count){
                count=value.size();
            }
        }

        int min=nums.length;

        for (Map.Entry<Integer,ArrayList<Integer>> kv:map.entrySet()){
            ArrayList<Integer> value=kv.getValue();

            if(value.size()==count){
                int len=value.get(value.size()-1)-value.get(0)+1;

                if(len<min){
                    min=len;
                }
            }

        }
    return min;
    }

    public static void main(String[] args) {

        int arr[]={1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(arr));
    }
}
