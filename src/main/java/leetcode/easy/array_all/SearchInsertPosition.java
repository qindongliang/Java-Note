package leetcode.easy.array_all;

/***
 *
 * 题目描述：给定一个有序不重复的数组，查找里面是否包含数字targe，如果有则返回其下标index，
 * 如果没有，则返回其应该插入的位置。
 *
 * 两种思路：
 *
 * （1）二分法O(logN)，效率最高，尤其是在大数据量的体积下
 *
 * （2）线性扫描，O（N），大数量下可能并不高效
 *
 *
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;

        while (start<=end){
            int mid=start+(end-start)/2;//没有使用（start+end）/ 2 是为了防止数组越界
            int midVal=nums[mid];
            if(midVal<target){
                start=mid+1;
            }else if(midVal>target){
                end=mid-1;
            }else {
                return mid;
            }

        }

        return start;
    }


    public  static int searchInsert2(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target)
                return i;
        }
        return nums.length;

    }



    public static void main(String[] args) {
        int arr[]={1,3,5,6};

        System.out.println(searchInsert(arr,-1));
    }


}
