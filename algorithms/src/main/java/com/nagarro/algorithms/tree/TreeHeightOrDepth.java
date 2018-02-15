package com.nagarro.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public final class TreeHeightOrDepth {

    public static void main(final String[] args) {
        final BinaryTreeNode tree = PreOrder.getTree();
        System.out.println(getHeight(tree));
        System.out.println(getHeightRecursively(tree));
        System.out.println(getHeightStack(tree));

        System.out.println(getHeight(new BinaryTreeNode(1, null, new BinaryTreeNode(2, null, null))));
    }

    private static int getHeight(final BinaryTreeNode tree) {
        if (null == tree) {
            return 0;
        }
        final Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(tree);
        queue.add(null);
        int count = 1;
        while (!queue.isEmpty()) {
            final BinaryTreeNode temp = queue.poll();
            if (null != temp) {
                if (null == temp.getLeft() && null == temp.getRight()) {
                    return count;
                }
                if (null != temp.getLeft()) {
                    queue.add(temp.getLeft());
                }
                if (null != temp.getRight()) {
                    queue.add(temp.getRight());
                }
            } else {
                if (!queue.isEmpty()) {
                    count++;
                    queue.add(null);
                }
            }
        }
        return count;
    }

    private static int getHeightRecursively(final BinaryTreeNode tree) {
        if (null == tree) {
            return 0;
        }
        return 1 + Math.max(getHeightRecursively(tree.getLeft()), getHeightRecursively(tree.getRight()));
    }

    private static int getHeightStack(final BinaryTreeNode tree) {
        int height = 0;
        final Stack<BinaryTreeNode> stack = new Stack<>();
        final Stack<BinaryTreeNode> path = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            final BinaryTreeNode temp = stack.peek();
            if (!path.isEmpty() && temp == path.peek()) {
                if (path.size() > height) {
                    height = path.size();
                }
                stack.pop();
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
        return height;
    }

}