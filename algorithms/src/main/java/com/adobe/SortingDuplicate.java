package com.adobe;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public final class SortingDuplicate {

    public static void main(final String[] args) {
        final int[] array = new int[] { 0, 2, 1, 2, 0 };
        long startTime = System.nanoTime();
        sortUsingMap(array);
        long endTime = System.nanoTime();
        long time = endTime - startTime;
        System.out.println(" Time Take = " + time);
        System.out.println();

        startTime = System.nanoTime();
        sortUsingCountSort(array);
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.println(" Time Take = " + time);
        System.out.println();

        startTime = System.nanoTime();
        sortOptimized(array);
        endTime = System.nanoTime();
        time = endTime - startTime;
        System.out.println(" Time Take = " + time);
    }

    private static void sortUsingMap(final int[] array) {
        final int[] sortedArray = new int[array.length];
        final Map<Integer, Integer> map = new TreeMap<>();
        for (final int value : array) {
            final Integer valueInMap = map.get(value);
            if (null == valueInMap) {
                map.put(value, 1);
            } else {
                map.put(value, valueInMap + 1);
            }
        }
        int sortedIndex = 0;
        for (final int key : map.keySet()) {
            int value = map.get(key);
            while (value > 0) {
                sortedArray[sortedIndex++] = key;
                value--;
            }
        }
        Arrays.stream(sortedArray).forEach(System.out::print);
    }

    private static void sortUsingCountSort(final int[] array) {
        final int[] countingArray = new int[3];
        final int[] sortedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            countingArray[array[i]] += 1;
        }
        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] = countingArray[i] + countingArray[i - 1];
        }
        for (int i = 0; i < array.length; i++) {
            sortedArray[countingArray[array[i]] - 1] = array[i];
            countingArray[array[i]] -= 1;
        }
        Arrays.stream(sortedArray).forEach(System.out::print);
    }

    private static void sortOptimized(final int[] array) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;
        while (mid <= high) {
            switch (array[mid]) {
            case 0: {
                final int temp = array[low];
                array[low] = array[mid];
                array[mid] = temp;
                low++;
                mid++;
                break;
            }
            case 1: {
                mid++;
                break;
            }
            case 2: {
                final int temp = array[high];
                array[high] = array[mid];
                array[mid] = temp;
                high--;
                mid++;
                break;
            }
            }
        }
        Arrays.stream(array).forEach(System.out::print);
    }
}