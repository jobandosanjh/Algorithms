package com.nagarro.algorithms.heap;

import java.util.Arrays;

public final class Heap {

    private int[] array;
    private int capacity;
    private int count;
    private HeapType heapType;

    public Heap(final int capacity, final HeapType heapType) {
        this.capacity = capacity;
        this.count = 0;
        this.heapType = heapType;
    }

    public int[] getArray() {
        return this.array;
    }

    public void setArray(final int[] array) {
        this.array = array;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(final int capacity) {
        this.capacity = capacity;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public HeapType getHeapType() {
        return this.heapType;
    }

    public void setHeapType(final HeapType heapType) {
        this.heapType = heapType;
    }

    public int getParent(final int i) {
        return i <= 0 || i >= this.count ? -1 : (i - 1) / 2;
    }

    public int getLeftChild(final int i) {
        final int left = 2 * i + 1;
        return i < 0 || left >= this.count ? -1 : left;
    }

    public int getRightChild(final int i) {
        final int right = 2 * i + 2;
        return i < 0 || right >= this.count ? -1 : right;
    }

    public int getMaximum() {
        return this.count == 0 ? -1 : this.array[0];
    }

    public void preLocateDown(final int i) {
        final int left = getLeftChild(i);
        final int right = getRightChild(i);
        int max = i;
        if (left != -1 && this.array[left] > this.array[max]) {
            max = left;
        }
        if (right != -1 && this.array[right] > this.array[max]) {
            max = right;
        }
        if (max != i) {
            final int temp = this.array[i];
            this.array[i] = this.array[max];
            this.array[max] = temp;
            preLocateDown(max);
        }
    }

    public void deleteMax() {
        if (this.count == 0) {
            throw new AssertionError("Heap is empty");
        }
        this.array[0] = this.array[this.count - 1];
        this.count--;
        preLocateDown(0);
        this.array = Arrays.copyOf(this.array, this.count);
    }

    public void insert(final int data) {
        if (this.count == this.capacity) {
            resizeHeap();
        }
        this.array[this.count++] = data;
        int i = count - 1;
        while (i > 0) {
            final int parent = getParent(i);
            if (array[i] > array[parent]) {
                final int temp = array[i];
                array[i] = array[parent];
                array[parent] = temp;
            }
            i = parent;
        }
    }

    private void resizeHeap() {
        this.capacity = 2 * this.capacity;
        this.array = Arrays.copyOf(this.array, capacity);
    }

    @Override
    public String toString() {
        return "Heap [array=" + Arrays.toString(array) + ", capacity=" + capacity + ", count=" + count + ", heapType="
                + heapType + "]";
    }

}

enum HeapType {
    MIN_HEAP, MAX_HEAP;
}
