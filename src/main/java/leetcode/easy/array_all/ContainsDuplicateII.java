package leetcode.easy.array_all;

import java.util.HashSet;
import java.util.Set;

/****
 *
 * 题目描述：
 *
 * 给定一个int数组，并给定一个k距离值，让你判断，是否存在两个下标i和j，他们的nums[i]=nums[j],
 * 并且i和j的绝对值最大为k，如果存在就返回true，否则就返回false
 *
 * 思路：
 * 借用滑动窗口的思路，遍历整个数组，始终将窗口值保持在k范围之内，然后判断是否有符合条件的
 * 数据，有就有返回true，如果遍历结束都没有，就返回false。
 *
 */

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //如果i的值大于k，就移除掉在窗口距离k之外的数据
            if(i>k){
                set.remove(nums[i-k-1]);
            }
            //然后判断在窗口值范围内是否存在我们要找的数据，如果出现两次就返回true
            if(!set.add(nums[i])){//不包含返回true
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[]={1,0,1,1};
        int k=1;

        System.out.println(containsNearbyDuplicate(arr,k));

    }
}
