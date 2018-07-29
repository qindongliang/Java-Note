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



    static void reverseArray(){

        int array[]={1,2,5,4};
        System.out.println("原始数组："+Arrays.toString(array));
        //数组的长度
        int n=array.length;
        //只需要循环长度的一半的次数即可完成反转
        for (int j = 0; j <n/2 ; j++) {
            int temp=array[j];//获取前半部分数组的每一个元素
            array[j]=array[n-1-j];//获取对应的后半部分数组的每一个元素
            array[n-1-j]=temp;//在原数组中完成前后交换
        }
        System.out.println("反转后的数组："+Arrays.toString(array));

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
