package exercises;

import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *
 *  Use a Stack to check parentheses (balanced and correct nesting)
 *  The parentheses are: (), [] and {}
 *
 *  See:
 *  - UseAStack
 *  - WhyInterface
 *  - SwitchStatement
 *
 */
public class Ex4CheckParen {

    public static void main(String[] args) {
        new Ex4CheckParen().program();
    }

    void program() {
        // All should be true
        //out.println(checkParentheses("()"));
        //out.println(checkParentheses("(()())"));
        //out.println(!checkParentheses("(()))")); // Unbalanced
        //out.println(!checkParentheses("((())")); // Unbalanced

        //out.println(checkParentheses("({})"));
        //out.println(!checkParentheses("({)}"));  // Bad nesting
        //out.println(checkParentheses("({} [()] ({}))"));
        //out.println(!checkParentheses("({} [() ({)})"));  // Unbalanced and bad nesting

    }

    // ----------- Methods -------------------------
    boolean checkParentheses(String str){
        List<String> list = new LinkedList<>(Arrays.asList(str));
        out.println(list);
        return true;
    }


    // This is interesting because have to return, but what if no match?!?
    char matching(char ch) {
        //char c =  must initialize but to what?!
        switch (ch) {
            case ')':
                return '(';  // c = '('
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                // return c;
                throw new IllegalArgumentException("No match found");
        }
    }
}
