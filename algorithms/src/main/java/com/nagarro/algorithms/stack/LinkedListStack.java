package com.nagarro.algorithms.stack;

public final class LinkedListStack {

    private Node top;

    public LinkedListStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    private class Node {
        private int value;
        private Node next;

        public int getValue() {
            return value;
        }

        public void setValue(final int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(final Node next) {
            this.next = next;
        }

    }

    public void push(final int value) {
        final Node node = new Node();
        node.setNext(top);
        node.setValue(value);
        top = node;
    }

    public int pop() {
        if (isEmpty()) {
            throw new AssertionError("UnderFlow");
        }
        final int poppedValue = top.getValue();
        top = top.getNext();
        return poppedValue;
    }

    public static void main(final String[] args) {
        final LinkedListStack stack = new LinkedListStack();
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
