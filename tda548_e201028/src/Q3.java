/*
        Solution to question 3 here.
 */

import static java.lang.System.*;

public class Q3 {

    public static void main(String[] args) {
        new Q3().program();
    }

    private void program() {
        int[] arr1 = {1, 2, 3, 4, 5, 5};
        int[] arr2 = {1, 2, 3, 3, 2, 1};
        int[] arr3 = {1, 1};
        int[] arr4 = {1, 1, 3};

        out.println(balanceArrray(arr1) == 3);
        out.println(balanceArrray(arr2) == 2);
        out.println(balanceArrray(arr3) == 0);
        out.println(balanceArrray(arr4) == -1);
    }

    public int balanceArrray(int[] arr) {
        // TODO write code and return correct value
        int x1 = 0;

        for(int i = 0; i < arr.length; i++){
            x1 += arr[i];
            int x2 = 0;
            for(int j = i + 1; j < arr.length; j++){
                x2 += arr[j];
            }
            if(x1 == x2) {
                out.println(arr[i]);
                return i;
            }
        }
        return -1;
    }


}
