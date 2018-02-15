package com.nagarro.algorithms.heap;

import java.util.Arrays;

public final class DeleteFromPosition {

    public static void main(final String[] args) {
        System.out.println(PreLocateDown.getHeap());
        System.out.println(deleteFromPosition(PreLocateDown.getHeap(), 10));
    }

    private static Heap deleteFromPosition(final Heap heap, final int position) {
        if (position < 0 || position >= heap.getCount()) {
            throw new AssertionError("Position Not Available In Heap");
        }
        final int[] array = heap.getArray();
        array[position] = array[heap.getCount() - 1];
        heap.setCount(heap.getCount() - 1);
        heap.preLocateDown(position);
        heap.setArray(Arrays.copyOf(array, heap.getCount()));
        return heap;
    }
}
