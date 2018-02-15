package com.nagarro.algorithms.recursive;

public final class Palindrome {

    public static void main(final String[] args) {
        System.out.println(isPalindrome("abcdefghijklmnopqrstuvwxyz zyxwvutsrqponmlkjihgfedcba"));

        System.out.println(isPalindrome("abc cba"));
    }

    private static boolean isPalindrome(final String str) {
        if (str.length() == 0 || str.length() == 1) {
            return true;
        }
        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }
        return false;
    }
}
