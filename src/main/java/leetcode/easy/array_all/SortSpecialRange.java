package leetcode.easy.array_all;

/**
 * Created by qindongliang on 2018/8/5.
 */
public class SortSpecialRange {


    public static void main(String[] args) {

        //已知数组，假设最大值在[-100,100]之间
        int []nums={1,90,3,56,8,20,100};

        //申请一个大于原数组一倍大小的数组空间，默认初始值都是0
        int []map=new int[201];

        //将映射位置0标记为1，循环完毕，代表已经排序完
        for(int i=0;i<nums.length;i++){
            map[nums[i]+100]++;
        }


        //输出排序后的结果

        for (int i = 0; i <map.length ; i++) {
            if(map[i]!=0){
                System.out.println(i-100);
            }
        }








    }


}
