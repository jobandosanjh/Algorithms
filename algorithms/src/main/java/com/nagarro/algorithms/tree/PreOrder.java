package com.nagarro.algorithms.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public final class PreOrder {

    public static void main(final String[] args) {
        getPreOrder(getTree());
        getPreOrderIteratively(getTree());
    }

    private static void getPreOrder(final BinaryTreeNode tree) {
        if (null != tree) {
            System.out.println(tree.getData());
            getPreOrder(tree.getLeft());
            getPreOrder(tree.getRight());
        }
    }

    private static void getPreOrderIteratively(final BinaryTreeNode tree) {
        final Collection<Integer> data = new ArrayList<>();
        if (null != tree) {
            final Stack<BinaryTreeNode> stack = new Stack<>();
            stack.add(tree);
            while (!stack.isEmpty()) {
                final BinaryTreeNode temp = stack.pop();
                data.add(temp.getData());
                if (null != temp.getRight()) {
                    stack.add(temp.getRight());
                }
                if (null != temp.getLeft()) {
                    stack.add(temp.getLeft());
                }
            }
        }
        System.out.println(data);
    }

    public static BinaryTreeNode getTree() {
        final BinaryTreeNode treeNode = new BinaryTreeNode();
        treeNode.setData(1);
        final BinaryTreeNode leftLeft = new BinaryTreeNode(4, null, null);
        final BinaryTreeNode leftRight = new BinaryTreeNode(5, null, null);
        final BinaryTreeNode left = new BinaryTreeNode(2, leftLeft, leftRight);
        treeNode.setLeft(left);

        final BinaryTreeNode rightLeft = new BinaryTreeNode(6, null, null);
        final BinaryTreeNode rightRight = new BinaryTreeNode(7, null, null);
        final BinaryTreeNode right = new BinaryTreeNode(3, rightLeft, rightRight);
        treeNode.setRight(right);
        return treeNode;
    }
}
