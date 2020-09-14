package exercises;

import java.util.Arrays;

import static java.lang.System.out;

/*
    Find three elements in sorted array that adds up to 0.
    Return indices to the elements as an array.

 */
public class Ex6ThreeSumToZero {

    public static void main(String[] args) {
        new Ex6ThreeSumToZero().program();
    }


    void program() {
        int[] arr1 = {-25, -10, -7, -3, 2, 4, 8, 10}; // Must be sorted
        int[] arr2 = {0, 1, 2, 4, 8, 10};
        int[] arr3 = {-2, 1, 1};
        int[] arr4 = {0, 0, 0, 0};

        out.println(Arrays.toString(getThreeSum(arr1)));    // [1, 4, 6]
        out.println(Arrays.toString(getThreeSum(arr2)));    // []
        out.println(Arrays.toString(getThreeSum(arr3)));    // [0, 1, 2]
        out.println(Arrays.toString(getThreeSum(arr4)));    // [ 0, 1 ,3 ] or any
    }
    int[] getThreeSum(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr.length; j++){
                for(int k = 2; k < arr.length; k++){
                    if(arr[i] + arr[j] + arr[k] == 0 && i != j && i != k && j != k){
                        int indexArr[] = new int[3];
                        indexArr[0] = i;
                        indexArr[1] = j;
                        indexArr[2] = k;
                        return indexArr;
                    }
                }
            }
        }
        int empty[] = new int[0];
        return empty;
    }


}
