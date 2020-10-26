package exercises.exam200107;

import java.util.Arrays;

import static java.lang.System.out;

public class uppg3 {
    public static void main(String[] args) {
        new uppg3().program();
    }

    private void program() {
        int[] arr1 = {1};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {5, 1};
        int[] arr4 = {2, 3, 4, 3};

        out.println(Arrays.toString(expand(arr1)));
        out.println(Arrays.toString(expand(arr2)));
        out.println(Arrays.toString(expand(arr3)));
        out.println(Arrays.toString(expand(arr4)));
    }


    //från genomgång
    int[] expand(int[] arr){
        int[] res = new int[getExpandedLength(arr)];
        res[0] = arr[0];
        int resIndex = 1;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i]; j++){
                if(resIndex < res.length) {
                    res[resIndex] = arr[i + 1];
                    resIndex++;
                }
            }
        }

        return res;
    }



    int getExpandedLength(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum++;
        }
        for(int i = 0; i < arr.length - 1; i++){
            sum += (arr[i] - 1);
        }
        return sum;
    }
}
