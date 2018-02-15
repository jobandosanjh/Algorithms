package com.nagarro.algorithms.sorting;

import java.util.Arrays;

public final class MergeSort {

    public static void main(final String[] args) {
        final int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        System.out.println("Before Sort :");
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
        sort(array);
    }

    private static void sort(final int[] array) {
        final long startTime = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        final long endTime = System.nanoTime();
        System.out.println("Total Execution Time = " + (long) (endTime - startTime));
        System.out.println("After Sort :");
        Arrays.stream(array).forEach(System.out::print);
    }

    private static void mergeSort(final int[] array, final int left, final int right) {
        if (right > left) {
            final int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(final int[] array, final int left, final int mid, final int right) {
        final int n1 = mid - left + 1;
        final int n2 = right - mid;

        final int[] leftArray = new int[n1];
        final int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }
}
