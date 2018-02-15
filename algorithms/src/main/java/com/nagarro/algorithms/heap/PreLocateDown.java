package com.nagarro.algorithms.heap;

public final class PreLocateDown {

    public static void main(final String[] args) {
        final int[] array = new int[] { 31, 1, 21, 9, 10, 12, 18, 3, 2, 8, 7 };
        final Heap heap = new Heap(11, HeapType.MAX_HEAP);
        heap.setArray(array);
        heap.setCount(array.length);
        heap.preLocateDown(1);
    }

    static Heap getHeap() {
        final int[] array = new int[] { 31, 1, 21, 9, 10, 12, 18, 3, 2, 8, 7 };
        final Heap heap = new Heap(11, HeapType.MAX_HEAP);
        heap.setArray(array);
        heap.setCount(array.length);
        heap.preLocateDown(1);
        return heap;
    }

}
