package com.nagarro.algorithms.tree;

import java.util.Stack;

public class PathWithGivenSum {

    private static int[] path = new int[100];

    public static void main(final String[] args) {
        final int sum = 11;
        printPath(PreOrder.getTree(), sum);
        getPathRecursive(PreOrder.getTree(), path, 0, sum);
    }

    private static void printPath(final BinaryTreeNode tree, final int sum) {
        if (null != tree) {
            final Stack<BinaryTreeNode> stack = new Stack<>();
            final Stack<BinaryTreeNode> path = new Stack<>();
            stack.add(tree);
            while (!stack.isEmpty()) {
                final BinaryTreeNode temp = stack.peek();
                if (!path.isEmpty() && temp == path.peek()) {
                    int currentPathSum = 0;
                    for (final BinaryTreeNode binaryTreeNode : path) {
                        currentPathSum += binaryTreeNode.getData();
                    }
                    if (sum == currentPathSum) {
                        for (final BinaryTreeNode binaryTreeNode : path) {
                            System.out.print(binaryTreeNode.getData());
                        }
                        System.out.println();
                    }
                    stack.pop();
                    path.pop();
                } else {
                    path.push(temp);
                    if (null != temp.getRight()) {
                        stack.add(temp.getRight());
                    }
                    if (null != temp.getLeft()) {
                        stack.add(temp.getLeft());
                    }
                }
            }
        }
    }

    private static void getPathRecursive(final BinaryTreeNode tree, final int[] path, int pathLength, final int sum) {
        if (null == tree) {
            return;
        }
        path[pathLength++] = tree.getData();
        if (sum == tree.getData()) {
            for (int i = 0; i < pathLength; i++) {
                System.out.print(path[i]);
            }
            System.out.println();
        } else {
            getPathRecursive(tree.getLeft(), path, pathLength, sum - tree.getData());
            getPathRecursive(tree.getRight(), path, pathLength, sum - tree.getData());
        }
    }
}
