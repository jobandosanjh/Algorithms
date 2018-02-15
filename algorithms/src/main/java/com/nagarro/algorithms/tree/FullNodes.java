package com.nagarro.algorithms.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public final class FullNodes {

    public static void main(final String[] args) {
        getFullNodes(PreOrder.getTree());
    }

    private static void getFullNodes(final BinaryTreeNode tree) {
        int count = 0;
        final Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            final BinaryTreeNode temp = queue.poll();
            final BinaryTreeNode left = temp.getLeft();
            final BinaryTreeNode right = temp.getRight();
            if (null != left && null != right) {
                System.out.println(temp.getData());
                count++;
            }
            if (null != left) {
                queue.add(left);
            }
            if (null != right) {
                queue.add(right);
            }
        }
        System.out.println(count);
    }

}
