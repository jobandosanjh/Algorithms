package com.nagarro.algorithms.string;

/**
 * Brute force technique for finding a substring from a string.
 * 
 * @author jobanpreetsingh
 *
 */
public final class BruteForce {

    public static void main(final String[] args) {
        final char[] string = new char[] { 'T', 'h', 'i', 's', ' ', 'a', ' ', 'b', 'r', 'u', 't', 'e', ' ', 'f', 'o',
                'r', 'c', 'e' };
        final String pattern = "force";
        final int index = indexOfPattern(string, pattern.toCharArray());
        System.out.println(index);
        if (-1 != index) {
            for (int i = index, j = 0; j < pattern.toCharArray().length; i++, j++) {
                System.out.print(string[i]);
            }
        }
    }

    private static int indexOfPattern(final char[] string, final char[] pattern) {
        int index = -1;
        final int stringLen = string.length;
        final int patternLen = pattern.length;
        for (int i = 0; i < patternLen; i++) {
            int j = 0;
            while (j < stringLen && i < patternLen) {
                if (string[j] == pattern[i]) {
                    i++;
                }
                j++;
                if (i == patternLen) {
                    index = j - patternLen;
                }
            }
        }
        return index;
    }

}
