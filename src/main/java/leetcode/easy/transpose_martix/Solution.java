package leetcode.easy.transpose_martix;

import java.util.Arrays;

/**
 * Created by qindongliang on 2018/8/12.
 */
public class Solution {


    public static void main(String[] args) {


//        int [][]data={ {1,2,3},{4,5,6},{7,8,9}  };
        int [][]A={ {1,2,3},{4,5,6}   };


        int rows=A.length;
        int cols=A[0].length;

        int data2[][]=new int[cols][rows];

        for (int i = 0; i <cols ; i++) {
            for (int j = 0; j <rows ; j++) {
                data2[i][j]=A[j][i];
            }
        }


        System.out.println(Arrays.deepToString(data2));


    }



}
