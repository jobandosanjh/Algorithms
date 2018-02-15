package com.nagarro.algorithms.linkedlist;

public class CircularLinkedListClient {

    public static void main(final String[] args) {
        final CircularLinkedList list = new CircularLinkedList();
        list.insertAtStart("-1");
        list.insertAtEnd("1");
        list.insertAtEnd("2");
        list.insertAtEnd("4");
        list.insertAtStart("0");
        list.insertAtPosition("3", 5);
        list.insertAtPosition("5", 7);
        list.insertAtPosition("6", 8);
        list.insertAtPosition("7", 9);
        list.insertAtPosition("8", 10);
        list.insertAtPosition("9", 11);

        list.display();
    }

}
