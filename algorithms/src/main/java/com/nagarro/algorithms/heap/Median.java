package com.nagarro.algorithms.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public final class Median {
    Queue<Integer> maxHeap;// lower half
    Queue<Integer> minHeap;// higher half

    public Median() {
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + (minHeap.peek())) / 2;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        final Median median = new Median();
        median.addNum(6);
        median.addNum(8);
        median.addNum(7);
        median.addNum(10);
        median.addNum(11);
        median.addNum(12);
        median.addNum(13);
        median.addNum(9);
        median.addNum(14);
        median.addNum(15);
        median.addNum(16);
        System.out.println(median.findMedian());
    }

}
