package com.nagarro.algorithms.searching;

public final class LinearSearch {

    public static void main(final String[] args) {
        final int[] array = { 9, 7, 8, 6, 4, 5, 3, 2, 1, 0 };
        unorderedSearch(array, 9);

        final int[] sortedArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        orderedSearch(sortedArray, 1);
    }

    private static void unorderedSearch(final int[] array, final int data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == data) {
                System.out.println("Data Found At Position " + i);
                return;
            }
        }
        System.out.println("No Match Found");
    }

    private static void orderedSearch(final int[] array, final int data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == data) {
                System.out.println("Data Found At Position " + i);
                return;
            } else if (array[i] > data) {
                System.out.println("No Match Found");
                return;
            }
        }
    }

}
