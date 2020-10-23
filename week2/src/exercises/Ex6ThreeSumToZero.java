//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package exercises;

import java.util.Arrays;

public class Ex6ThreeSumToZero {
    public Ex6ThreeSumToZero() {
    }

    public static void main(String[] args) {
        (new Ex6ThreeSumToZero()).program();
    }

    void program() {
        int[] arr1 = new int[]{-25, -10, -7, -3, 2, 4, 8, 10};
        int[] arr2 = new int[]{0, 1, 2, 4, 8, 10};
        int[] arr3 = new int[]{-2, 1, 1};
        int[] arr4 = new int[]{0, 0, 0, 0};
        System.out.println(Arrays.toString(this.getThreeSum(arr1)));
        System.out.println(Arrays.toString(this.getThreeSum(arr2)));
        System.out.println(Arrays.toString(this.getThreeSum(arr3)));
        System.out.println(Arrays.toString(this.getThreeSum(arr4)));
    }

    int[] getThreeSum(int[] arr) {
        for(int i = 0; i < arr.length; ++i) {
            for(int j = 1; j < arr.length; ++j) {
                for(int k = 2; k < arr.length; ++k) {
                    if (arr[i] + arr[j] + arr[k] == 0 && i != j && i != k && j != k) {
                        int[] indexArr = new int[]{i, j, k};
                        return indexArr;
                    }
                }
            }
        }

        int[] empty = new int[0];
        return empty;
    }
}
