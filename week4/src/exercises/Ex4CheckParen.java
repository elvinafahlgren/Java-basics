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
        out.println(checkParentheses("()"));
        out.println(checkParentheses("(()())"));
        out.println(!checkParentheses("(()))")); // Unbalanced
        out.println(!checkParentheses("((())")); // Unbalanced

        out.println(checkParentheses("({})"));
        out.println(!checkParentheses("({)}"));  // Bad nesting
        out.println(checkParentheses("({} [()] ({}))"));
        out.println(!checkParentheses("({} [() ({)})"));  // Unbalanced and bad nesting

    }

    // ----------- Methods -------------------------
    boolean checkParentheses(String str){
        str = str.replaceAll("\\s+","");

        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            if (current == '(' || current == '[' || current == '{'){
                stack.push(current);
                continue;
            }

            // If stack is empty, current char is not opening bracket, it must be closing
            if(stack.isEmpty())
                return false;

            if(matching(current) == stack.peek()){
                stack.pop();
            }
        }

        return stack.isEmpty();
    }


    // This is interesting because have to return, but what if no match?!?
    char matching(char ch) {
        //char c =  must initialize but to what?!
        char c = ' ';
        switch (ch) {
            case ')':
                return '(';  // c = '('
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return c;
                // throw new IllegalArgumentException("No match found");
        }
    }
}
/*
    boolean checkParentheses(String str){

        str = str.replaceAll("\\s+","");
        List<String> list = new LinkedList<>(Arrays.asList(str.split("")));
        Stack<Character> stack = new Stack<>();

        //out.println(list);
        // First step is to fill the stack with the first element in list
        stack.push(list.get(0).charAt(0));
        list.remove(0);


        while(!list.isEmpty()) {

            // If just one element in list and none in stack, then we know it's false
            if(stack.isEmpty() && list.size() == 1)
                return false;

            // If the first element in list matches the first element in stack, pop the stack
            if(matching(list.get(0).charAt(0)) == stack.peek()){
                //out.println("do we even get here");
                stack.pop();
            }

            // Else, we want to keep pushing first element from list to stack
            else {
                stack.push(list.get(0).charAt(0));
            }

            // Either way, remove first element from list
            list.remove(0);
            //out.println("lista: " + list);
            //out.println("stack: " + stack);

        }

        return stack.isEmpty();
    }
    */
