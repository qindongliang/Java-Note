package leetcode.easy.hash_table_all;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/****
 *
 * 题目连接：https://leetcode.com/problems/longest-harmonious-subsequence/
 *
 * 题目描述：给定一个int数组，让求出，里面相邻的两个数字的出现个数最多的次数。
 *
 * 解法描述：
 *
 * 使用一个map用来保存每个词出现的词频
 *
 * 然后遍历里面的每一个key，判断map里面是否存在key+1的相邻的数据，
 *
 * 如果存在，就把相邻的两个数的词频和给相加起来，并与前一个result相比，保留最大值。
 *
 *
 *
 */
public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        //key=num，value=词频
        Map<Integer,Integer> map=new HashMap<>();
        //统计词频
        for (int num:nums){
            map.put(num+1,map.getOrDefault(num,0)+1);
        }

        int result=0;

        for (int key:map.keySet()){
            //判断是否存在，相邻的两个数
            if(key<Integer.MAX_VALUE&&map.containsKey(key+1)){
                //求出最大的词频的那个和
                result=Math.max(result,map.get(key)+map.get(key+1));
            }
        }

        return result;

    }


    public static int findLHS2(int[] nums) {

        Arrays.sort(nums);

        int min=0;
        int count=0;
        for (int i = 1; i <nums.length ;) {
            if(nums[i]-nums[min]==0){
                i++;
            }else if(nums[i]-nums[min]==1){
                count=Math.max(count,i-min+1);
                i++;
            }else {
                min++;
            }
        }

    return count;
    }

    public static void main(String[] args) {
        int arr[]=new int[]{1,3,2,2,5,2,3,7};

        findLHS2(arr);

    }
}
