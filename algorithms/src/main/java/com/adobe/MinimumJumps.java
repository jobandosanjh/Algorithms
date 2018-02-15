package com.adobe;

public final class MinimumJumps {

    public static void main(final String[] args) {
        final int[] array = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        System.out.println(getNumberOfJumps(array));
    }

    private static int getNumberOfJumps(final int[] array) {
        final int destination = array.length - 1;
        int jumps = -1;
        int current = array[0];
        while (true) {
            for (int i = current; i > 0; i--) {
                current += array[i];
                jumps++;
            }
            if (current == destination) {
                break;
            }
        }
        return jumps;
    }

}
