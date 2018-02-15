package com.nagarro.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public final class NodesInEachLevel {

    public static void main(final String[] args) {
        getDiameter(PreOrder.getTree());
    }

    private static void getDiameter(final BinaryTreeNode tree) {
        final Queue<BinaryTreeNode> queue = new LinkedList<>();
        int diameter = 0;
        int level = 0;
        queue.add(tree);
        queue.add(null);
        while (!queue.isEmpty()) {
            final BinaryTreeNode temp = queue.poll();
            if (null == temp) {
                System.out.println("For Level " + level + "=" + diameter);
                level++;
                diameter = 0;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                diameter++;
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

}
