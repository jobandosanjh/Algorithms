package com.nagarro.algorithms.linkedlist;

public class SingleLinkedListClient {

    public static void main(final String[] args) {
        final SingleLinkList list = new SingleLinkList();
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

        list.removeFromPosition(2);
        list.display();
        System.out.println("After Reverse :");
        list.reverse(list);
        System.out.println(nthNodeFromEnd(list.getStart(), 11));
    }

    private static Node nthNodeFromEnd(final Node head, final int position) {
        Node temp = head;
        Node nthNode = head;
        for (int i = 1; i <= position; i++) {
            temp = temp.getNode();
        }
        while (temp != null) {
            nthNode = nthNode.getNode();
            temp = temp.getNode();
        }
        return nthNode;
    }

}
