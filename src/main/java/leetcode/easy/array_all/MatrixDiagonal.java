package leetcode.easy.array_all;

/****
 * https://leetcode.com/problems/toeplitz-matrix/
 */
public class MatrixDiagonal {


    public static boolean isToeplitzMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = 0; j <matrix[i].length-1 ; j++) {
                int v1=matrix[i][j];
                int v2=matrix[i+1][j+1];
                if(v1!=v2){
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {

        int [][]matrix={ {1,2,3,4},{5,1,2,3},{9,5,1,2}};

        System.out.println(isToeplitzMatrix(matrix));
    }


}
