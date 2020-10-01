package exercises;

import static java.lang.Math.abs;
import static java.lang.System.out;

/*
 * Finding point of inequality in "any" type of array, i.e. where they differ
 *
 * See:
 * - Overloading
 */
public class Ex5PointOfInequality {

    public static void main(String[] args) {
        new Ex5PointOfInequality().program();
    }

    void program() {
        int[] a0 = {1, 2};
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {1, 2, 33, 4, 5};
        double[] d1 = {1.0, 2, 33, 4.5, 6.7};
        double[] d2 = {1.0, 2, 33, 4.5, 6.711};
        String[] s1 = {"a", "b", "c", "d", "e"};
        String[] s2 = {"a", "bb", "c", "d", "e"};

        // All should print true
        out.println(diffIndex(a1, a2) == 2);  // First index from left where they differ
        out.println(diffIndex(a1, a1) == -1); // No diff
        out.println(diffIndex(a0, a1) == -1);
        out.println(diffIndex(d1, d2) == 4);
        out.println(diffIndex(s1, s2) == 1);
    }

    // ----------- Method(s) -----------------------

    int diffIndex(int[] arr0, int[] arr1){
        int length = 0;
        if (arr0.length < arr1.length)
            length = arr0.length;
        else
            length = arr1.length;

        for(int i = 0; i < length; i++){
            if(arr0[i] != arr1[i])
                return i;
        }
        return -1;
    }

    int diffIndex(double[] arr0, double[] arr1){
        int length = 0;
        if (arr0.length < arr1.length)
            length = arr0.length;
        else
            length = arr1.length;

        for(int i = 0; i < length; i++){
            if(arr0[i] != arr1[i])
                return i;
        }
        return -1;
    }
    int diffIndex(String[] arr0, String[] arr1){
        int length = 0;
        if (arr0.length < arr1.length)
            length = arr0.length;
        else
            length = arr1.length;

        for(int i = 0; i < length; i++){
            if(arr0[i] != arr1[i])
                return i;
        }
        return -1;
    }


}
