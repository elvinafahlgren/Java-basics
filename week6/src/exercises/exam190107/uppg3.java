package exercises.exam190107;

public class uppg3 {
    public static void main(String[] args) {
        new exercises.exam190107.uppg3().program();
    }

    private void program() {

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 1, 3, 4, 5, 6, 7, 8};
        int[] arr4 = {5, 5, 4, 4, 3, 8, 8, 8};
        int[] arr5 = {1, 1, 1, 1};

        System.out.println(klumps(arr1) == 0);
        System.out.println(klumps(arr2) == 1);
        System.out.println(klumps(arr4) == 3);
        System.out.println(klumps(arr5) == 1);
    }

    int klumps(int[] arr){
        int klumpar = 0;

        for(int i = 0; i < arr.length - 1; i++){

            if(arr[i] == arr[i + 1]) {
                klumpar++;

                while (i < arr.length - 1 && arr[i] == arr[i + 1]){
                    i++;
                }
            }
        }
        return klumpar;
    }

}
