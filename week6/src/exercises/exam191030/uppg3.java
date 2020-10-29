package exercises.exam191030;

import java.util.Arrays;

import static java.lang.System.out;

public class uppg3 {
    public static void main(String[] args) {
        new exercises.exam191030.uppg3().program();
    }

    private void program() {
        int[] arr1 = {1, 2, 2, 3};
        int[] arr2 = {1, 2, 4, 3, 5, 2, 7, 1};
        int[] arr3 = {2, 2, 4, 3, 5, 3, 7, 7};

        out.println(nDuplicates(arr1));
        out.println(nDuplicates(arr2));
        out.println(nDuplicates(arr3));
    }

    int nDuplicates(int[] arr){
        int nDup = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] == arr[j]) {
                    nDup++;
                }
            }
        }
        return nDup;
    }
}
