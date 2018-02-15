package com.nagarro.algorithms.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public final class PostOrder {

    public static void main(final String[] args) {
        getPostOrder(PreOrder.getTree());
        getPostOrderIteratively(PreOrder.getTree());
    }

    private static void getPostOrder(final BinaryTreeNode tree) {
        if (null != tree) {
            getPostOrder(tree.getLeft());
            getPostOrder(tree.getRight());
            System.out.println(tree.getData());
        }
    }

    private static void getPostOrderIteratively(final BinaryTreeNode tree) {
        final Collection<Integer> data = new ArrayList<>();
        if (null != tree) {
            final Stack<BinaryTreeNode> stack = new Stack<>();
            stack.add(tree);
            BinaryTreeNode prev = null;
            while (!stack.isEmpty()) {
                final BinaryTreeNode current = stack.peek();
                if (null == prev || prev.getLeft() == current || prev.getRight() == current) {
                    if (null != current.getLeft()) {
                        stack.push(current.getLeft());
                    } else if (null != current.getRight()) {
                        stack.push(current.getRight());
                    } else {
                        stack.pop();
                        data.add(current.getData());
                    }
                } else if (current.getLeft() == prev) {
                    if (null != current.getRight()) {
                        stack.push(current.getRight());
                    } else {
                        stack.pop();
                        data.add(current.getData());
                    }
                } else if (current.getRight() == prev) {
                    stack.pop();
                    data.add(current.getData());
                }
                prev = current;
            }
        }
        System.out.println(data);
    }

}
