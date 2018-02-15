package com.nagarro.algorithms.sorting;

import java.util.Arrays;

public final class QuickSort {

    public static void main(final String[] args) {
        final int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        System.out.println("Before Sort :");
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
        final long startTime = System.nanoTime();
        sort(array, 0, array.length - 1);
        final long endTime = System.nanoTime();
        System.out.println("Total Execution Time = " + (long) (endTime - startTime));
        System.out.println("After Sort :");
        Arrays.stream(array).forEach(System.out::print);
    }

    private static int partition(final int array[], final int low, final int high) {
        final int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                final int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        final int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private static void sort(final int array[], final int low, final int high) {
        if (low < high) {
            final int pi = partition(array, low, high);
            sort(array, low, pi - 1);
            sort(array, pi + 1, high);
        }
    }

}
