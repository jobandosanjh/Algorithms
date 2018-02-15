package com.nagarro.algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;

public final class BucketSort {

    public static void main(final String[] args) {
        final double[] array = { 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0.0, 0.12, 0.99, 0.98 };
        System.out.println("Before Sorting :");
        Arrays.stream(array).forEach(System.out::println);
        System.out.println();
        sort(array);
    }

    @SuppressWarnings("unchecked")
    private static void sort(final double[] array) {
        final int totalBuckets = array.length;
        final double[] sortedArray = new double[array.length];
        final LinkedList<Double>[] buckets = new LinkedList[totalBuckets];
        for (int i = 0; i < array.length; i++) {
            final int bucketPosition = (int) (array[i] * totalBuckets);
            final LinkedList<Double> list = buckets[bucketPosition];
            if (null == list) {
                final LinkedList<Double> newList = new LinkedList<>();
                newList.add(array[i]);
                buckets[bucketPosition] = newList;
            } else {
                list.addFirst(array[i]);
            }
        }
        int i = 0;
        for (final LinkedList<Double> bucket : buckets) {
            if (null != bucket) {
                final double[] unsortedBucket = new double[bucket.size()];
                int j = 0;
                for (final double element : bucket) {
                    unsortedBucket[j++] = element;
                }
                insertionSort(unsortedBucket);
                for (final double element : unsortedBucket) {
                    sortedArray[i++] = element;
                }
            }
        }
        System.out.println("After Sorting :");
        Arrays.stream(sortedArray).forEach(System.out::println);
    }

    private static void insertionSort(final double[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    final double temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
