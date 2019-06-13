package leetcode.easy.array_all;

/***
 *
 * 求出数组里面第三大的数字
 *
 */
public class ThirdMaximumNumber {

    public static int thirdMax(int[] nums) {

        Integer []largest=new Integer[3];

        for (int n:nums){

            if(largest[0]==null||n>largest[0]){
                largest[2]=largest[1]; // third maximum in array
                largest[1]=largest[0]; //second maximum in array
                largest[0]=n;// first maximum   in array
            }else if(largest[0]!=null&&largest[0]>n&&(largest[1]==null||n>largest[1])){
                largest[2]=largest[1];
                largest[1]=n;
            }else if(largest[1]!=null&&largest[1]>n&&(largest[2]==null||n>largest[2])){
                largest[2]=n;
            }

        }
     return largest[2]==null?largest[0]:largest[2];
    }


    //方式2
    public int thirdMax2(int[] nums) {
        long fmax = Long.MIN_VALUE;
        long smax = Long.MIN_VALUE;
        long tmax = Long.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>fmax){
                tmax = smax;
                smax = fmax;
                fmax = (long)nums[i];
            }
            else if(nums[i]<fmax && nums[i]>smax){
                tmax = smax;
                smax = (long)nums[i];
            }
            else if(nums[i]>tmax && nums[i]<smax){
                tmax = (long)nums[i];
            }
        }
        if(tmax==Long.MIN_VALUE){
            return (int)fmax;
        }
        return (int)tmax;
    }

    public static void main(String[] args) {

        int arr[]={3, 2, 1};

        System.out.println(thirdMax(arr));


    }
}
