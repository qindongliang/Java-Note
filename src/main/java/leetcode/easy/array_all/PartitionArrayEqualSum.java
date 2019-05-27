package leetcode.easy.array_all;

/****
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 *
 * 题目描述：给定一个数组，检测这个数组能否被按照某个特定sum值，平均分成3份。
 *思路：
 *首先遍历一遍数组，求得数组的和，然后判断这个和能否整除3，如果不可以整除，直接返回false，
 *如果可以整除，那么就遍历数组，累加每一次遍历的数字，如果遇到有两次累加的和等于sum，那么就说明
 *这个数组符合要求，可以直接返回true，这里有个细节的优化点，就是不需要判断非得是3次，因为等于2次的时候，
 *剩下的部分累加肯定等于sum/3
 */
public class PartitionArrayEqualSum {

    public static boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int num:A){
            sum+=num;
        }

        if(sum%3!=0){
            return false;
        }
        int part=0;
        int count=0;
        for (int num:A){
            part+=num;

            if(part==sum/3){
                count++;
                if(count==2) return true;
                part=0;
            }

        }
    return false;
    }

    public static void main(String[] args) {
        int A[]= {10, -10, 10, 10, 10, 10, -10};
        System.out.println(canThreePartsEqualSum(A));
    }


}
