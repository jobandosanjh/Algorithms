package com.nagarro.algorithms.stack;

import java.util.Arrays;
import java.util.Collection;

public final class PostfixEvaluation {

    private String[] stack;
    private Collection<String> operands = Arrays.asList("+", "-", "*", "/");

    public String evaluatePostfixExpression(final String infix) {
        stack = new String[infix.length()];
        int top = -1;
        for (final char ch : infix.toCharArray()) {
            if (operands.contains(String.valueOf(ch))) {
                if (top < 1) {
                    throw new AssertionError("Invalid Expression");
                }
                final int x = Integer.valueOf(stack[top]);
                stack[top--] = null;
                final int y = Integer.valueOf(stack[top]);
                stack[top--] = null;
                final int result;
                switch (ch) {
                case '/':
                    result = x / y;
                    break;
                case '*':
                    result = x * y;
                    break;
                case '-':
                    result = x - y;
                    break;
                default:
                    result = x + y;
                }
                stack[++top] = String.valueOf(result);
            } else if (ch != '(' && ch != ')') {
                stack[++top] = String.valueOf(ch);
            }
        }
        return stack[top];
    }

    public static void main(final String[] args) {
        final PostfixEvaluation infixToPostfix = new PostfixEvaluation();
        System.out.println(infixToPostfix.evaluatePostfixExpression("231*+9-"));
    }

}
