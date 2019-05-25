package leetcode.easy.array_all;

/***
 *
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 *
 * 思路：
 * 代码参考网上分享的方式，比较巧妙，一般人可能想不到，并且比较简单
 *
 * 观察代码发现，对于一个二维数组，元素总量m =row * col
 *其实每一个元素的坐标是等于从0到m之间的，任意一个遍历的数字
 * 除以col=得到row，与col求模得到col，比较巧妙
 *
 */
public class ReshapeMartix {


    public static int[][] matrixReshape(int[][] nums, int r, int c) {

        int rowOld=nums.length; //row length
        int colOld=nums[0].length;// col length
        if(r*c!=rowOld*colOld){
            return nums;
        }

        int [][]res=new int[r][c];

        for (int i = 0; i < r*c; i++) {
            System.out.println("new=["+i/c+","+i%c+"], old=["+i/colOld+","+i%colOld+"]");
            res[i/c][i%c]=nums[i/colOld][i%colOld];
        }

       return res;

    }

    public static void main(String[] args) {

        int [][] arr={ {1,2},{3,4} };

        matrixReshape(arr,1,4);
//        System.out.println(Arrays.deepToString(arr));

    }


}
