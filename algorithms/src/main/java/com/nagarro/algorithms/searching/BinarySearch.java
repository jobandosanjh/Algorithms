package com.nagarro.algorithms.searching;

public final class BinarySearch {

    public static void main(final String[] args) {
        final int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        search(array, 9);
        final int position = recursiveSearch(array, 0, 9, 9);
        if (-1 == position) {
            System.out.println("No Match Found");
        } else {
            System.out.println("Data Found At Position " + position);
        }
    }

    private static void search(final int[] array, final int data) {
        int left = 0;
        int right = array.length - 1;

        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (data == array[mid]) {
                System.out.println("Data Found At Position " + mid);
                return;
            } else if (data > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("No Match Found");
    }

    private static int recursiveSearch(final int[] array, int left, int right, final int data) {
        int mid = left + (right - left) / 2;
        if (mid < array.length) {
            if (array[mid] == data) {
                return mid;
            } else if (array[mid] > data) {
                return recursiveSearch(array, left, mid - 1, data);
            } else if (array[mid] < data) {
                return recursiveSearch(array, mid + 1, right, data);
            }
        }
        return -1;
    }
}
