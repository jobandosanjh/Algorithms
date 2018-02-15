package com.nagarro.algorithms.tree;

import java.util.Queue;

import com.google.common.collect.Queues;

public final class LevelOrder {

    public static void main(final String[] args) {
        getLevelOrder(PreOrder.getTree());
    }

    private static void getLevelOrder(final BinaryTreeNode tree) {
        final Queue<BinaryTreeNode> queue = Queues.newArrayDeque();
        queue.add(tree);
        while (!queue.isEmpty()) {
            final BinaryTreeNode temp = queue.poll();
            System.out.println(temp.getData());
            final BinaryTreeNode left = temp.getLeft();
            final BinaryTreeNode right = temp.getRight();
            if (null != left) {
                queue.add(left);
            }
            if (null != right) {
                queue.add(right);
            }
        }
    }
}
