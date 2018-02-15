package com.nagarro.algorithms.stack;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public final class InfixToPostfix {

    private String[] operatorStack;
    private Map<String, Integer> operands = ImmutableMap.<String, Integer> of("+", 16, "-", 16, "*", 18, "/", 16);

    public String getPostfixExpression(final String infix) {
        final StringBuilder postfixExpression = new StringBuilder();
        operatorStack = new String[infix.length()];
        int top = -1;
        for (final char ch : infix.toCharArray()) {
            if (operands.containsKey(String.valueOf(ch))) {
                if (top < 0) {
                    operatorStack[++top] = String.valueOf(ch);
                } else {
                    String poppedChar = operatorStack[top--];
                    if (!poppedChar.equals("(")) {
                        final int precidence = operands.get(String.valueOf(ch));
                        int nextPrecidence = operands.get(poppedChar);
                        if (precidence > nextPrecidence) {
                            top++;
                        }
                        while (precidence <= nextPrecidence) {
                            postfixExpression.append(poppedChar);
                            if (top >= 0) {
                                poppedChar = operatorStack[top--];
                                if (!operands.containsKey(poppedChar)) {
                                    break;
                                }
                                nextPrecidence = operands.get(poppedChar);
                            } else {
                                nextPrecidence = Integer.MIN_VALUE;
                            }
                        }
                    }
                    operatorStack[++top] = String.valueOf(ch);
                }
            } else if (ch == '(') {
                operatorStack[++top] = String.valueOf(ch);
            } else if (ch == ')') {
                while (top >= 0 && !operatorStack[top].equals("(")) {
                    postfixExpression.append(operatorStack[top--]);
                }
            } else {
                postfixExpression.append(ch);
            }
        }
        while (top >= 0) {
            postfixExpression.append(operatorStack[top--]);
        }
        return postfixExpression.toString();
    }

    public static void main(final String[] args) {
        final InfixToPostfix infixToPrefix = new InfixToPostfix();
        System.out.println(infixToPrefix.getPostfixExpression("A*(B+C*D)+E"));
    }

}
