package exercises.exam181031;

import java.util.Arrays;

public class uppg4 {
    public static void main(String[] args) {
        new uppg4().program();
    }

    private void program() {
        int[][] matrix = new int[][]{{1, 2, 3},
                                     {4, 5, 6},
                                     {7, 8, 9}};
        System.out.println(Arrays.toString(getCommonRowElements(matrix)));

    }
    // Get all elements present on all rows
    int[] getCommonRowElements(int[][] matrix) {
        int[] res = new int[matrix.length];
        int[] firstRow = matrix[0];
        int k = 0;
        for (int col = 0; col < matrix.length; col++) {
            if (isInAllRows(firstRow[col], matrix)) {
                res[k] = firstRow[col];
                k++;
            }
        }
        int[] cut = new int[k];       // Remove 0's
        for (int i = 0; i < k; i++) {
            cut[i] = res[i];
        }
        return cut;
    }

    // Is value n in all rows? n is value matrix are the rows to check
    boolean isInAllRows(int n, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (!isInRow(n, matrix[row])) {
                return false;
            }
        }
        return true;
    }

    // Is value n in this row? n is value and row is row in matrix
    boolean isInRow(int n, int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == n) {
                return true;
            }
        }
        return false;
    }

}

