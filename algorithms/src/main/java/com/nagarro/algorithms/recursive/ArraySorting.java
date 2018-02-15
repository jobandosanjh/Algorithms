package com.nagarro.algorithms.recursive;

public final class ArraySorting {

    public static void main(final String[] args) {
        final int[] array = { 1, 2, 3, 4, 5, 9 };
        System.out.println(isSorted(array, array.length) == 1 ? "Sorted" : "Not Sorted");
    }

    private static int isSorted(final int[] array, final int index) {
        if (array.length == 1 || index == 1) {
            return 1;
        }
        return (array[index - 1] < array[index - 2]) ? 0 : isSorted(array, index - 1);
    }

}
