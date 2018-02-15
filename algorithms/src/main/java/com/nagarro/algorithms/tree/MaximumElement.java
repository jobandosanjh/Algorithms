package com.nagarro.algorithms.tree;

import java.util.Queue;

import com.google.common.collect.Queues;

public final class MaximumElement {

    public static void main(final String[] args) {
        getMax(PreOrder.getTree());
        System.out.println(getMaxRecursive(PreOrder.getTree()));
    }

    private static void getMax(final BinaryTreeNode tree) {
        if (null != tree) {
            final Queue<BinaryTreeNode> queue = Queues.newArrayDeque();
            queue.add(tree);
            int max = Integer.MIN_VALUE;
            while (!queue.isEmpty()) {
                final BinaryTreeNode node = queue.poll();
                if (node.getData() > max) {
                    max = node.getData();
                }
                if (null != node.getLeft()) {
                    queue.add(node.getLeft());
                }
                if (null != node.getRight()) {
                    queue.add(node.getRight());
                }
            }
            System.out.println(max);
        }
    }

    private static int getMaxRecursive(final BinaryTreeNode tree) {
        int max = Integer.MIN_VALUE;
        if (null != tree) {
            final int leftMax = getMaxRecursive(tree.getLeft());
            final int rightMax = getMaxRecursive(tree.getRight());
            if (leftMax > rightMax) {
                max = leftMax;
            } else {
                max = rightMax;
            }
            if (tree.getData() > max) {
                max = tree.getData();
            }
        }
        return max;
    }

}
