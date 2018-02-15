package com.nagarro.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public final class MinimumDepth {

    public static void main(final String[] args) {
        System.out.println(getMinimumDepth(PreOrder.getTree()));
    }

    private static int getMinimumDepth(final BinaryTreeNode tree) {
        int depth = 0;
        final Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(tree);
        queue.add(null);
        while (!queue.isEmpty()) {
            final BinaryTreeNode temp = queue.poll();
            if (null != temp) {
                if (null == temp.getLeft() && null == temp.getRight()) {
                    return depth;
                }
                if (null != temp.getLeft()) {
                    queue.add(temp.getLeft());
                }
                if (null != temp.getRight()) {
                    queue.add(temp.getRight());
                }
            } else {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    depth++;
                }
            }
        }
        return depth;
    }

}
