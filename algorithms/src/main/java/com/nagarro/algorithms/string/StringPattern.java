package com.nagarro.algorithms.string;

public final class StringPattern {

    public static void main(final String[] args) {
        final String string = "abcd";
        final String pattern = "a*d";
        System.out.println(containsPattern(string, pattern));
    }

    private static final boolean containsPattern(final String string, final String pattern) {
        if (string.length() < pattern.length()) {
            throw new AssertionError("The length of pattern is greater than; string");
        }
        int patternCount = 0;
        for (int i = 0; i < string.length() && patternCount < pattern.length(); i++) {
            if ("?".equals(String.valueOf(pattern.charAt(patternCount)))) {
                patternCount++;
            } else if ("*".equals(String.valueOf(pattern.charAt(patternCount)))) {
                int tempCount = patternCount + 1;
                if (tempCount < pattern.length()) {
                    if (pattern.charAt(tempCount) == string.charAt(i)) {
                        patternCount = i - patternCount;
                        patternCount += 2;
                    }
                }
            } else if (pattern.charAt(patternCount) == string.charAt(i)) {
                patternCount++;
            } else {
                return false;
            }
        }
        return true;
    }

}
