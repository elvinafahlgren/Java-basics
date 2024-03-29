package exercises;

import java.util.Arrays;

import static java.lang.System.*;

/*
 *  Some harder array methods
 */
public class Ex2ArrayMethods {


    public static void main(String[] args) {
        new Ex2ArrayMethods().program();
    }

    void program() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};

        // Rotate all elements in the arr k steps to the right (in a circular fashion)
        // Assume arr.length > 0. NOTE: Original array changed!
        rotate(arr1, 3);
        //out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(arr1, 0);
        //out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(arr1, arr1.length);
        //out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(new int[]{1}, 3);

        // Same as above but here we have a return value
        int[] r = rotate2(new int[]{1, 2, 3, 4, 5}, 2);  // Return value!
        //out.println(Arrays.toString(r).equals("[4, 5, 1, 2, 3]"));
        r = rotate2(new int[]{1, 2, 3, 4, 5}, 5);  // Return value!
        //out.println(Arrays.toString(r).equals("[1, 2, 3, 4, 5]"));


        int[] arr2 = {1, 2, 2, 3, 3};   // All sorted in increasing order
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {1, 1, 1, 1, 1, 1};
        int[] arr5 = {1};

        // Remove all duplicates from arr2, ... (original unchanged, copy created)
        // NOTE: Assume arr is sorted in increasing order and > 0
        //out.println(Arrays.toString(removeDupl(arr2)).equals("[1, 2, 3]"));
        //out.println(Arrays.toString(arr2).equals("[1, 2, 2, 3, 3]"));   // arr2 unchanged!
        //out.println(Arrays.toString(removeDupl(arr3)).equals("[1, 2, 3, 4, 5]"));
        //out.println(Arrays.toString(removeDupl(arr4)).equals("[1]"));
        //out.println(Arrays.toString(removeDupl(arr5)).equals("[1]"));


        arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        // Use fact that array is sorted to search efficiently
        out.println(search(arr1, 1) == 0);
        out.println(search(arr1, 3) == 2);
        out.println(search(arr1, 8) == 7);

    }

    // -------------- Methods --------------------------
    void rotate(int[] arr1, int steps) {
        for (int i = 0; i < steps; i++) {
            //stores the last element of array
            int last = arr1[arr1.length - 1];
            for (int j = arr1.length - 1; j > 0; j--) {
                //shift element of array by one
                arr1[j] = arr1[j - 1];
            }
            //last element of array will be added to the start of array
            arr1[0] = last;
        }

    }

    int[] rotate2(int[] arr, int steps) {
        for (int i = 0; i < steps; i++) {
            //stores the last element of array
            int last = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                //shift element of array by one
                arr[j] = arr[j - 1];
            }
            //last element of array will be added to the start of array
            arr[0] = last;
        }
        return arr;
    }

    int[] removeDupl(int[] arr) {
        //temporär array
        int[] temp = new int[arr.length];

        int j = 0;
        int length = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            //om det nuvarande värdet i arrayen
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i];
                length++;
            }
        }
        temp[j++] = arr[arr.length - 1];

        //ny array med den nya längden, lägger in all data från temp arrayen
        int[] newArr = new int[length];
        for (int i = 0; i < length; i++) {
            newArr[i] = temp[i];
        }
        return newArr;
    }

    /*
    int search(int[] arr, int x){

        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x){
                index = i;
            }
        }


        return index;
    }
    */

    int search(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

            // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }
}
