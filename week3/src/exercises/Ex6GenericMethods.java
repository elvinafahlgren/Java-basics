package exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

/*
 * Implement generic versions of shuffle and sort
 *
 *  See:
 *  - WrapperTypes
 *  - GenericMethod
 */
public class Ex6GenericMethods {

    public static void main(String[] args) {
        new Ex6GenericMethods().program();
    }

    final Random rand = new Random();

    void program() {

        // Working with wrapper types, generic methods only work with reference types
        Integer[] is = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String origIs = Arrays.toString(is);
        String[] ss = {"a", "b", "c", "d", "e"};
        String origSS = Arrays.toString(ss);

        // diffIndex works for all arrays reference types
        out.println(diffIndex(is, is) == -1);
        out.println(diffIndex(ss, ss) == -1);

        // shuffle should be a generic method, so we can use it for Integers ...
        shuffle(is);
        out.println(!Arrays.toString(is).equals(origIs));  // May be false, but unlikely
        // ... and here for String.
        shuffle(ss);
        out.println(!Arrays.toString(ss).equals(origSS));

        // sort should also be generic (this is hard)
        sort(is);
        out.println(Arrays.toString(is).equals(origIs));
        sort(ss);
        out.println(Arrays.toString(ss).equals(origSS));

    }

    // ------- Methods -------------------------

    <T> int diffIndex(T[] arr0, T[] arr1){
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

    <T> void shuffle(T[] arr){
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndexToSwap = rand.nextInt(arr.length);
            T temp = arr[randomIndexToSwap];
            arr[randomIndexToSwap] = arr[i];
            arr[i] = temp;
        }
    }

    <T extends Comparable<? super T>> void sort(T[] arr){


        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0 ){    // Sort generic method, see https://cs.brynmawr.edu/Courses/cs206/fall2013/slides/08_Sorting_GenericMethod.pdf
                    sorted = false;
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        /*
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) < 0) {         // Sort generic method, see https://cs.brynmawr.edu/Courses/cs206/fall2013/slides/08_Sorting_GenericMethod.pdf
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        */
    }

}
