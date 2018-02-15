package com.nagarro.algorithms.heap;

public final class HeapifyingAnArray {

    public static void main(final String[] args) {
        heapify(new int[] { 9, 8, 1, 2, 5, 4, 3, 6, 7, 0 });
    }

    public static int[] heapify(final int[] array) {
        final Heap heap = new Heap(array.length, HeapType.MAX_HEAP);
        heap.setArray(array);
        final int arrayLength = array.length;
        heap.setCount(arrayLength);
        for (int i = heap.getParent(arrayLength - 1); i >= 0; i--) {
            heap.preLocateDown(i);
        }
        return heap.getArray();
    }

}
