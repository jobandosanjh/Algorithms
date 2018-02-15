package com.nagarro.algorithms.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public final class Leaves {

    public static void main(final String[] args) {
        getLeaves(PreOrder.getTree());
    }

    private static void getLeaves(final BinaryTreeNode tree) {
        int count = 0;
        final Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            final BinaryTreeNode temp = queue.poll();
            if (temp.getLeft() == null && temp.getRight() == null) {
                count++;
                System.out.println(temp.getData());
            }
            if (null != temp.getLeft()) {
                queue.add(temp.getLeft());
            }
            if (null != temp.getRight()) {
                queue.add(temp.getRight());
            }
        }
        System.out.println(count);
    }

}
