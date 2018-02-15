package com.nagarro.algorithms.heap;

public final class DeleteMax {

    public static void main(final String[] args) {
        final Heap heap = PreLocateDown.getHeap();
        heap.deleteMax();
        System.out.println(heap.getLeftChild(4));
    }

}
