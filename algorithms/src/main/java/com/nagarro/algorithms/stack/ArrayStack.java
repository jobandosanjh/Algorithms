package com.nagarro.algorithms.stack;

import java.util.Arrays;

public final class ArrayStack {

    private int[] stack;
    private int top;

    public ArrayStack() {
        this.stack = new int[10];
        top = -1;
    }

    private boolean isEmpty() {
        return top < 0;
    }

    private boolean isFull() {
        return stack.length == (top + 1);
    }

    public void push(final int value) {
        if (isFull()) {
            throw new AssertionError("Overflow");
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new AssertionError("UnderFlow");
        }
        return stack[top--];
    }

    public static void main(final String[] args) {
        final ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        Arrays.stream(stack.stack).mapToObj(i -> Integer.toUnsignedString(i, stack.stack.length))
                .forEach(System.out::println);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
