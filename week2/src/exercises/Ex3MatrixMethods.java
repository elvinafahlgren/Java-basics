package exercises;

import java.util.Arrays;

import static java.lang.StrictMath.round;
import static java.lang.StrictMath.sqrt;
import static java.lang.System.out;

/*
 * Methods with array/matrix params and/or return value. Implement methods.
 *
 * See:
 * - Matrices
 */
public class Ex3MatrixMethods {

    public static void main(String[] args) {
        new Ex3MatrixMethods().program();
    }

    void program() {
        int[][] m = {           // Hard coded test data
                {-1, 0, -5, 3},
                {6, 7, -2, 0},
                {9, -2, -6, 8},
                {0, 0, 5, -6}
        };

        // TODO uncomment one at a time and implement

        // Return array with all negatives in m
        int[] negs = getNegatives(m);
        out.print(Arrays.toString(negs));
        out.println(negs.length == 6);
        out.println(Arrays.toString(negs).equals("[-1, -5, -2, -2, -6, -6]")); // Possibly other ordering!

        // Mark all negatives with a 1, others as 0
        // (create matrix on the fly)
        int[][] marked = markNegatives(new int[][]{
                {1, -2, 3,},
                {-4, 5, -6,},
                {7, -8, 9,},
        });
        /* marked should be (don't uncomment)
        { {0, 1, 0},
          {1, 0, 1},
          {0, 1, 0} }
        */
        plot(marked);
        out.println(Arrays.toString(marked[0]).equals("[0, 1, 0]"));
        out.println(Arrays.toString(marked[1]).equals("[1, 0, 1]"));
        out.println(Arrays.toString(marked[2]).equals("[0, 1, 0]"));

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Create matrix from array
        int[][] matrix = toMatrix(arr);
        /* matrix should be (don't uncomment)
        { {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9} }
        */
        plot(matrix);  // If manual inspection
        out.println(Arrays.toString(matrix[0]).equals("[1, 2, 3]"));
        out.println(Arrays.toString(matrix[1]).equals("[4, 5, 6]"));
        out.println(Arrays.toString(matrix[2]).equals("[7, 8, 9]"));

        // Sum of all directly surrounding elements to some element in matrix
        // (not counting the element itself)
        // NOTE: Should be possible to expand method to include more distant neighbours
        out.println(sumNeighbours(matrix, 0, 0) == 11);
        out.println(sumNeighbours(matrix, 1, 1) == 40);
        out.println(sumNeighbours(matrix, 1, 0) == 23);
    }

    // -------- Write methods below this -----------------------

    // TODO Methods here
    int[] getNegatives(int[][] array){
        int index = 0;
        int numberOfIndex = countNeg(array);
        int negArray[] = new int[numberOfIndex];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++)
            if(array[i][j] < 0){
                negArray[index] = array[i][j];
                index++;
            }
        }
        return negArray;
    }

    int countNeg(int[][] array){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++)
                if(array[i][j] < 0){
                    count++;
                }
        }
        return count;

    }
    int[][] markNegatives(int[][] mat){
        int matrix[][] = new int[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++)
                if(mat[i][j] < 0){
                    matrix[i][j] = 1;
                }
                else{
                    matrix[i][j] = 0;
                }
        }
        return matrix;
    }

    int [][] toMatrix(int[] array){
        int lengthSubset = 3;
        int M = (array.length + lengthSubset - 1) / lengthSubset;
        int matrix[][] = new int[M][M];
        int index =  0;
        for (int i = 0; i < M; i++){
            for(int j = 0; j < M; j++){
                matrix[i][j] = array[index];
                index++;
            }
        }
        return matrix;
    }

    int sumNeighbours(int[][] matrix, int row, int index){
        int total = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                if (Math.abs(i - row) <= 1 && Math.abs(j - index) <= 1){
                    total += matrix[i][j];
                }
            }
        }
        total -= matrix[row][index];
        return total;
    }

    // Use if you like (during development)
    void plot(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row]));
        }
    }

}
