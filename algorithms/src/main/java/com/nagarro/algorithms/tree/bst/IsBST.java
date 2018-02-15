package com.nagarro.algorithms.tree.bst;

import java.util.ArrayDeque;
import java.util.Queue;

import com.nagarro.algorithms.tree.BinaryTreeNode;
import com.nagarro.algorithms.tree.PreOrder;

public final class IsBST {

    public static void main(final String[] args) {
        System.out.println(isBinarySearchTree(PreOrder.getTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBinarySearchTree(FindElement.getBST(), Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBinarySearchTreeIteravtive(PreOrder.getTree()));
        System.out.println(isBinarySearchTreeIteravtive(FindElement.getBST()));
    }

    private static boolean isBinarySearchTree(final BinaryTreeNode tree, final int low, final int max) {
        if (null == tree) {
            return true;
        }
        if (tree.getData() <= low || tree.getData() >= max) {
            return false;
        }
        return isBinarySearchTree(tree.getLeft(), low, tree.getData())
                && isBinarySearchTree(tree.getRight(), tree.getData(), max);
    }

    private static boolean isBinarySearchTreeIteravtive(final BinaryTreeNode tree) {
        if (null != tree) {
            final Queue<BinaryTreeNode> queue = new ArrayDeque<>();
            queue.add(tree);
            while (!queue.isEmpty()) {
                final BinaryTreeNode temp = queue.poll();
                if (null != temp.getLeft()) {
                    queue.add(temp.getLeft());
                    if (temp.getData() < temp.getLeft().getData()) {
                        return false;
                    }
                }
                if (null != temp.getRight()) {
                    queue.add(temp.getRight());
                    if (temp.getData() > temp.getRight().getData()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
