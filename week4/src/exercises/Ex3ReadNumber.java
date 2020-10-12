package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
import static java.lang.Character.isDigit;
import static java.lang.Character.isDigit;

/*
 *   Extract numbers form Strings // TODO INTE KLAR
 *
 *   See:
 *  - UseCharacter
 *  - UseStringBuilder
 *  - UseAList
 *  - WhyInterface
 *  - Exceptions
 */
public class Ex3ReadNumber {

    public static void main(String[] args) {
        new Ex3ReadNumber().program();
    }

    void program() {
        List<String> numbers = new ArrayList<>();

        // Argument 0 is index to start looking for digits.
        // Return value is index directly after last read digit
        out.println(readNumber(numbers, "1", 0) == 1);
        // The number should be in the list numbers (method should add number to list)
        out.println(numbers.contains("1"));
        numbers.clear();

        out.println(readNumber(numbers, "123", 0) == 3);
        out.println(numbers.contains("123") && !numbers.contains("1"));
        numbers.clear();

        out.println(readNumber(numbers, "123abc", 0) == 3);
        out.println(numbers.contains("123"));
        numbers.clear();

        out.println(readNumber(numbers, "12345abc", 0) == 5);
        out.println(numbers.contains("12345"));
        numbers.clear();

        out.println(readNumber(numbers, "abc123abc", 3) == 6);
        out.println(numbers.contains("123"));

        // Empty string is not accepted will throw exception
        try {
            out.println(readNumber(numbers, "", 0) == 0);
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());   // Should print "Expr length is 0" or similar
        }
    }

    // ----------- Methods-----------------------------------

    int readNumber(List<String> numbers, String str, int startIndex){

        // We want to throw illegal argument is string is empty
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException("Expr length is 0");

        // Create new StringBuilder så we can build a new string
        StringBuilder word = new StringBuilder("");
        // Int that will count the last digits position
        int pos = 0;

        // Loop through string
        for(int i = 0; i < str.length(); i++){
            // If a letter is a digit, +1 to pos and put it in the StringBuilder word
            if(Character.isDigit(str.charAt(i))){
                pos++;
                word.append(str.charAt(i));
            }
        }
        // Add the created word to our list
        numbers.add(String.valueOf(word));
        // Return total position
        return startIndex + pos;
    }

}
