package com.nagarro.algorithms.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public final class InOrder {

    public static void main(final String[] args) {
        getInOrder(PreOrder.getTree());
        getInOrderIteratively(PreOrder.getTree());
    }

    private static void getInOrder(final BinaryTreeNode tree) {
        if (null != tree) {
            getInOrder(tree.getLeft());
            System.out.println(tree.getData());
            getInOrder(tree.getRight());
        }
    }

    private static void getInOrderIteratively(final BinaryTreeNode tree) {
        final Collection<Integer> data = new ArrayList<>();
        if (null != tree) {
            final Stack<BinaryTreeNode> stack = new Stack<>();
            boolean proceed = true;
            BinaryTreeNode currentNode = tree;
            while (proceed) {
                if (null != currentNode) {
                    stack.push(currentNode);
                    currentNode = currentNode.getLeft();
                } else {
                    if (stack.isEmpty()) {
                        proceed = false;
                    } else {
                        final BinaryTreeNode node = stack.pop();
                        data.add(node.getData());
                        currentNode = node.getRight();
                    }
                }
            }
        }
        System.out.println(data);
    }
}
