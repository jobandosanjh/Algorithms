package com.adobe;

public final class IsSubsetSumEqual {

    public static void main(final String[] args) {
        final int[] array = { 1, 3, 4 };
        System.out.println(isSubsetSumEqual(array));
    }

    private static boolean isSubsetSumEqual(final int[] array) {
        final int sub1Start = 0;
        final int sub2End = array.length - 1;
        final int sub1End = sub2End / 2;
        final int sub2Start = sub1End + 1;
        int sub1Sum = 0;
        int sub2Sum = 0;
        for (int i = sub1Start; i <= sub1End; i++) {
            sub1Sum += array[i];
        }
        for (int i = sub2Start; i <= sub2End; i++) {
            sub2Sum += array[i];
        }
        return sub1Sum == sub2Sum;
    }

}
