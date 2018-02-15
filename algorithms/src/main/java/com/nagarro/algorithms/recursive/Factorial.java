package com.nagarro.algorithms.recursive;

public class Factorial {

    public static void main(final String[] args) {
        System.out.println(fact(16));
    }

    private static int fact(final int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }
}
