package com.nagarro.algorithms.string;

public final class KMP {

    public static void main(final String[] args) {
        final String str = "This is a KMP algorithm";
        final String pattern = "rithm";
        final int[] array = getPatternArray(pattern.toCharArray());
        System.out.println(findString(str, pattern, array));
    }

    private static int[] getPatternArray(final char[] pattern) {
        final int patternLength = pattern.length;
        final int[] array = new int[patternLength];
        int index = 0;
        array[index++] = 0;
        for (int i = 0, j = 1; index < patternLength && i >= 0; j++) {
            if (pattern[i] == pattern[j]) {
                array[index++] = i + 1;
                i++;
            } else if (i == 0) {
                array[index++] = 0;
            } else {
                i = array[i - 1];
                j--;
            }
        }
        return array;
    }

    private static int findString(final String str, final String pattern, final int[] array) {
        int index = 0;
        boolean isFound = false;
        for (int strIndex = 0, patternIndex = 0; strIndex < str.length() && patternIndex < pattern.length();) {
            if (str.charAt(strIndex) == pattern.charAt(patternIndex)) {
                if (!isFound) {
                    isFound = true;
                    index = strIndex;
                }
                strIndex++;
                patternIndex++;
            } else if (patternIndex == 0) {
                isFound = false;
                strIndex++;
            } else {
                patternIndex = array[patternIndex - 1];
                if (patternIndex == 0) {
                    isFound = false;
                } else {
                    isFound = true;
                    index = strIndex - patternIndex;
                }
            }
        }
        return isFound ? index : -1;
    }

}
