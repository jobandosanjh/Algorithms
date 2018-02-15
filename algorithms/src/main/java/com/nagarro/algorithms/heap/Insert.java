package com.nagarro.algorithms.heap;

public final class Insert {

    public static void main(final String[] args) {
        final Heap heap = getHeap();
        heap.insert(19);
    }

    private static Heap getHeap() {
        final int[] array = new int[] { 31, 10, 16, 9, 8, 14, 12, 3, 1, 5, 7 };
        final Heap heap = new Heap(11, HeapType.MAX_HEAP);
        heap.setArray(array);
        heap.setCount(array.length);
        return heap;
    }

}
