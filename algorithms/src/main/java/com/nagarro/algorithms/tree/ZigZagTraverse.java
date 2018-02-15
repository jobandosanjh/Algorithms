package com.nagarro.algorithms.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public final class ZigZagTraverse {

    public static void main(final String[] args) {
        printZigZag(PreOrder.getTree());
    }

    private static void printZigZag(final BinaryTreeNode tree) {
        if (null != tree) {
            final Queue<BinaryTreeNode> queue = new LinkedList<>();
            final Collection<Integer> data = new ArrayList<>();
            queue.add(tree);
            queue.add(null);
            int level = 1;
            while (!queue.isEmpty()) {
                final BinaryTreeNode temp = queue.poll();
                if (null == temp) {
                    if (level % 2 == 0) {
                        for (int i = data.size() - 1; i >= 0; i--) {
                            System.out.print(data.toArray()[i]);
                        }
                    } else {
                        data.stream().forEach(System.out::print);
                    }
                    System.out.println();
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }
                    level++;
                    data.clear();
                } else {
                    if (null != temp.getLeft()) {
                        queue.add(temp.getLeft());
                    }
                    if (null != temp.getRight()) {
                        queue.add(temp.getRight());
                    }
                    data.add(temp.getData());
                }
            }
        }
    }
}
