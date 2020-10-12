
package calc;

import java.util.*;

import static java.lang.Double.NaN;
import static java.lang.Double.parseDouble;
import static java.lang.Math.pow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 *   A calculator for rather simple arithmetic expressions
 *
 *   This is not the program, it's a class declaration (with methods) in it's
 *   own file (which must be named Calculator.java)
 *
 *   NOTE:
 *   - No negative numbers implemented
 */


class Calculator {

    // Here are the only allowed instance variables!
    // Error messages (more on static later)
    final static String MISSING_OPERAND = "Missing or bad operand";
    final static String DIV_BY_ZERO = "Division with 0";
    final static String MISSING_OPERATOR = "Missing operator or parenthesis";
    final static String OP_NOT_FOUND = "Operator not found";

    // Definition of operators
    final static String OPERATORS = "+-*/^";

    // Method used in REPL
    double eval(String expr) {
        if (expr.length() == 0) {
            return NaN;
        }
        List<String> tokens = tokenize(expr);
        List<String> postfix = infix2Postfix(tokens);
        return evalPostfix(postfix);
    }

    // ------  Evaluate RPN expression -------------------

    public double evalPostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<Double>();

        for(String current : postfix){
            // If current is an operator
            if(OPERATORS.contains(current)){
                // Perform a mathematical operation if there is two or more elements in stack
                if(stack.size() >= 2) {
                    double res = applyOperator(current, stack.pop(), stack.pop());
                    // Push result to stack
                    stack.push(res);
                }
                // Else, there isn't enough operands, throw exception
                else
                    throw new IllegalArgumentException(MISSING_OPERAND);

            }
            // Else (current is operand), push to stack
            else
                stack.push(parseDouble(current));
        }
        // If there are more than one operand left in stack, there isn't enough operators
        if(stack.size() > 1){
            throw new IllegalArgumentException(MISSING_OPERATOR);
        }
        return stack.pop();
    }




    double applyOperator(String op, double d1, double d2) {
        switch (op) {
            case "+":
                return d1 + d2;
            case "-":
                return d2 - d1;
            case "*":
                return d1 * d2;
            case "/":
                if (d1 == 0) {
                    throw new IllegalArgumentException(DIV_BY_ZERO);
                }
                return d2 / d1;
            case "^":
                return pow(d2, d1);
        }
        throw new RuntimeException(OP_NOT_FOUND);
    }

    // ------- Infix 2 Postfix ------------------------

    public List<String> infix2Postfix(List<String> tokens) {
        List<String> postfix = new LinkedList<>();
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < tokens.size(); i++)
            checkToken(tokens.get(i), stack, postfix);

        // Pop all operators from stack
        while (!stack.isEmpty()){
            postfix.add(stack.pop());
        }

        return postfix;
    }

    void checkToken(String current, Stack<String> stack, List<String> postfix){
        // If operand, add to postfix
        if(current.matches("\\d+"))
            postfix.add(current);

        // If "(", push it to the stack.
        else if (current.equals("("))
            stack.push(current);

        //  If ")", pop and output from the stack
        // until an '(' is encountered.
        else if (current.equals(")")) {
            // While stack isn't empty and first element in stack isn't "(", add to postfix.
            while (!stack.isEmpty() && !stack.peek().equals("("))
                postfix.add(stack.pop());

            // If first element in stack is "(", pop it
            if (!stack.isEmpty() && stack.peek().equals("("))
                stack.pop();

            // Missing "(", throw exception
            else
                throw new IllegalArgumentException(MISSING_OPERATOR);

        }

        // If operator, add to stack
        else{
            // If stack isn't empty and first element in stack isn't "("
            if(!stack.isEmpty() && !stack.peek().equals(")")){
                // While precedence of current operator is less than or equal to the precedence of first operator in stack
                while (!stack.isEmpty() && getPrecedence(current) <= getPrecedence(stack.peek())){
                    //If ^ operator is compared to ^ operator, we need to wait until there is a lower prioritized operator pushed to stack.
                    if(current.equals(stack.peek()) && getAssociativity(current) == Assoc.RIGHT)
                        break;
                    else
                        postfix.add(stack.pop());

                }
            }

            stack.push(current);
        }
    }


    int getPrecedence(String op) {
        if ("+-".contains(op)) {
            return 2;
        } else if ("*/".contains(op)) {
            return 3;
        } else if ("^".contains(op)) {
            return 4;
        } else {
            throw new RuntimeException(OP_NOT_FOUND);
        }
    }

    Assoc getAssociativity(String op) {
        if ("+-*/".contains(op)) {
            return Assoc.LEFT;
        } else if ("^".contains(op)) {
            return Assoc.RIGHT;
        } else {
            throw new RuntimeException(OP_NOT_FOUND);
        }
    }

    enum Assoc {
        LEFT,
        RIGHT
    }

    // ---------- Tokenize -----------------------

    public List<String> tokenize(String expr) {
        List<String> tokenized = new ArrayList<String>();

        // Matcher = class that performs operations on a string depending on a pattern
        // Pattern = a compiled (final) regular expression
        // Create a matcher (m) that contains a pattern and a target(expr) to perform operations with.
        // (\d+) = match a group of digits. NOTE: "+" in this case indicates that we want to match any amount of digits in a row
        // (\+|\*|\-|\/|\^|\(|\)) = match a group of +, *, -, /, ^, ( and )
        Matcher m = Pattern.compile("(\\d+)|(\\+|\\*|\\-|\\/|\\^|\\(|\\))").matcher(expr);
        // While the matcher can find new groups matching the regex expression to our string(expr) we add them to our list.
        while (m.find())
            tokenized.add(m.group());

        return tokenized;
    }


}


