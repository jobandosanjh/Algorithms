package com.nagarro.algorithms.tree.bst;

import com.nagarro.algorithms.tree.BinaryTreeNode;

public final class FindMaxElement {

    public static void main(final String[] args) {
        findMax(FindElement.getBST());
        findMaxRecursive(FindElement.getBST());
    }

    private static void findMax(final BinaryTreeNode tree) {
        if (null == tree) {
            System.out.println("Tree is empty");
        } else {
            BinaryTreeNode temp = tree;
            while (true) {
                if (null == temp.getRight()) {
                    System.out.println("Maximum element in tree " + temp.getData());
                    break;
                }
                temp = temp.getRight();
            }
        }
    }

    private static void findMaxRecursive(final BinaryTreeNode tree) {
        if (null == tree) {
            return;
        }
        findMaxRecursive(tree.getRight());
        if (null == tree.getRight()) {
            System.out.println(tree.getData());
        }
    }

}
