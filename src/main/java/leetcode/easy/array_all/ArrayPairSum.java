package leetcode.easy.array_all;

import java.util.Arrays;

/**
 * Created by qindongliang on 2018/8/5.
 */
public class ArrayPairSum {


    public static int arrayPairSum2(int[] nums) {
        Arrays.sort(nums);
        return  getSum(nums);
    }


    public  static  int getSum(int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i=i+2){
            sum=sum+nums[i];
        }
        return sum;
    }


    public static int arrayPairSum(int[] nums) {

        int[] map = new int[20001];
        int res = 0;
        boolean even = true;

        for(int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            map[10000 + nums[i]]++;
//            System.out.println(value);
        }

        for (int i = 0; i < map.length; i++) {
            if(map[i]!=0){
                System.out.println(i);
            }
        }

        for(int i = 0; i < 20001; i++) {
            while(map[i] > 0) {
                if (even) {
                    even = false;
                    res += i - 10000;
                } else {
                    even = true;
                }
                map[i]--;
            }
        }
        return res;
    }

    public static void main(String[] args) {


        int [] nums={1,4,3,2};


        arrayPairSum(nums);


    }
}
