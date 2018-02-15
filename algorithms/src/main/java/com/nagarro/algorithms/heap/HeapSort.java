package com.nagarro.algorithms.heap;

import java.util.ArrayList;
import java.util.Collection;

public final class HeapSort {

    public static void main(final String[] args) {
        System.out.println(heapSort(new int[] { 9, 8, 1, 2, 5, 4, 3, 6, 7, 0 }));
    }

    private static Collection<Integer> heapSort(final int[] array) {
        final Heap heap = new Heap(array.length, HeapType.MAX_HEAP);
        heap.setArray(HeapifyingAnArray.heapify(array));
        final int length = array.length;
        heap.setCount(length);
        final int[] heapArray = heap.getArray();
        final Collection<Integer> sortedElements = new ArrayList<>(length);
        for (int i = length - 1; i >= 0; i--) {
            final int currentHeapCount = heap.getCount();
            sortedElements.add(heapArray[0]);
            heapArray[0] = heapArray[currentHeapCount - 1];
            heap.setCount(currentHeapCount - 1);
            heap.preLocateDown(0);
        }
        return sortedElements;
    }
}
