package com.adobe;

public final class ReverseWords {

    public static void main(final String[] args) {
        if (args.length == 0) {
            throw new AssertionError("No Input");
        } else if (args.length == 1) {
            reverseStringUsingStack(args[0]);
        } else {
            for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
                reverseStringUsingStack(args[i]);
                System.out.println();
            }
        }
        reverseString("i.like.this.program.very.much");
    }

    private static void reverseString(final String input) {
        checkEmptyOrNull(input);
        final int inputLength = input.length();
        final char[] output = new char[input.length()];
        int outputIndex = 0;
        int tempIndex = 0;
        for (int i = inputLength - 1; i >= 0; i--) {
            final char currentChar = input.charAt(i);
            if (currentChar == '.') {
                int lastIndex = outputIndex - 1;
                for (int j = tempIndex; j <= lastIndex; j++, lastIndex--) {
                    char temp = output[j];
                    output[j] = output[lastIndex];
                    output[lastIndex] = temp;
                }
                output[outputIndex++] = currentChar;
                tempIndex = outputIndex;
            } else {
                output[outputIndex++] = currentChar;
            }
        }
        System.out.println(output);
    }

    private static void reverseStringUsingStack(final String input) {
        checkEmptyOrNull(input);
        final CustomStack customStack = new CustomStack();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if ('.' == character) {
                customStack.push(stringBuilder.toString());
                customStack.push(String.valueOf(character));
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder.append(character);
            }
        }
        if (stringBuilder.length() > 0) {
            customStack.push(stringBuilder.toString());
        }
        customStack.popAll();
    }

    private static void checkEmptyOrNull(final String input) {
        if (null == input || input.length() == 0) {
            throw new AssertionError("The length of input is 0");
        }
    }

    static class CustomStack {

        private String[] array;
        private int index;

        public CustomStack() {
            array = new String[10];
            index = -1;
        }

        public void push(final String value) {
            if ((index + 1) == array.length) {
                final String[] tempArray = array;
                array = new String[2 * array.length];
                for (int i = 0; i < tempArray.length; i++) {
                    array[i] = tempArray[i];
                }
            }
            array[++index] = value;
        }

        public String pop() {
            if (array.length == 0) {
                throw new AssertionError("There is no element in the Stack.");
            }
            return array[index--];
        }

        public void popAll() {
            while (index >= 0) {
                System.out.print(pop());
            }
        }

    }

}
