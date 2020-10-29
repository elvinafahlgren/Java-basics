/*
        Solution to question 4 here.
 */

import static java.lang.System.*;

public class Q4 {

    public static void main(String[] args) {
        new Q4().program();
    }

    private void program() {
        int[][] m = {
                {0, 1, 0, 3},
                {2, 0, 2, 1},
                {1, 0, 3, 1},
                {0, 2, 0, 2}
        };
        out.println(smallestMatrixWithSum(m, 3));
        out.println(smallestMatrixWithSum(m, 6));
        out.println(smallestMatrixWithSum(m, 11));
        out.println(smallestMatrixWithSum(m, 8));
        /*
        */

    }

    /**Leta efter minsta sidan en subMatrix kan ha**/
    int smallestMatrixWithSum(int[][] matrix, int sum){
        for(int side = 1; side < matrix.length; side++) {
            for (int row = 0; row <= matrix.length - side; row++) {
                for (int col = 0; col <= matrix[row].length - side; col++) {
                    int[] subArray = getArrayOfSubMatrix(matrix, row, col, side);
                    if(countArray(subArray) == sum)
                        return side;
                }
            }
        }
        return -1;
    }

    int countArray(int[] arr){
        int sum = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];

        }
        return sum;
    }

    int[] getArrayOfSubMatrix(int[][] matrix, int row, int col, int side){
        int[] subArray = new int[side * side];
        int k = 0;

        for(int r = row; r < row + side; r++){
            for(int c = col; c < col + side; c++){
                subArray[k] = matrix[r][c];
                k++;
            }
        }
        return subArray;

    }
}
