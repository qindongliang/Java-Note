package leetcode.easy.array_all;

/***
 * 题目描述： 给定一个只有0和1的数组来表示电影院的座位，1代表有人预定了，0代表空位，
 * 现在让求出找到某一个位置，距离所有已经有人预定的座位的距离是最大的。
 *
 * 思路：
 * 从左到右开始遍历数组，先找到连续1出现的最后位置，
 *
 * 然后记住1的最后位置，接着从这个地方出发，统计连续0出现的最后位置。
 *
 * 如果这1数字没有[0,0,0,0]，或者0的位置在数组的最后[1,0,0,0]
 * 直接取i-j即可，否则就记住以前出现过的最大值，然后重复计算
 * 直到遍历结束，max的值就是出现过的最大距离
 *
 */
public class MaximizeDistance {
    public static int maxDistToClosest(int[] nums) {
        int n=nums.length;
        int max=0;
        int i=0;

        while (i<n){

            //find last postion for one
            while (i<n&&nums[i]==1){
                i++;
            }

            int j=i;
            //find last position for zero
            while (i<n&&nums[i]==0){
                i++;
            }

            if(j==0||i==n){
                max=Math.max(max,i-j);
            }else{
                max=Math.max(max,(i-j+1)/2);
            }

        }

        return max;

    }

    public static void main(String[] args) {
        int arr[]={1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(arr));
    }
}
