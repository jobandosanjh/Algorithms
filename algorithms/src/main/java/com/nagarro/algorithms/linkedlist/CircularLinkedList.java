package com.nagarro.algorithms.linkedlist;

public class CircularLinkedList {

    private Node start;
    private Node end;
    private int size;

    public void insertAtEnd(final String data) {
        final Node node = new Node(data, null);
        if (size == 0) {
            start = node;
        } else {
            end.setNode(node);
        }
        end = node;
        node.setNode(start);
        size++;
    }

    public void insertAtStart(final String data) {
        final Node node = new Node(data, null);
        if (size == 0) {
            end = node;
        } else {
            node.setNode(start);
        }
        start = node;
        end.setNode(start);
        size++;
    }

    public void insertAtPosition(final String data, final int position) {
        final int maxAllowedPosition = size + 1;
        if (position > maxAllowedPosition || position <= 0) {
            throw new AssertionError("You can only insert between 1 and " + maxAllowedPosition);
        } else if (position == maxAllowedPosition) {
            insertAtEnd(data);
        } else if (position == 1 || size == 0) {
            insertAtStart(data);
        } else {
            Node temp = start;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.getNode();
            }
            final Node node = new Node(data, temp.getNode());
            temp.setNode(node);
            size++;
        }
    }

    public void display() {
        if (size == 0) {
            System.out.println("Empty");
        } else {
            Node temp = start;
            while (null != temp) {
                System.out.println(temp.getData());
                temp = temp.getNode();
            }
        }
    }
}