package com.nagarro.algorithms.tree.bst;

import com.nagarro.algorithms.tree.BinaryTreeNode;

public final class FindMinElement {

    public static void main(String[] args) {
        findMin(FindElement.getBST());
        findMinRecursive(FindElement.getBST());
    }

    private static void findMin(final BinaryTreeNode tree) {
        if (null == tree) {
            System.out.println("Tree is empty");
        } else {
            BinaryTreeNode temp = tree;
            while (true) {
                if (null == temp.getLeft()) {
                    System.out.println("Minimum element in tree " + temp.getData());
                    break;
                }
                temp = temp.getLeft();
            }
        }
    }

    private static void findMinRecursive(final BinaryTreeNode tree) {
        if (null == tree) {
            return;
        }
        findMinRecursive(tree.getLeft());
        if (null == tree.getLeft()) {
            System.out.println(tree.getData());
        }
    }

}
