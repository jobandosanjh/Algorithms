package com.nagarro.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public final class DistanceBetweenTwoNodes {

    public static void main(final String[] args) {
        System.out.println(height(PreOrder.getTree()));
        System.out.println("The path betwwen two nodes is :");
        printPath(PreOrder.getTree(), 7, 1);
    }

    private static int height(final BinaryTreeNode tree) {
        if (null == tree) {
            return 0;
        }
        return Math.max(height(tree.getLeft()), height(tree.getRight())) + 1;
    }

    private static void printPath(final BinaryTreeNode tree, final int node1, final int node2) {
        final List<Integer> path = new ArrayList<>();
        if (null != tree) {
            final Stack<BinaryTreeNode> stack = new Stack<>();
            final Stack<BinaryTreeNode> currentPath = new Stack<>();
            stack.add(tree);
            while (!stack.isEmpty()) {
                final BinaryTreeNode temp = stack.peek();
                if ((temp.getData() == node1 || temp.getData() == node2)
                        && (node1 != tree.getData() && node2 != tree.getData())) {
                    path.addAll(currentPath.stream().map(i -> i.getData()).collect(Collectors.toList()));
                    path.add(temp.getData());
                    stack.pop();
                } else if (!currentPath.isEmpty() && temp == currentPath.peek()) {
                    if (node1 == temp.getData() || node2 == temp.getData()) {
                        path.addAll(currentPath.stream().map(i -> i.getData()).collect(Collectors.toList()));
                    }
                    stack.pop();
                    currentPath.pop();
                } else {
                    currentPath.add(temp);
                    if (null != temp.getRight()) {
                        stack.add(temp.getRight());
                    }
                    if (null != temp.getLeft()) {
                        stack.add(temp.getLeft());
                    }
                }
            }
        }
        if (!path.isEmpty()) {
            for (int i = path.lastIndexOf(tree.getData()) - 1; i >= 0; i--) {
                System.out.println(path.get(i));
            }
            for (int i = path.lastIndexOf(tree.getData()) + 1; i < path.size(); i++) {
                System.out.println(path.get(i));
            }
        }
    }
}
