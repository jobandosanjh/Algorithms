package com.nagarro.algorithms.stack;

public final class InfixToPrefix {

    public static void main(final String[] args) {
        final InfixToPrefix prefixToPostfix = new InfixToPrefix();
        System.out.println(prefixToPostfix.getPostfix("A+B"));
    }

    public String getPostfix(final String prefix) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            stringBuilder.append(prefix.charAt(i));
        }
        final String temp = stringBuilder.toString();
        temp.replace(")", "(");
        temp.replace("(", ")");
        final String postfix = new InfixToPostfix().getPostfixExpression(temp);
        return new StringBuilder(postfix).reverse().toString();
    }
}
