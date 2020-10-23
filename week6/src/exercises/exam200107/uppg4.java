package exercises.exam200107;

import java.util.Arrays;

public class uppg4 {
    public static void main(String[] args) {
        new exercises.exam200107.uppg4().program();
    }

    private void program() {
        int[] a0 ={4};
        int[] a1 ={1, 4, 0, 2};
        int[] a2 ={4, 0, 2, 0};
        int[] a3 ={1, 4, 7, 2, 0, 5, 3, 3, 1};

        int[][] m ={
                {1, 4, 7},
                {2, 0, 5},
                {1, 3, 3}
        };

        hasSubmatrixWith(a0, m);    //true
        hasSubmatrixWith(a1, m);    //true
        hasSubmatrixWith(a2, m);    //false
        hasSubmatrixWith(a3, m);    //true
    }

    boolean hasSubmatrixWith(int[] arr, int[][] matrix){
        int size = (int) Math.sqrt(arr.length);

        for(int row = 0; row <= matrix.length - size; row++){
            for(int col = 0; col <= matrix[row].length - size; col++){
                /*
                if(matrixContainsValues(matrix, row, col, size, arr))
                    return true;
                 */
                int[][] subMatrix = getSubMatrix(matrix, row, col, size);
                int[] subArray = subToArray(subMatrix);
                //System.out.println(Arrays.toString(subArray));
                boolean match = compareArrays(subArray, arr);
                if(match)
                    return true;

            }
        }
        return false;
    }

    boolean compareArrays(int[] array, int[] values){
        if(array.length != values.length)
            return false;

        int foundValues = 0;
        boolean[] alreadyUsed = new boolean[array.length];

        for(int row =  0; row  < array.length; row++){
            for(int i = 0; i < values.length; i++){
                if(array[row] == values[i] && !alreadyUsed[i]){
                    foundValues++;
                    alreadyUsed[i] = true;
                    break;
                }
            }
        }
        return false; // TODO ????????????????????????????????;KOLLA sista för. ca 20 min andra del
    }

    int[] subToArray(int[][] matrix){
        int[] subArray = new int[matrix.length * matrix[0].length];
        int subArrayIndex = 0;

        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix.length; col++){

                subArray[subArrayIndex] = matrix[row][col];
                subArrayIndex++;
            }
        }
        return subArray;
    }

    int[][] getSubMatrix(int[][] matrix, int r, int c, int size){
        int[][] subMatrix = new int[size][size];

        for(int row = r; row < r + size; row++){
            for(int col = c; col < c + size; row++){
                subMatrix[row - 1][col - 1] = matrix[row][col];
            }
        }
        return subMatrix;

    }


}
