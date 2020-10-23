package exercises.exam190107;

public class uppg4 {
    public static void main(String[] args) {
        new exercises.exam190107.uppg4().program();
    }

    private void program() {
        int[][] m1 = {{0, 1, 0, 1},
                      {0, 0, 1, 1},
                      {1, 0, 1, 1},
                      {0, 1, 0, 0}
        };
        System.out.println(checkMatrix(m1, 2));

    }

    boolean checkMatrix(int[][] matrix, int subSize){

        for(int row = 0; row < matrix.length - subSize + 1; row++){
            for(int col = 0; col < matrix[row].length - subSize + 1; col++){
                if(matrixConsistsOnlyOfOnes(matrix, row, col, subSize)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean matrixConsistsOnlyOfOnes(int[][] matrix, int r, int c, int size){
        for(int row = r; row < r + size; row++){
            for(int col = c; col < c + size; col++){
                if(matrix[row][col] != 1){
                    return false;
                }
            }
        }
        return true;
    }
}
