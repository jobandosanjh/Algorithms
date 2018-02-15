package com.nagarro.algorithms.recursive;

public final class Multiply {

    public static void main(final String[] args) {
        System.out.println(fun(4, 3));
    }

    private static int fun(int a, int b) {
        if (b == 0)
            return 0;
        if (b % 2 == 0)
            return fun(a + a, b / 2);

        return fun(a + a, b / 2) + a;
    }
}
