package com.nagarro.algorithms.tree;

import java.util.Queue;

import com.google.common.collect.Queues;

public final class InsertElement {

    public static void main(final String[] args) {
        insertElement(PreOrder.getTree(), 10);
        final BinaryTreeNode tree = PreOrder.getTree();
        insertElementRecursively(tree, 10);
    }

    private static void insertElement(final BinaryTreeNode tree, final int data) {
        final Queue<BinaryTreeNode> queue = Queues.newArrayDeque();
        queue.add(tree);
        while (!queue.isEmpty()) {
            final BinaryTreeNode temp = queue.poll();
            BinaryTreeNode left = temp.getLeft();
            BinaryTreeNode right = temp.getRight();
            if (null != left) {
                queue.add(left);
            } else {
                left = new BinaryTreeNode(data, null, null);
                temp.setLeft(left);
                break;
            }
            if (null != right) {
                queue.add(right);
            } else {
                right = new BinaryTreeNode(data, null, null);
                temp.setRight(right);
                break;
            }
        }
    }

    private static void insertElementRecursively(BinaryTreeNode tree, final int data) {
        if (null == tree) {
            tree = new BinaryTreeNode(data, null, null);
        } else {
            insert(tree, data);
        }
    }

    private static void insert(final BinaryTreeNode tree, final int data) {
        if (tree.getData() > data) {
            if (null == tree.getLeft()) {
                tree.setLeft(new BinaryTreeNode(data, null, null));
            } else {
                insert(tree.getLeft(), data);
            }
        } else {
            if (null == tree.getRight()) {
                tree.setRight(new BinaryTreeNode(data, null, null));
            } else {
                insert(tree.getRight(), data);
            }
        }
    }
}
