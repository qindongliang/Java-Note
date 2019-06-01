package leetcode.easy.array_all;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/***
 *
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 *
 * 题目描述： 给定一个数组，里面值的取值范围是-1000 到 1000
 * 现在让求找出里面三个数使得乘积最大。
 *
 * 思路：
 *
 * 无非就两种情况，
 * （1）如果数组的值全部是正数的时候，那么末尾的三个数的乘积一定是最大的，
 * （2）如果包含负数，则需要取最小的两位数（负负得正）然后再乘上正数里面最大的哪一个得出来的结果可能也是最大的
 *  上面的两种情况都需要考虑，然后在（1）和（2）之间再比较得到最大的返回即可。
 *
 */
public class MaximumProductThreeNumbers {

    public int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        if(nums[0]>=0){
            return nums[len-1]*nums[len-2]*nums[len-3];
        }else{
            return Math.max(nums[len-1]*nums[len-2]*nums[len-3],nums[0]*nums[1]*nums[len-1]);
        }

    }

    public int maximumProduct2(int[] nums) {
     if(nums.length<3){
         return -1;
     }
     int min1,min2,max1,max2,max3;
     min1=min2=Integer.MAX_VALUE;
     max1=max2=max3=Integer.MIN_VALUE;

     for (int n:nums){
         if(n<min1){
             min2=min1;
             min1=n;
         }else if(n<min2){
             min2=n;
         }

         if(n>max1){
             max3=max2;
             max2=max1;
             max1=n;
         }else if(n>max2){
             max3=max2;
             max2=n;
         }else if(n>max3){
             max3=n;
         }

     }

        return Math.max(max1*max2*max3,min1*min2*max1);
    }


    public int maximumProduct3(int[] nums) {
        PriorityQueue<Integer> poheap = new PriorityQueue<>();
        PriorityQueue<Integer> neheap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num:nums){
            poheap.add(num);
            neheap.add(num);
            if(poheap.size()>3){
                poheap.poll();
            }

            if(neheap.size()>2){
                neheap.poll();
            }
        }

        int c1=1;
        int max=0;

        while (!poheap.isEmpty()) {
            max = poheap.poll();
            c1 *= max;
        }

        while (!neheap.isEmpty()) {
            max *= neheap.poll();
        }
    return Math.max(c1, max);
    }




    public static void main(String[] args) {
        PriorityQueue<Integer> poheap = new PriorityQueue<>();
        poheap.add(12);
        poheap.add(-2);
        poheap.add(3);
        poheap.add(1);



        System.out.println(poheap);

        System.out.println(poheap.poll());
    }

}
