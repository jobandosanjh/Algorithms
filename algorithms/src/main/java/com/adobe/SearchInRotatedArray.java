package com.adobe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Optional;

public final class SearchInRotatedArray {

    public static void main(final String[] args) {
        final int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        final int[] rotatedArray = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        printRotatedElementsOriginalPosition(array, rotatedArray);
        Arrays.stream(rotatedArray).forEach(i -> printUsingBinarySearch(array, i));
    }

    private static void printRotatedElementsOriginalPosition(final int[] original, final int[] rotated) {
        final Map<Integer, Integer> map = new HashMap<>(original.length);
        for (int i = 0; i < original.length; i++) {
            map.put(original[i], i);
        }
        for (int i = 0; i < rotated.length; i++) {
            final int position = Optional.fromNullable(map.get(rotated[i])).or(-1);
            System.out.println("Original position of " + rotated[i] + " = " + position);
        }
    }

    private static void printUsingBinarySearch(final int[] array, final int element) {
        int start = 0;
        int end = array.length - 1;
        int mid = 0;
        int position = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (array[mid] == element) {
                position = mid;
                break;
            } else if (array[mid] > element) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(position);
    }
}
