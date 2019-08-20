package leetcode.easy.math;

/***
 *https://leetcode.com/problems/projection-area-of-3d-shapes/
 *
 */
public class ProjectionArea3DShapes {


    public static int projectionArea(int[][] grid) {

        int res=0;
        int n=grid.length;
        for (int i = 0; i < n; i++) {

            int x=0;
            int y=0;
            for (int j = 0; j < n; j++) {
                x=Math.max(x,grid[i][j]);
                y=Math.max(y,grid[j][i]);
                if(grid[i][j]>0){
                    res++;
                }
            }

            res+=x+y;


        }


        return res;

    }


    public static void main(String[] args) {


        int [][]arr=new int[][]{{2}};
        System.out.println(projectionArea(arr));
    }

}
