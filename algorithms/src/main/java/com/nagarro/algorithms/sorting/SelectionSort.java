package com.nagarro.algorithms.sorting;

import java.util.Arrays;

public final class SelectionSort {

    public static void main(final String[] args) {
        final int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        System.out.println("Before Sorting :");
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
        sort(array);
    }

    private static void sort(final int[] array) {
        final long startTime = System.nanoTime();
        final int totalPass = array.length - 1;
        for (int i = 0; i < totalPass; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                final int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        final long endTime = System.nanoTime();
        System.out.println("Total Execution Time = " + (long) (endTime - startTime));
        System.out.println("After Sorting :");
        Arrays.stream(array).forEach(System.out::print);
    }

}
