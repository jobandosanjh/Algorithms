package com.nagarro.algorithms.stack;

import java.util.Arrays;

public final class DynamicArrayStack {

    private int[] stack;
    private int top;

    public DynamicArrayStack() {
        this.stack = new int[10];
        this.top = -1;
    }

    private boolean isEmpty() {
        return top < 0;
    }

    private boolean isFull() {
        return stack.length == top + 1;
    }

    public void push(final int value) {
        if (isFull()) {
            final int[] tempStack = stack;
            stack = new int[2 * stack.length];
            for (int i = 0; i < tempStack.length; i++) {
                stack[i] = tempStack[i];
            }
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
        final DynamicArrayStack stack = new DynamicArrayStack();
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
        stack.push(11);
        System.out.println(Arrays.toString(stack.stack));
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
        System.out.println(stack.pop());
    }

}
