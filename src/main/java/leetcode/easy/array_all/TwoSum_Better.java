package leetcode.easy.array_all;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by qindongliang on 2018/7/2.
 *
 *
 * 思路如下：
 *
 * 声明一个Map，然后遍历数组，取目标值减去每一个迭代到的值，然后取map里面
 * 查询，如果查到就代表找到了。直接返回。
 *
 * 如果没有查到，就把遍历的数字和下标放进Map里面继续迭代，直到找到目标值。
 *
 */
public class TwoSum_Better {

    public static int[] twoSum(int nums[],int target){

        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i <nums.length ; i++) {
            int temp=target-nums[i];
            Integer temp_index=map.get(temp);
            if(temp_index!=null){
                return new int[]{i,temp_index};
            }

            map.put(nums[i],i);


        }
        return null;
    }



    @Test
    public  void test(){
        int nums[]={2,7,11,5};
        int target=9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}
