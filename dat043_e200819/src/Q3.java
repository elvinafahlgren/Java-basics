/*
        Solution to question 3 here.
 */

import java.util.Arrays;

import static java.lang.System.*;

public class Q3 {

    public static void main(String[] args) {
        new Q3().program();
    }

    private void program() { //TODO!!!!!!!!!!!!!!!!!!!!!!!
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = {1, 2, 2, 3, 6, 6, 6};
        int[] arr5 = {7, 5, 3, 6, 2, 2, 3, 6};

        out.println(Arrays.toString(inBoth(arr1, arr2))); // []
        out.println(Arrays.toString(inBoth(arr1, arr3))); // [1, 2]
        out.println(Arrays.toString(inBoth(arr2, arr4))); // [3]
        out.println(Arrays.toString(inBoth(arr4, arr5))); // [2, 3, 6]

    }

    int[] inBoth(int[] a1, int[] a2){
        sort(a1);
        sort(a2);

        int[] res = new int[getLength(a1, a2)];
        int resIndex = 0;

        for(int i = 0; i < a1.length; i++){
            for(int j = 0; j < a2.length; j++){
                if(a1[i] == a2[j]) {
                    res[resIndex] = a1[i];
                    resIndex++;
                    while (j < a2.length - 1 && a2[j] == a2[j + 1]){
                        j++;
                    }
                }
            }
            while (i < a1.length - 1 && a1[i] == a1[i + 1]){
                i++;
            }
        }

        return res;

    }
    void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {      //swap elements if not in order
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    int getLength(int[] a1, int[] a2){
        int sum = 0;

        for(int i = 0; i < a1.length; i++){
            for(int j = 0; j < a2.length; j++){
                if(a1[i] == a2[j]) {
                    sum++;
                    while (j < a2.length - 1 && a2[j] == a2[j + 1]){
                        j++;
                    }
                }
            }
            while (i < a1.length - 1 && a1[i] == a1[i + 1]){
                i++;
            }
        }

        return sum;

    }


}
