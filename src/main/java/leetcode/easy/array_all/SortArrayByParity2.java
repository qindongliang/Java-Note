package leetcode.easy.array_all;

import java.util.Arrays;

/***
 *https://leetcode.com/problems/sort-array-by-parity-ii/
 */
public class SortArrayByParity2 {


    public static int[] sortArrayByParity(int[] A) {
        int even=0;
        int odd=1;

        while (true){

            //找到偶数index上，非偶数的值
            while (even<A.length&&A[even]%2==0){
                even+=2;
            }

            //找到奇数index上，非奇数的值
            while (odd<A.length&&A[odd]%2!=0){
                odd+=2;
            }

            if(odd>=A.length||even>=A.length){
                break;
            }

            int temp=A[even];
            A[even]=A[odd];
            A[odd]=temp;

        }



        return A;
    }

    public static void main(String[] args) {
        int a[]={4,2,5,7};

        System.out.println(Arrays.toString(a));
        sortArrayByParity(a);

        System.out.println(Arrays.toString(a));


    }

}
