package com.nagarro.algorithms.linkedlist;

public class DoublyLinkedList {

    private int size;
    private DoublyNode start;
    private DoublyNode end;

    public DoublyLinkedList() {
        size = 0;
        start = end = null;
    }

    public void insertAtEnd(final String data) {
        final DoublyNode node = new DoublyNode(end, data, null);
        if (size == 0) {
            start = node;
        } else {
            end.setNext(node);
        }
        end = node;
        size++;
    }

    public void insertAtStart(final String data) {
        final DoublyNode node = new DoublyNode(null, data, start);
        if (size == 0) {
            end = node;
        } else {
            start.setPrevious(node);
        }
        start = node;
        size++;
    }

    public void insertAtPosition(final String data, final int position) {
        final int maxAllowedSize = size + 1;
        if (position > maxAllowedSize || position <= 0) {
            throw new AssertionError("You can only insert between 1 and " + maxAllowedSize);
        }
        if (position == maxAllowedSize) {
            insertAtEnd(data);
        } else if (position == 1) {
            insertAtStart(data);
        } else {
            DoublyNode temp = start;
            DoublyNode lastNode = start;
            for (int i = 1; i < position; i++) {
                lastNode = temp;
                temp = temp.getNext();
            }
            final DoublyNode node = new DoublyNode(temp.getPrevious(), data, temp);
            temp.setPrevious(node);
            lastNode.setNext(node);
            size++;
        }
    }

    public void removeFromEnd() {
        if (size == 0) {
            throw new AssertionError("Empty List");
        }
        if (size == 1) {
            start = end = null;
        } else {
            final DoublyNode lastNode = end.getPrevious();
            lastNode.setNext(null);
            end = lastNode;
        }
        size--;
    }

    public void removeFromStart() {
        if (size == 0) {
            throw new AssertionError("Empty List");
        }
        if (size == 1) {
            start = end = null;
        } else {
            DoublyNode nextNode = start.getNext();
            nextNode.setPrevious(null);
            start = nextNode;
        }
        size--;
    }

    public void removeFromPosition(final int position) {
        if (position > size) {
            throw new AssertionError("You can only remove upto " + size);
        }
        if (position == 1) {
            removeFromStart();
        } else if (position == size) {
            removeFromEnd();
        } else {
            DoublyNode node = start;
            for (int i = 1; i < position; i++) {
                node = node.getNext();
            }
            final DoublyNode lastNode = node.getPrevious();
            final DoublyNode nextNode = node.getNext();
            lastNode.setNext(node.getNext());
            nextNode.setPrevious(node.getPrevious());
            size--;
        }
    }

    public void display() {
        if (size == 0) {
            System.out.println("Empty List");
        } else {
            DoublyNode temp = start;
            while (null != temp) {
                System.out.println(temp.getData());
                temp = temp.getNext();
            }
        }
    }

    @Override
    public String toString() {
        return "DoublyLinkedList [size=" + size + ", start=" + start + ", end=" + end + "]";
    }

}

class DoublyNode {

    private DoublyNode previous;
    private String data;
    private DoublyNode next;

    public DoublyNode(final DoublyNode previous, final String data, final DoublyNode next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public DoublyNode getPrevious() {
        return previous;
    }

    public void setPrevious(final DoublyNode previous) {
        this.previous = previous;
    }

    public String getData() {
        return data;
    }

    public void setData(final String data) {
        this.data = data;
    }

    public DoublyNode getNext() {
        return next;
    }

    public void setNext(final DoublyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoublyNode [previous=" + previous + ", data=" + data + ", next=" + next + "]";
    }
}
