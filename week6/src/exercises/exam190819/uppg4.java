package exercises.exam190819;

import java.util.Arrays;

public class uppg4 {
    public static void main(String[] args) {
        new exercises.exam190819.uppg4().program();
    }

    private void program() {
        int[][] sudoku = {{4, 8, 3, 9, 2, 1, 6, 5, 7},
                          {9, 6, 7, 3, 4, 5, 8, 2, 1},
                          {2, 5, 1, 8, 7, 6, 4, 9, 3},
                          {5, 4, 8, 1, 3, 2, 9, 7, 6},
                          {7, 2, 9, 5, 6, 4, 1, 3, 8},
                          {1, 3, 6, 7, 9, 8, 2, 4, 5},
                          {3, 7, 2, 6, 8, 9, 5, 1, 4},
                          {8, 1, 4, 2, 5, 3, 7, 6, 9},
                          {6, 9, 5, 4, 1, 7, 3, 8, 2}
        };
        System.out.println(isValidBoxes(sudoku));
        System.out.println(isValidCols(sudoku));
        System.out.println(isValidRows(sudoku));
        System.out.println(checkSudoku(sudoku));
    }

    // Kolla om sudoku är ok genom att kolla att varje rad, kolum och box är ok
    boolean checkSudoku(int[][] sudoku){
        if(isValidRows(sudoku) && isValidCols(sudoku) && isValidBoxes(sudoku))
            return true;

        return false;
    }

    // Kolla om varje rad är ok
    boolean isValidRows(int[][] sudoku){
        for(int row = 0; row < sudoku.length; row++){
            if(!isValisList(sudoku[row]))
                return false;
        }
        return true;
    }

    // Kolla om varje kolumn är ok
    boolean isValidCols(int[][] sudoku){
        for(int col = 0; col < sudoku.length; col++){
            int[] getCol = new int[9];
            for(int row = 0; row < sudoku.length; row++){
                getCol[row] = sudoku[row][col];
            }
            if(!isValisList(getCol))
                return false;
        }
        return true;
    }

    // Kolla om varje box är ok
    boolean isValidBoxes(int[][] sudoku){

        for(int row = 0; row < sudoku.length; row+=3){
            for(int col= 0; col < sudoku.length; col+=3){
                int[] getBox = new int[9];
                int temp = 0;
                for(int r = row; r < row + 3; r++){
                    for(int c = col; c < col + 3; c++){
                        getBox[temp] = sudoku[r][c];
                        temp++;
                    }
                }
                if(!isValisList(getBox))
                    return false;

            }
        }
        return true;
    }


    boolean isValisList(int[] arr){
        int[] tmp = new int[9];

        // Fyll arrayen med 0
        for(int i = 0; i < arr.length; i ++){
            tmp[i] = 0;
        }

        //Fyll varje plats i arrayen med 1 (för de siffror som finns i inkommande arrayen)
        for(int i = 0; i < tmp.length; i++){
            tmp[arr[i] - 1]++;
        }

        for(int i = 0; i < tmp.length; i++)
            if(tmp[i] != 1)
                return false;
        return true;
    }
}
