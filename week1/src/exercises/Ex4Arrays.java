package exercises;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * Program to exercise arrays
 *
 * See:
 * - ArrayBasics
 */
public class Ex4Arrays {

    public static void main(String[] args) {
        new Ex4Arrays().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // TODO
        out.print("Input 5 integers (space between, then enter) > ");
        String s[] = sc.nextLine().split(" ");

        out.println("Array is: " + Arrays.toString(s));

        out.print("Input a value to find > ");

        int value = sc.nextInt();

        for(int i = 0; i < s.length; i++){
            if(Integer.parseInt(s[i]) == value){
                out.println("Value " + value + " is at index " + i);
                break;
            }
            else if(i == s.length - 1){
                out.println("Value not found");
            }
        }
    }
}
