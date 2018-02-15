package com.nagarro.algorithms.tree.bst;

import com.nagarro.algorithms.tree.BinaryTreeNode;

public final class DeleteElement {

    public static void main(final String[] args) {
        final BinaryTreeNode tree = FindElement.getBST();
        System.out.println("Before");
        inorder(tree);
        deleteRecursive(tree, 15);
        System.out.println("After");
        inorder(tree);
    }

    private static BinaryTreeNode deleteRecursive(BinaryTreeNode tree, final int data) {
        if (null == tree) {
            System.out.println("Node not found");
        } else if (data < tree.getData()) {
            tree.setLeft(deleteRecursive(tree.getLeft(), data));
        } else if (data > tree.getData()) {
            tree.setRight(deleteRecursive(tree.getRight(), data));
        } else {
            if (null == tree.getLeft()) {
                return tree.getRight();
            } else if (null == tree.getRight()) {
                return tree.getLeft();
            }
            final int max = getMax(tree.getLeft());
            tree.setData(max);
            tree.setLeft(deleteRecursive(tree.getLeft(), max));
        }
        return tree;
    }

    private static int getMax(final BinaryTreeNode tree) {
        BinaryTreeNode node = tree;
        while (null != node.getRight()) {
            node = node.getRight();
        }
        return node.getData();
    }

    private static void inorder(final BinaryTreeNode tree) {
        if (null == tree) {
            return;
        }
        inorder(tree.getLeft());
        System.out.println(tree.getData());
        inorder(tree.getRight());
    }

}
