/*
        Solution to question 4 here.
 */

import java.util.Arrays;

import static java.lang.System.*;

public class Q4 {

    public static void main(String[] args) {
        new Q4().program();
    }

    private void program() {
        int[][] m1 = {{1,2,3},
                      {3,1,1},
                      {0,3,2}};

        int[][] m2 = {{1,2,5},
                      {3,1,1},
                      {0,3,2}};

        out.println(sameSubMatricies(m1, 2) == true);
        out.println(sameSubMatricies(m2, 2) == false);
        out.println(sameSubMatricies(m1, 1) == false);
        out.println(sameSubMatricies(m1, 3) == true);

    }

    boolean sameSubMatricies(int[][] matrix, int side) {
        // TODO Write code
        int sum = getSumSubMatrix(matrix, 0, 0, side);
        int currentSum;

        // Går igen varje sub-matris och kollar om summan är samma som första sub-matrisens värde
        for(int row = 0; row <= matrix.length - side; row++){
            for(int col = 0; col <= matrix[row].length - side; col++){
                currentSum = getSumSubMatrix(matrix, row, col, side);
                if(sum != currentSum)
                    return false;
            }
        }
        return true;
    }
    // TODO Write more methods if needed

    // Summerar alla värden i sub-matrisen
    int getSumSubMatrix(int[][] matrix, int row, int col, int side){
        int[] subArr = getArrayOfSubMatrix(matrix, row, col, side);
        int sum = 0;

        for(int i = 0; i < subArr.length; i++){
            sum += subArr[i];
        }
        return sum;
    }

    // Gör om matrisen till en array av sub-matrisen
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
