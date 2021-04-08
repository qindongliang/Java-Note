package leetcode.easy.array_all;

import java.util.Arrays;

public class ReplaceGreatestElementRightSide {


    public static int[] replaceElements(int[] arr) {

        int mx=-1; //初始化一个值记录从右向左里面遇到的最大值
        int n=arr.length;
        int a;//记录最新的数组左边的值
        for (int i =n-1; i>=0 ;i--) {
            a=arr[i];
            arr[i]=mx;
            mx=Math.max(mx,a);//获取右边出现最大的值
        }

        return arr;




    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(replaceElements(new int[]{17,18,5,4,6,1})));
        //[18, 6, 6, 6, 1, -1]
        //

    }


}
