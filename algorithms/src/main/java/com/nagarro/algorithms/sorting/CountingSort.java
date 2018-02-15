package com.nagarro.algorithms.sorting;

import java.util.Arrays;

public final class CountingSort {

    public static void main(final String[] args) {
        final int[] array = { 1, 4, 1, 2, 7, 5, 2, 2, 4, 5, 6, 8, 9, 9 };
        System.out.println("Before Sorting :");
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
        sort(array);
    }

    private static void sort(final int[] array) {
        final long startTime = System.nanoTime();
        final int[] sortedArray = new int[20];
        final int[] countingArray = new int[10];
        for (int i = 0; i < array.length; i++) {
            ++countingArray[array[i]];
        }

        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] = countingArray[i] + countingArray[i - 1];
        }

        for (int i = 0; i < array.length; i++) {
            sortedArray[countingArray[array[i]]--] = array[i];
        }
        final long endTime = System.nanoTime();
        System.out.println("Total Execution Time = " + (long) (endTime - startTime));
        System.out.println("After Sorting");
        Arrays.stream(sortedArray).filter(i -> i != 0).forEach(System.out::print);
    }
}
