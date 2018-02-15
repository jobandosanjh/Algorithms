package com.nagarro.algorithms.tree.bst;

import com.nagarro.algorithms.tree.BinaryTreeNode;

public final class InorderPredessorSuccessor {

    public static void main(final String[] args) {
        getPredessor(FindElement.getBST(), 9);
        getSuccessor(FindElement.getBST(), 9);
    }

    private static void getSuccessor(final BinaryTreeNode tree, final int data) {
        final BinaryTreeNode temp = findNode(tree, data);
        if (null != temp) {
            BinaryTreeNode right = temp.getRight();
            if (null != right) {
                while (null != right.getLeft()) {
                    right = right.getLeft();
                }
                System.out.println("Successor of node " + data + " is " + right.getData());
            }
        }
    }

    private static void getPredessor(final BinaryTreeNode tree, final int data) {
        final BinaryTreeNode temp = findNode(tree, data);
        if (null != temp) {
            BinaryTreeNode left = temp.getLeft();
            if (null != left) {
                while (null != left.getRight()) {
                    left = left.getRight();
                }
                System.out.println("The Predessor of node " + data + " is " + left.getData());
            }
        }
    }

    private static BinaryTreeNode findNode(final BinaryTreeNode tree, final int data) {
        BinaryTreeNode node = null;
        if (null != tree) {
            BinaryTreeNode temp = tree;
            while (null != temp) {
                if (data == temp.getData()) {
                    node = temp;
                    break;
                } else if (data < temp.getData()) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
        }
        return node;
    }
}
