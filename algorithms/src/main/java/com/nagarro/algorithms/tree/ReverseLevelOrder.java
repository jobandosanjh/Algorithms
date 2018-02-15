package com.nagarro.algorithms.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public final class ReverseLevelOrder {

    public static void main(final String[] args) {
        printReverseLevelOrder(PreOrder.getTree());
    }

    private static void printReverseLevelOrder(final BinaryTreeNode tree) {
        if (null != tree) {
            final Queue<BinaryTreeNode> queue = new ArrayDeque<>();
            queue.add(tree);
            final Stack<Integer> stack = new Stack<>();
            while (!queue.isEmpty()) {
                final BinaryTreeNode temp = queue.poll();
                if (null != temp.getLeft()) {
                    queue.add(temp.getLeft());
                }
                if (null != temp.getRight()) {
                    queue.add(temp.getRight());
                }
                stack.add(temp.getData());
            }
            while (!stack.empty()) {
                System.out.println(stack.pop());
            }
        }
    }

}
