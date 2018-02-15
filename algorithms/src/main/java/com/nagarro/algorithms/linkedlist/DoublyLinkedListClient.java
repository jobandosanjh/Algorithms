package com.nagarro.algorithms.linkedlist;

public final class DoublyLinkedListClient {

    public static void main(final String[] args) {
        final DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertAtEnd("1");
        doublyLinkedList.insertAtEnd("2");
        doublyLinkedList.insertAtStart("0");
        doublyLinkedList.insertAtPosition("3", 4);
        doublyLinkedList.insertAtEnd("4");
        doublyLinkedList.insertAtEnd("5");
        doublyLinkedList.insertAtEnd("6");
        doublyLinkedList.insertAtPosition("7", 8);
        doublyLinkedList.insertAtPosition("8", 9);
        doublyLinkedList.insertAtPosition("9", 10);
        doublyLinkedList.removeFromPosition(10);
        doublyLinkedList.display();
    }

}
