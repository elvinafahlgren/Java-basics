package exercises;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Even more array methods, possibly even harder ...
 */
public class Ex4MedianKthSmallest {

    public static void main(String[] args) {
        new Ex4MedianKthSmallest().program();
    }

    void program() {
        int[] arr1 = {9, 3, 0, 1, 3, -2};

        out.println(!isSorted(arr1));  // Is sorted increasing? No not yet!

        sort(arr1);     // Sort in increasing order original order lost!

        out.println(Arrays.toString(arr1).equals("[-2, 0, 1, 3, 3, 9]"));

        out.println(isSorted(arr1));  // Is sorted increasing? Yes!

        int[] arr2 = {5, 4, 2, 1, 7, 0, -1, -4, 12};
        int[] arr3 = {2, 3, 0, 1};
        out.println(median(arr2) == 2);    // Calculate median of elements
        out.println(median(arr3) == 1.5);

        int[] arr4 = {2, 3, 0, 1, 5, 4};
        int[] arr5 = {5, 4, 2, 2, 1, 7, 4, 0, -1, -4, 0, 0, 12};
        out.println(kSmallest(arr4, 2) == 1);   // Second smallest is 1
        out.println(kSmallest(arr5, 5) == 2);   // 5th smallest is 2

    }

    // ---------- Write methods here --------------
    boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            // If next value in arr is smaller, then the array isn't sorted.
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    void sort(int[] arr){

        //{9, 3, 0, ...} 3<9 (switch places), 3!<0, ...
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    double median(int[] arr){
        int l = arr.length;
        double med = 0;
        sort(arr);

        if (l % 2 == 1) {
            med = arr[(l - 1) / 2];
        }
        else
            med = (double)(arr[l / 2] + arr[l / 2 - 1]) / 2;

        return med;
    }

    int kSmallest(int[] arr, int k){
        int comp = 0;
        sort(arr);
        for(int i = 0; i < arr.length - 1; i++){
            // If next value isn't the same as current value, count
            if(arr[i] != arr[i + 1])
                comp++;

            // When we have counted to k, then return current value
            if(comp == k)
                return arr[i];

        }
        return arr[arr.length - 1];
    }

}
