package com.nagarro.algorithms.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public final class SlidingWindow {

    public static void main(final String[] args) {
        final int window = 5;
        Arrays.stream(getMax(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, window)).forEach(System.out::println);
        System.out.println("Second");
        Arrays.stream(getMaxUsingQueue(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, window)).forEach(System.out::println);
    }

    private static int[] getMax(final int[] array, final int window) {
        final int[] maxArray = new int[array.length - (window - 1)];
        for (int i = 0; i < array.length - window + 1; i++) {
            int max = array[i];
            for (int j = i; j < i + window; j++) {
                if (max < array[j]) {
                    max = array[j];
                }
            }
            maxArray[i] = max;
        }
        return maxArray;
    }

    private static int[] getMaxUsingQueue(final int[] array, final int window) {
        final int[] maxArray = new int[array.length - (window - 1)];
        final Queue<Integer> queue = new PriorityQueue<>(window, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < array.length - window + 1; i++) {
            for (int j = i; j < i + window; j++) {
                queue.offer(array[j]);
            }
            maxArray[i] = queue.poll();
            queue.clear();
        }
        return maxArray;
    }

}
