package leetcode.easy.array_all;

/****
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {

        int n=nums.length;

        int total=n * (n+1)/2;

        int sum=0;
        for (int num:nums){
            sum+=num;
        }
        return total-sum;

    }

    public static void main(String[] args) {
        int arr[]={3,0,1};
        System.out.println(missingNumber(arr));
    }
}
