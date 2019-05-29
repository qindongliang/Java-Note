package leetcode.easy.array_all;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
    public static boolean containsDuplicate1(int[] nums) {
        Set<Integer> set=new HashSet<>(2*nums.length);
        for (int num:nums){
            if(!set.add(num)){
                return  true;
            }
        }
        return false;
    }



    public static void main(String[] args) {

        int []arr={1,2,3,1};
        System.out.println(containsDuplicate1(arr));

    }
}
