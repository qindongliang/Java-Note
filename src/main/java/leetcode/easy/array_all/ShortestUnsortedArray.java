package leetcode.easy.array_all;

/****
 *
 *https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 *
 * 题目描述：给定一个升序的数组，但其中一部分数组被打乱了顺序，现在要查找，这部分乱掉的数组是那一段，并返回其长度。
 *
 * 这道题在leetcode上面投票最高的答案，非常不好理解，建议如果想理解透彻的，可以看下面的这个链接的第五种解法。
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solution/#approach-5-without-using-extra-space-accepted
 *
 * 思路：
 * 从题意直到，数组本是一个升序的数组，但中间一部分被打乱了顺序，如果一部分被打断了顺序，那么必定在最左侧或者左右侧还存在两段独立的有序的数组，
 * 利用这一点，反应在数组里面的变化就是，升序的过程中，突然从某个数值开始下降了，那么说明这个地方是乱序的开始，同理从右向左应该是下降趋势，如果某个点
 * 突然升高，那么这个地方是乱序的结束，注意，这分别的开始和结束并不代表真正的乱序部分的范围，乱序数组的范围应该是介于乱序部分里面的最小值和最大值之间
 * 所以，我们形式上左侧乱序的拐点开始，就要找右侧区间里面的最小值，同理，我们从形式上右侧乱序的拐点开始，就要找左侧区间的最大值。
 *
 * ok，当这个两个值找到之后，我们最终在遍历数组，分别找到这两个值发生变化的前一个值，如找到最小值的前一个index和最大值的后一个index，才是真正意义上我们
 * 要找乱序数组的开始和结束。
 *
 * 下面给出两种方法，findUnsortedSubarray是容易理解的写法，但性能略低
 * findUnsortedSubarray2是性能高的方法，因为省了几个循环，所以性能较高，都是O（N）时间复杂度，并没有额外的空间
 */

public class ShortestUnsortedArray {

    public static int findUnsortedSubarray(int[] nums) {
      int min=Integer.MAX_VALUE;
      int max=Integer.MIN_VALUE;
      boolean flag=false;

      //第一个循环去找到在升序数组中，突然下降之后的数据中，最小的水平线
      for (int i = 1; i <nums.length ; i++) {
          if(nums[i]<nums[i-1]){
              flag=true;
          }
          if(flag){
              min=Math.min(min,nums[i]);
          }
      }

      flag=false;
        //注意这里的减2，是为了倒数第二位和倒数第一位做比较
        //在升序数组中，倒序遍历，找到突然上升数据里面，找到一个最大值。
        for (int i = nums.length-2; i >=0 ; i--) {
            if(nums[i]>nums[i+1]){
                flag=true;
            }
            if(flag){
                max=Math.max(max,nums[i]);
            }
        }

        int left=0;
        int right=nums.length-1;
        //找到左侧发生拐点的第一个位置
        while (left<nums.length){
            if(min<nums[left]){
                break;
            }
            left++;
        }

        //找到右侧发生拐点的第一个位置
        while (right>=0){
            if(max>nums[right]){
                break;
            }
            right--;
        }


        return right-left<0?0:right-left+1;


    }

    public int findUnsortedSubarray2(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);//从左向右，找出最大值
            min = Math.min(min, A[n-1-i]);//从右向左找出最小值
            if (A[i] < max) end = i;//如果当前i的值，小于最大值，end=i
            if (A[n-1-i] > min) beg = n-1-i;//如果当前i的值，大于最小值，ben=n-1-i
        }
        return end - beg + 1;
    }



    public static void main(String[] args) {
        int arr[]={2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(arr));
    }
}
