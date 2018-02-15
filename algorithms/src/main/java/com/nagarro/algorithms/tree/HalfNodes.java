package com.nagarro.algorithms.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public final class HalfNodes {

    public static void main(final String[] args) {
        getHalfNodes(PreOrder.getTree());
        getHalfNodes(new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(4, null, null), null), null));
    }

    private static void getHalfNodes(final BinaryTreeNode tree) {
        int count = 0;
        final Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            final BinaryTreeNode temp = queue.poll();
            final BinaryTreeNode left = temp.getLeft();
            final BinaryTreeNode right = temp.getRight();
            if ((null != left && null == right) || (null == left && null != right)) {
                count++;
                System.out.println(temp.getData());
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
