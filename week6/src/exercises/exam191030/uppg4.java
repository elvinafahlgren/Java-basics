package exercises.exam191030;

import static java.lang.System.out;

public class uppg4 {
    public static void main(String[] args) {
        new exercises.exam191030.uppg4().program();
    }

    private void program() {
        int[][] m ={
                {1, 4, 7},
                {2, 0, 5},
                {1, 3, 3}
        };
    }

    boolean hasIncreasingRowElementSeq(int[][] matrix){
        int i = minValue(matrix[0]);
        for(int row = 1; row < matrix.length; row++){
            int diff = minDiff(matrix[row], i);
            if(diff <= 0)
                return false;
            else
                i += diff;
        }
        return true;
    }

    int minDiff(int[] arr, int value){
        int minDiff = maxValue(arr) - value;
        for(int i = 0; i < arr.length; i++){
            int d = arr[i] - value;
            if(0 < d && d < minDiff)
                minDiff = d;

        }
        return minDiff;
    }

    int minValue(int[] arr){
        int min = arr[0];
        for(int i : arr){
            if(i < min)
                min = i;
        }
        return min;
    }

    int maxValue(int[] arr){
        int max = arr[0];
        for(int i : arr){
            if(i > max)
                max = i;
        }
        return max;
    }
}
