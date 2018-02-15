package com.nagarro.algorithms.backtracking;

public final class BinaryString {

    private static int array[] = new int[10];

    public static void main(final String[] args) {
        binary(2);
    }

    private static void binary(final int n) {
        if (n < 1) {
            System.out.println(array);
        } else {
            array[n - 1] = 0;
            binary(n - 1);
            array[n - 1] = 1;
            binary(n - 1);
        }

    }

}
