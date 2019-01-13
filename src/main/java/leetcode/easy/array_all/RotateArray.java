package leetcode.easy.array_all;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        k=k%nums.length;// when  k bigger than length of array , it's actually cycling through mod
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public static void reverse(int nums[],int start, int end){

        while (start<end){

            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;

        }


    }


    public static void rotate2(int[] nums, int k){
        k=k % nums.length;
       int a1[]= Arrays.copyOfRange(nums,nums.length-k,nums.length);
       int a2[]= Arrays.copyOfRange(nums,0,nums.length-k);
        System.arraycopy(a1,0,nums,0,a1.length);
        System.arraycopy(a2,0,nums,k,a2.length);

    }


    public static void main(String[] args) {

        int array[]=new int[]{1,2,3,4,5,6,7};
        // in-place with O(1) extra space and cost O(n) time
//        rotate(array,3);
        // O(n) space and O(n) time
        rotate2(array,3);


    }


}
