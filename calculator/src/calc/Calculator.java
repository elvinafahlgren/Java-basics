package calc;

import java.util.*;

import static java.lang.Double.NaN;
import static java.lang.Double.parseDouble;
import static java.lang.Math.pow;


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
            if(OPERATORS.contains(current)){
                if(stack.size() >= 2) {
                    double res = applyOperator(current, stack.pop(), stack.pop());
                    stack.push(res);
                }
                else
                    throw new IllegalArgumentException(MISSING_OPERAND);

            }
            else
                stack.push(parseDouble(current));
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
        for(int i = 0; i < tokens.size(); i++){
            String current = tokens.get(i);

            // Check if operand, add to postfix
            if(current.matches("\\d+")) {
                postfix.add(current);
            }

            // If "(", push it to the stack.
            else if (current.equals("(")){
                stack.push(current);
            }

            //  If ")", pop and output from the stack
            // until an '(' is encountered.
            else if (current.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.add(stack.pop());
                }

                // Pop the "("
                if (!stack.isEmpty() && stack.peek().equals("("))
                    stack.pop();
                else
                    throw new IllegalArgumentException(MISSING_OPERATOR);

            }

            // If operator, add to stack
            else{
                if(!stack.isEmpty() && !stack.peek().equals("(")){
                    while (!stack.isEmpty() && getPrecedence(current) <= getPrecedence(stack.peek())){
                        //If ^ operator is compared to ^ operator, we need to wait untill there is a lower prioritized operator pushed to stack.
                        if(current.equals(stack.peek()) && getAssociativity(current) == Assoc.RIGHT)
                            break;
                        else
                            postfix.add(stack.pop());

                    }
                }
                stack.push(current);
            }

        }
        // Pop all operators from stack
        while (!stack.isEmpty()){
            postfix.add(stack.pop());
        }

        return postfix;
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
        List<String> tokenized = Arrays.asList(expr.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)|(?<=\\D)(?=\\D)"));   //(?<=\d) means the previous character is a digit

        findOperator(tokenized);

        expr = expr.replaceAll("\\s+","");
        tokenized = Arrays.asList(expr.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)|(?<=\\D)(?=\\D)"));   //(?<=\d) means the previous character is a digit



        //(?=\D) means the next character is a non-digit
        //(?<=\d)(?=\D) together will match between a digit and a non-digit
        //(?<=\D)(?=\D)
        //regexA|regexB means either regexA or regexB is matched, which is
        //...used as above points, but non-digit then digit for the visa-versa logic
        return tokenized;
    }



    void findOperator(List<String> tokenized ){
        int oprand = 0;
        int oprat = 0;

        for(String token : tokenized){
            if(OPERATORS.contains(token))
                oprat++;
            else if(token.matches("\\d+"))
                oprand++;
        }

        // If there is not enough operators, throw illegal argument
        if(oprand - 1 > oprat)
            throw new IllegalArgumentException(MISSING_OPERATOR);

        // If there is not enough operands, throw illegal argument
        else if(oprand - 1 < oprat)
            throw new IllegalArgumentException(MISSING_OPERAND);

    }


}
