package com.nagarro.algorithms.tree;

import java.util.Stack;
import java.util.function.Consumer;

import com.google.common.collect.FluentIterable;

public final class RootToLeafPath {

    private static int[] path = new int[100];

    public static void main(final String[] args) {
        printPath(PreOrder.getTree());
        recursivePath(PreOrder.getTree(), path, 0);
    }

    private static void printPath(final BinaryTreeNode tree) {
        if (null != tree) {
            final Stack<BinaryTreeNode> stack = new Stack<>();
            final Stack<BinaryTreeNode> path = new Stack<>();
            stack.add(tree);
            while (!stack.isEmpty()) {
                final BinaryTreeNode temp = stack.peek();
                if (!path.isEmpty() && temp == path.peek()) {
                    stack.pop();
                    final BinaryTreeNode lastNode = path.peek();
                    if (null == lastNode.getLeft() && null == lastNode.getRight()) {
                        FluentIterable.from(path).forEach(new Consumer<BinaryTreeNode>() {
                            @Override
                            public void accept(final BinaryTreeNode t) {
                                System.out.print(t.getData());
                            }
                        });
                        System.out.println();
                    }
                    path.pop();
                } else {
                    path.push(temp);
                    if (null != temp.getLeft()) {
                        stack.push(temp.getLeft());
                    }
                    if (null != temp.getRight()) {
                        stack.push(temp.getRight());
                    }
                }
            }
        }
    }

    private static void recursivePath(final BinaryTreeNode tree, final int[] path, int pathLength) {
        if (null == tree) {
            return;
        }
        path[pathLength++] = tree.getData();
        if (null == tree.getLeft() && null == tree.getRight()) {
            for (int i = 0; i < pathLength; i++) {
                System.out.print(path[i]);
            }
            System.out.println();
        } else {
            recursivePath(tree.getLeft(), path, pathLength);
            recursivePath(tree.getRight(), path, pathLength);
        }
    }
}
