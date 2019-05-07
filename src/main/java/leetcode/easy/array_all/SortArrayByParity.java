package leetcode.easy.array_all;

import java.util.Arrays;

/***
 *https://leetcode.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {


    public static int[] sortArrayByParity(int[] A) {
        int start=0;
        int end=A.length-1;

        while (start<end){

            int left=A[start];
            int right=A[end];

            if(left%2==0){//if it is even , left offset increment
                start++;
            }else if(right%2==0){//left is odd and right is even , swap left and right and change offset

                int tmp=A[start];
                A[start]=A[end];
                A[end]=tmp;
                start++;
                end--;

            }else{ // left is odd and right is odd ,  right offset decrement
                end--;
            }

        }


        return A;
    }

    public static void main(String[] args) {
        int a[]={3,1,2,4};

        System.out.println(Arrays.toString(a));
        sortArrayByParity(a);

        System.out.println(Arrays.toString(a));


    }

}
