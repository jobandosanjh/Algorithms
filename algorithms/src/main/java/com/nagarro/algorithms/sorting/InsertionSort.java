package com.nagarro.algorithms.sorting;

import java.util.Arrays;

public final class InsertionSort {

    public static void main(final String[] args) {
        final int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        System.out.println("Before Sorting :");
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
        sort(array);
    }

    private static void sort(final int[] array) {
        final long startTime = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    final int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        final long endTime = System.nanoTime();
        System.out.println("Total Execution Time = " + (long) (endTime - startTime));
        System.out.println("After Sorting :");
        Arrays.stream(array).forEach(System.out::print);
    }

}
