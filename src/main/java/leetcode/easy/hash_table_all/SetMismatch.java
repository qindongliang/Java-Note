package leetcode.easy.hash_table_all;

import java.util.HashSet;
import java.util.Set;

/****
 *
 *题目描述：给定一个数组，范围是int类型的1 to n，
 *
 * 这里面有一个数字是被设置错误了，也就是说相邻的两个可能会重复，
 *
 * 现在让找出这两个数字。
 *
 * 注意特殊例子2,2的情况
 *
 * 思路：
 *
 * （1）使用map找出重复，然后通过数组的和，减去每一个遇到的值，最后巧妙得出
 *
 * （2）使用boolean数组，对每一个应该有的位置上使用num[i]-1巧妙让整个数组
 * 和其下标对应，然后两次遍历即可得出
 *
 *
 */
public class SetMismatch {


    public int[] findErrorNums(int[] nums) {

        int len=nums.length;
        boolean[] found=new boolean[len];

        int dup=-1;

        for (int i = 0; i < len; i++) {
            if(found[nums[i]-1]){
                dup=nums[i];
            }
            //设置每一个遍历后的应当在自己位置为true的值
            found[nums[i]-1]=true;
        }

        for (int i=0;i<len;i++){
            if(!found[i]){//找出重复的
                return new int[]{dup,i+1};
            }
        }
    return new int[0];
    }




    public int[] findErrorNums1(int[] nums) {

        Set<Integer> set=new HashSet<>();
        int duplicate=0;
        int n=nums.length;

        long sum=(n*(n+1))/2;//求和公式

        for(int i:nums){
            if(set.contains(i)){
                duplicate=i;
            }
            sum=sum-i;//减去每一个数
            set.add(i);

        }

        return new int[]{duplicate,(int)sum+duplicate};

    }

}
