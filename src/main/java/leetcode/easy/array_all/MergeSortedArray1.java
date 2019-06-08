package leetcode.easy.array_all;

/****
 *
 * https://leetcode.com/problems/merge-sorted-array/
 * 题目描述：给定两个有序数组nums1，nums2，把nums2的数据给合并到nums1里面
 * 合并之后仍然保持有序，注意nums1的空间，假设总是可以装下两个数组的所有数字。
 * 每个数组都分别用m和n代表当前数组里面的元素个数。
 *
 * 思路1：两个循环
 *
 * 这道题和普通的合并有序数组不一样，因为普通的两个有序数组合并，只需要额外声明一个数组，
 * 长度等于m+n，然后直接从左到右开始遍历，一个个按顺序放到新的数组中即可。
 *
 * 但这道题，由于限制了nums2数组的值，要全部放到nums1里面，所以不能按照从左到右遍历合并，
 * 只能从右到左，也就是先比较最大值，然后次大值..，从大到小遍历，然后拷贝到nums1里面即可
 *
 * 注意，由于是向nums1拷贝，所以nums2必须全部拷贝，不能漏掉，所以最后要考虑nums2是否拷贝完毕。
 *
 * 思路2：1个循环
 *
 * 代码更加简洁
 *
 */

public class MergeSortedArray1 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int tail1=m-1;
        int tail2=n-1;
        int finished=m+n-1;
        while (tail1>=0&&tail2>=0){

         if(nums1[tail1]>nums2[tail2]){
             nums1[finished--]=nums1[tail1--];
         }else {
             nums1[finished--]=nums2[tail2--];
         }
        }

        while (tail2>=0){
            nums1[finished--]=nums2[tail2--];
        }

    }
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

       while (n>0){
           if(m>0&&nums1[m-1]>nums2[n-1]){
               nums1[m+n-1]=nums1[m-1];
               m--;
           }else {
               nums1[m+n-1]=nums2[n-1];
               n--;
           }

       }
    }



    public static void main(String[] args) {

    }
}
