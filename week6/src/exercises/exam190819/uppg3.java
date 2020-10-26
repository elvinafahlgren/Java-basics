package exercises.exam190819;

import java.util.Arrays;

public class uppg3 {
    public static void main(String[] args) {
        new exercises.exam190819.uppg3().program();
    }

    private void program() {

        int[] arr = {1, 2, 3, 4, 5};
        int[] order1 = {0, 4, 1, 3, 2};
        int[] order2 = {4, 3, 1, 0, 2};
        int[] order3 = {1, 0, 4, 2, 3};

        reorder(order1, arr);
        System.out.println(Arrays.toString(arr));
        /*
        reorder(order2, arr);
        System.out.println(Arrays.toString(arr));

        reorder(order3, arr);
        System.out.println(Arrays.toString(arr));
        */
    }

    void reorder(int[] order, int[] arr){
        int[] tmp = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            tmp[order[i]] = arr[i];
        }

        for(int i = 0; i < tmp.length; i++){
            arr[i] = tmp[i];
        }

    }
}
