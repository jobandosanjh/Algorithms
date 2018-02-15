package com.nagarro.algorithms.tree.bst;

import com.nagarro.algorithms.tree.BinaryTreeNode;

public final class FindElement {

    public static void main(final String[] args) {
        final int item = 10;
        findElementRecursive(item, getBST());
        findElement(item, getBST());
    }

    private static void findElementRecursive(final int i, final BinaryTreeNode tree) {
        if (null == tree) {
            System.out.println("Item Not Found");
            return;
        }
        if (i == tree.getData()) {
            System.out.println("Item Found");
            return;
        } else if (i < tree.getData()) {
            findElementRecursive(i, tree.getLeft());
        } else {
            findElementRecursive(i, tree.getRight());
        }
    }

    private static void findElement(final int i, final BinaryTreeNode tree) {
        if (null == tree) {
            System.out.println("Tree is empty");
        } else {
            BinaryTreeNode temp = tree;
            boolean found = false;
            while (null != temp) {
                if (i == temp.getData()) {
                    System.out.println("Item Found");
                    found = true;
                    break;
                } else if (i < temp.getData()) {
                    temp = temp.getLeft();
                } else {
                    temp = temp.getRight();
                }
            }
            if (!found) {
                System.out.println("Item Not Found");
            }
        }
    }

    static BinaryTreeNode getBST() {
        return new BinaryTreeNode(5, new BinaryTreeNode(3, new BinaryTreeNode(2, null, null), new BinaryTreeNode(4,
                null, null)), new BinaryTreeNode(7, new BinaryTreeNode(6, null, null), new BinaryTreeNode(9,
                new BinaryTreeNode(8, null, null), new BinaryTreeNode(10, null, null))));
    }

}
