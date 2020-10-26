package exercises.exam200107;

import static java.lang.System.out;

public class uppg4 {
    public static void main(String[] args) {
        new uppg4().program();
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

        out.println(hasSubmatrixWith(a0, m));    //true
        out.println(hasSubmatrixWith(a1, m));    //true
        out.println(hasSubmatrixWith(a2, m));    //false
        out.println(hasSubmatrixWith(a3, m));    //true
    }

    boolean hasSubmatrixWith(int[] arr, int[][] matrix){
        int size = (int) Math.sqrt(arr.length);

        for(int row = 0; row <= matrix.length - size; row++){
            for(int col = 0; col <= matrix[row].length - size; col++){
                int[] subArray = getSubMatrixToArray(matrix, row, col, size);
                if(match(subArray, arr))
                    return true;
            }
        }
        return false;
    }

    boolean match(int[] subArr, int[] arr){
        if(subArr.length != arr.length)
            return false;

        int foundValues = 0;
        boolean[] alreadyUsed = new boolean[subArr.length];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < subArr.length; j++){
                if(arr[i] == subArr[j] && !alreadyUsed[j]){
                    foundValues++;
                    alreadyUsed[j] = true;
                }
            }
        }
        if(foundValues == arr.length)
            return true;

        return false;
    }


    int[] getSubMatrixToArray(int[][] matrix, int r, int c, int size){
        int[] subArray = new int[size * size];
        int k = 0;

        for(int row = r; row < r + size; row++){
            for(int col = c; col < c + size; col++){
                subArray[k] = matrix[row][col];
                k++;
            }
        }
        return subArray;

    }
}
