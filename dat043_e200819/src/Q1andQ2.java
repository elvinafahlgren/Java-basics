
/*
        Solution to combined question 1 and 2 here.
 */

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Q1andQ2 {

    public static void main(String[] args) {
        new Q1andQ2().program();
    }

    final Scanner sc = new Scanner(in);

    private void program() {
        // TODO Write program here

        out.print("Första talet ? ");
        int x1 = sc.nextInt();

        out.print("Andra talet ? ");
        int x2 = sc.nextInt();

        out.print("Tredje talet ? ");
        int x3 = sc.nextInt();

        int diff1 = x2 - x1;
        int diff2 = x3 - x2;
        int changeDiff = diff2 - diff1;
        int res = x1;

        out.print("Talföljden: ");
        for(int i = 1; i <= 10; i++){
            out.print(res + ", ");
            res += diff1;
            diff1 += changeDiff;
        }
    }

}
