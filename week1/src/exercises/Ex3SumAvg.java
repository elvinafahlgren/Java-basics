package exercises;

import java.util.Scanner;

import static java.lang.System.*;;

/*
 * Program to calculate sum and average for non-negative integers
 *
 * See:
 * - Loops (while only)
 * - LoopAndAHalf
 *
 */
public class Ex3SumAvg {

    public static void main(String[] args) {
        new Ex3SumAvg().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Write your code here
        int count = 0;
        int sum = 0;
        double avg = 0;

        // -- Input (and bookkeeping)
        int tal = sc.nextInt();

        while(tal >= 0) {
            sum += tal;
            count++;
            tal = sc.nextInt();
        }

        // -- Process---
        avg = (double)sum / (double)count;

        // -- Output ----
        out.println("Sum = " + sum + ". Avg = " + avg);
    }

}
