//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package exercises;

import java.util.Arrays;

public class Ex3MatrixMethods {
    public Ex3MatrixMethods() {
    }

    public static void main(String[] args) {
        (new Ex3MatrixMethods()).program();
    }

    void program() {
        int[][] m = new int[][]{{-1, 0, -5, 3}, {6, 7, -2, 0}, {9, -2, -6, 8}, {0, 0, 5, -6}};
        int[] negs = this.getNegatives(m);
        System.out.print(Arrays.toString(negs));
        System.out.println(negs.length == 6);
        System.out.println(Arrays.toString(negs).equals("[-1, -5, -2, -2, -6, -6]"));
        int[][] marked = this.markNegatives(new int[][]{{1, -2, 3}, {-4, 5, -6}, {7, -8, 9}});
        this.plot(marked);
        System.out.println(Arrays.toString(marked[0]).equals("[0, 1, 0]"));
        System.out.println(Arrays.toString(marked[1]).equals("[1, 0, 1]"));
        System.out.println(Arrays.toString(marked[2]).equals("[0, 1, 0]"));
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[][] matrix = this.toMatrix(arr);
        this.plot(matrix);
        System.out.println(Arrays.toString(matrix[0]).equals("[1, 2, 3]"));
        System.out.println(Arrays.toString(matrix[1]).equals("[4, 5, 6]"));
        System.out.println(Arrays.toString(matrix[2]).equals("[7, 8, 9]"));
        System.out.println(this.sumNeighbours(matrix, 0, 0) == 11);
        System.out.println(this.sumNeighbours(matrix, 1, 1) == 40);
        System.out.println(this.sumNeighbours(matrix, 1, 0) == 23);
    }

    int[] getNegatives(int[][] array) {
        int index = 0;
        int numberOfIndex = this.countNeg(array);
        int[] negArray = new int[numberOfIndex];

        for(int i = 0; i < array.length; ++i) {
            for(int j = 0; j < array.length; ++j) {
                if (array[i][j] < 0) {
                    negArray[index] = array[i][j];
                    ++index;
                }
            }
        }

        return negArray;
    }

    int countNeg(int[][] array) {
        int count = 0;

        for(int i = 0; i < array.length; ++i) {
            for(int j = 0; j < array.length; ++j) {
                if (array[i][j] < 0) {
                    ++count;
                }
            }
        }

        return count;
    }

    int[][] markNegatives(int[][] mat) {
        int[][] matrix = new int[mat.length][mat[0].length];

        for(int i = 0; i < mat.length; ++i) {
            for(int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] < 0) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }

    int[][] toMatrix(int[] array) {
        int lengthSubset = 3;
        int M = (array.length + lengthSubset - 1) / lengthSubset;
        int[][] matrix = new int[M][M];
        int index = 0;

        for(int i = 0; i < M; ++i) {
            for(int j = 0; j < M; ++j) {
                matrix[i][j] = array[index];
                ++index;
            }
        }

        return matrix;
    }

    int sumNeighbours(int[][] matrix, int row, int index) {
        int total = 0;

        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix.length; ++j) {
                if (Math.abs(i - row) <= 1 && Math.abs(j - index) <= 1) {
                    total += matrix[i][j];
                }
            }
        }

        total -= matrix[row][index];
        return total;
    }

    void plot(int[][] matrix) {
        for(int row = 0; row < matrix.length; ++row) {
            System.out.println(Arrays.toString(matrix[row]));
        }

    }
}
