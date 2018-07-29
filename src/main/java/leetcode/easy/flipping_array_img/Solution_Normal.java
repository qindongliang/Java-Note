package leetcode.easy.flipping_array_img;

import java.util.Arrays;

/**
 * Created by qindongliang on 2018/7/29.
 */
public class Solution_Normal {


    public static int[][] flipAndInvertImage(int[][] ab) {

        filp2(ab);
        invert(ab);

        return ab;
    }


    static void invert(int [][]ab){
        for (int i = 0; i <ab.length ; i++) {

            for (int j=0; j <ab[i].length; j++) {
                // 得到每一列
                ab[i][j]=ab[i][j]==0?1:0;
            }

        }
    }


    /***
     * bad
     * @param a
     */
    static void filp1(int a[][]){

        for (int i = 0; i <a.length ; i++) {
            int array[]=a[i];
            int loopCount=array.length%2==0?array.length/2:array.length/2+1;
            for (int j = 0,x=array.length; j <loopCount&&x>0 ; j++,x--) {
                int temp=array[x-1];
                array[x-1]=array[j];
                array[j]=temp;
            }

        }


    }

    /***
     * beetter
     * @param a
     */
    static void filp2(int a[][]){

        for (int i = 0; i <a.length ; i++) {
            int array[]=a[i];
            int n=array.length;
            for (int j = 0; j <n/2 ; j++) {
                int temp=array[j];
                array[j]=array[n-1-j];
                array[n-1-j]=temp;
            }

        }


    }

    static void swapPos(){

        int array[]={1,2,5,4};
        System.out.println(Arrays.toString(array));
        int n=array.length;
        int swap_count=n/2;
        System.out.println("swap_count: "+swap_count);
        for (int j = 0; j <n/2 ; j++) {
            int temp=array[j];
            array[j]=array[n-1-j];
            array[n-1-j]=temp;
        }

        System.out.println(Arrays.toString(array));



    }


    public static void main(String[] args) {


//        int ab[][]=new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        int ab[][]=new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
//        int ab[][]=new int[][]{{1,1,1}};

//        swapPos();

//        change();


        System.out.println(Arrays.deepToString(ab));
        flipAndInvertImage(ab);

        System.out.println(Arrays.deepToString(ab));


    }


}
