package com.nagarro.algorithms.linkedlist;

public class SingleLinkList {

    private Node start;
    private Node end;
    private int size;

    public SingleLinkList() {
        this.start = this.end = null;
        this.size = 0;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertAtEnd(final String data) {
        final Node node = new Node(data, null);
        if (isEmpty()) {
            start = end = node;
        } else {
            end.setNode(node);
            end = node;
        }
        size++;
    }

    public void insertAtStart(final String data) {
        final Node node = new Node(data, start);
        start = node;
        if (isEmpty()) {
            end = node;
        }
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

    public void removeFromEnd() {
        if (isEmpty()) {
            throw new AssertionError("Linked List Is Empty");
        } else if (size == 1) {
            start = end = null;
        } else {
            Node temp = start;
            Node lastNode = start;
            while (null != temp.getNode()) {
                lastNode = temp;
                temp = temp.getNode();
            }
            lastNode.setNode(null);
            end = lastNode;
        }
        size--;
    }

    public void removeFromStart() {
        if (isEmpty()) {
            throw new AssertionError("Linked List Is Empty");
        } else if (size == 1) {
            start = end = null;
        } else {
            start = start.getNode();
        }
        size--;
    }

    public void removeFromPosition(final int position) {
        if (isEmpty()) {
            throw new AssertionError("Linked List Is Empty");
        } else if (position > size || position <= 0) {
            throw new AssertionError("You can only remove between  1 And " + size);
        } else if (size == 1) {
            start = end = null;
            size--;
        } else if (position == 1) {
            removeFromStart();
        } else if (position == size) {
            removeFromEnd();
        } else {
            Node temp = start;
            Node lastNode = start;
            for (int i = 1; i < position; i++) {
                lastNode = temp;
                temp = temp.getNode();
            }
            lastNode.setNode(temp.getNode());
            size--;
        }
    }

    public void display() {
        if (size == 0) {
            System.out.println("Empty");
        } else {
            Node temp = start;
            while (null != temp) {
                System.out.println(temp);
                temp = temp.getNode();
            }
        }
    }

    public void reverse(final SingleLinkList linkedList) {
        final SingleLinkList reversedLinkedList = new SingleLinkList();
        Node temp = linkedList.start;
        while (null != temp) {
            reversedLinkedList.insertAtStart(temp.getData());
            temp = temp.getNode();
        }
        reversedLinkedList.display();
    }

    @Override
    public String toString() {
        return "SingleLikedList [start=" + start + ", end=" + end + ", size=" + size + "]";
    }
}

final class Node {

    private String data;
    private Node node;

    public Node(final String data, final Node node) {
        this.data = data;
        this.node = node;
    }

    public String getData() {
        return data;
    }

    public void setData(final String data) {
        this.data = data;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(final Node node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + ", node=" + node + "]";
    }

}
