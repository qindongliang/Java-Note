package leetcode.easy.array_all;
//找出数组里面多于数组size一半重复的数字，叫大多数数字
public class MajorityElement {
    public static int majorityElement(int[] nums) {

        int count=0;
        int major=nums[0];
        for (int element:nums) {
            if(count==0){
                major=element;
                count++;
            }else if(element==major){
                count++;
            }else {
                count--;
            }
        }

        return major;
    }



    public static void main(String[] args) {
//        int arr[]={2,2,1,1,1,2,2};
        int arr[]={6,5,5};
        System.out.println(majorityElement(arr));
    }

}
