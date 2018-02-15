package com.nagarro.algorithms.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public final class SearchElement {

    public static void main(final String[] args) {
        findElement(PreOrder.getTree(), 9);
        System.out.println(findElementRecursive(PreOrder.getTree(), 9));
    }

    private static void findElement(final BinaryTreeNode tree, final int element) {
        if (null != tree) {
            final Queue<BinaryTreeNode> queue = new ArrayDeque<>();
            queue.add(tree);
            boolean found = false;
            while (!queue.isEmpty()) {
                final BinaryTreeNode node = queue.poll();
                if (node.getData() == element) {
                    System.out.println("Found");
                    found = true;
                    break;
                }
                if (null != node.getLeft()) {
                    queue.add(node.getLeft());
                }
                if (null != node.getRight()) {
                    queue.add(node.getRight());
                }
            }
            if (queue.isEmpty() && !found) {
                System.out.println("Not Found");
            }
        } else {
            System.out.println("Not Found");
        }
    }

    private static boolean findElementRecursive(final BinaryTreeNode tree, final int element) {
        if (null == tree) {
            return false;
        }
        if (tree.getData() == element) {
            return true;
        }
        return findElementRecursive(tree.getLeft(), element) || findElementRecursive(tree.getRight(), element);
    }

}
