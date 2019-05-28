package leetcode.easy.array_all;

import java.util.ArrayList;
import java.util.List;
/*
 *给定一个数组，数组里面值的大小范围是 1<=a[i]<=array.length，数组里面的
 *值，可以重复的出现一次或者两次，现在让求出不在数组里面的的元素列表。
 */
public class FindDiappearedInArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index=Math.abs(nums[i])-1;
            if(nums[index]>0) {
                nums[index] = -nums[index];
            }
        }

        for (int i=0;i<nums.length;i++) {
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[]={4,3,2,7,8,2,3,1};//5,6
        System.out.println(findDisappearedNumbers(arr));
    }
}
