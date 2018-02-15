package com.nagarro.algorithms.sorting;

import java.util.Arrays;

public final class RemoveDuplicates {

    public static void main(final String[] args) {
        final int[] array = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5 };
        removeDuplicates(array);
    }

    private static void removeDuplicates(final int[] array) {
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[i] != array[j]) {
                array[++i] = array[j];
            }
        }
        int output[] = new int[i + 1];
        for (int k = 0; k < output.length; k++) {
            output[k] = array[k];
        }
        Arrays.stream(output).forEach(System.out::println);
    }
}
