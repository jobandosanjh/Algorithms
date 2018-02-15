package com.nagarro.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public final class WidthOfTree {

    public static void main(final String[] args) {
        test(PreOrder.getTree());
        test(new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(4, null, null), new BinaryTreeNode(5, null,
                null)), new BinaryTreeNode(3, null, new BinaryTreeNode(8, new BinaryTreeNode(6, null, null),
                new BinaryTreeNode(7, null, null)))));
    }

    private static void test(final BinaryTreeNode tree) {
        if (null != tree) {
            final Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.add(tree);
            queue.add(null);
            int width = 1;
            int currentWidth = 0;
            while (!queue.isEmpty()) {
                final BinaryTreeNode temp = queue.poll();
                if (null == temp) {
                    if (currentWidth > width) {
                        width = currentWidth;
                    }
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }
                    currentWidth = 0;
                } else {
                    final BinaryTreeNode left = temp.getLeft();
                    final BinaryTreeNode right = temp.getRight();
                    if (null != left) {
                        queue.add(left);
                    }
                    if (null != right) {
                        queue.add(right);
                    }
                    currentWidth++;
                }
            }
            System.out.println(width);
        }
    }
}
