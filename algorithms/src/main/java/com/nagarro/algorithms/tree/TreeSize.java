package com.nagarro.algorithms.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public final class TreeSize {

    public static void main(final String[] args) {
        final BinaryTreeNode tree = PreOrder.getTree();
        getSize(tree);
        System.out.println(getSizeRecursively(tree));
    }

    private static void getSize(final BinaryTreeNode tree) {
        int size = 0;
        if (null != tree) {
            final Queue<BinaryTreeNode> queue = new ArrayDeque<>();
            queue.add(tree);
            while (!queue.isEmpty()) {
                final BinaryTreeNode temp = queue.poll();
                if (null != temp.getLeft()) {
                    queue.add(temp.getLeft());
                }
                if (null != temp.getRight()) {
                    queue.add(temp.getRight());
                }
                size++;
            }
        }
        System.out.println(size);
    }

    private static int getSizeRecursively(final BinaryTreeNode tree) {
        if (null == tree) {
            return 0;
        }
        return getSizeRecursively(tree.getLeft()) + 1 + getSizeRecursively(tree.getRight());
    }

}
