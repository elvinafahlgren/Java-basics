//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package exercises;

import java.util.Arrays;
import java.util.Random;

public class Ex2ArrayMethods {
    static final Random rand = new Random();

    public Ex2ArrayMethods() {
    }

    public static void main(String[] args) {
        (new Ex2ArrayMethods()).program();
    }

    void program() {
        int[] arr = new int[]{1, 2, 2, 5, 3, 2, 4, 2, 7};
        System.out.println(this.count(arr, 2) == 4);
        System.out.println(this.count(arr, 7) == 1);
        arr = this.generateDistribution(100.0D, 0.25D, 0.25D);
        System.out.println(this.count(arr, 1) == 25);
        System.out.println(this.count(arr, -1) == 25);
        System.out.println(this.count(arr, 0) == 50);
        arr = this.generateDistribution(14.0D, 0.4D, 0.3D);
        System.out.println(this.count(arr, 1) == 6);
        System.out.println(this.count(arr, -1) == 4);

        for(int i = 0; i < 10; ++i) {
            this.shuffle(arr);
            System.out.println(Arrays.toString(arr));
        }

    }

    int count(int[] array, int number) {
        int total = 0;

        for(int i = 0; i < array.length; ++i) {
            if (array[i] == number) {
                ++total;
            }
        }

        return total;
    }

    int[] generateDistribution(double arrlength, double pos, double neg) {
        int[] array = new int[(int)arrlength];

        for(int i = 0; (long)i < Math.round(arrlength * neg); ++i) {
            array[i] = -1;
        }

        for(double i = (double)Math.round(arrlength * neg); i < (double)Math.round(arrlength * (pos + neg)); ++i) {
            array[(int)i] = 1;
        }

        return array;
    }

    int[] shuffle(int[] array) {
        for(int i = 0; i < array.length; ++i) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }

        return array;
    }
}
