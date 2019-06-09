package leetcode.easy.array_all;

/****
 * https://leetcode.com/problems/valid-mountain-array/
 *
 * 题目描述：给定一个int数组 ，让判断这个数组是否是山顶。
 *
 * 思路：
 *
 * 假设两个人去爬山，分别从山的左边和右边出发，如果他们爬的是同一个山
 * 那么必定会在山顶位置相遇例如（2，3，1）就符合，但（1，2，3）就不符合，否则就不会相遇，按照这个思路，
 * 用双指针的方式，分别从左和右出发，然后遍历到山顶的位置，判断index是否相等。
 *
 *
 */
public class ValidMountainArray {
    public static boolean validMountainArray(int[] A) {
     int n=A.length;
     int i=0;
     int j=n-1;

     //从左向右遍历，左边的值小于右边
     while (i+1<n&&A[i]<A[i+1]){
         i++;
     }
     //从右向左遍历，右边的值小于左边
     while (j>0&&A[j-1]>A[j]){
         j--;
     }
     //判断是否相遇，并且i和j不能是原地（保证了长度肯定大于3）
     return i>0&&i==j&&j<n-1;

    }

    public static void main(String[] args) {

        int arr[]={2,3,1};

        System.out.println(validMountainArray(arr));

    }
}
