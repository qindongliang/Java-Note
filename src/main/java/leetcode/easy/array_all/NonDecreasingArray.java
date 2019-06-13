package leetcode.easy.array_all;

/****
 *
 * 题目描述：给定一个int数组，求出能不能最多改动一位数字，使得整个数组变成升序
 *
 * 包含两种case：
 *
 * 1，7，3，4 =》 1，3，3，4
 *
 * 4，7，3，9 =》 4，7，7，9
 *
 */
public class NonDecreasingArray {

    public static boolean checkPossibility(int[] nums) {
        int count=0;
        for (int i = 0; i + 1<nums.length ; i++) {
         if(nums[i]>nums[i+1]){
             count++;
             if(count==2) return false;
             if(i>0&&nums[i+1]<nums[i-1]){
                nums[i+1]=nums[i];//4，7，3，9 =》 4，7，7，9
             }else{
                 nums[i]=nums[i+1];//1，7，3，4 =》 1，3，3，4
             }

         }


        }
    return count<=1;
    }

    public static void main(String[] args) {
        int arr[]={4,7,3,9};
        System.out.println(checkPossibility(arr));

    }
}
