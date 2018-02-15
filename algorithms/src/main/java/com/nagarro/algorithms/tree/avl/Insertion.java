package com.nagarro.algorithms.tree.avl;

import java.util.LinkedList;
import java.util.Queue;

import com.nagarro.algorithms.tree.BinaryTreeNode;
import com.nagarro.algorithms.tree.PreOrder;

public final class Insertion {

    public static void main(final String[] args) {
        System.out.println(getHeight(PreOrder.getTree()));
        System.out.println(findNode(PreOrder.getTree(), 10));

        BinaryTreeNode tree = insert(null, 9);
        tree = insert(tree, 5);
        tree = insert(tree, 6);
    }

    private static BinaryTreeNode insert(BinaryTreeNode tree, final int data) {
        final BinaryTreeNode newNode = new BinaryTreeNode(data, null, null);
        if (null == tree) {
            tree = newNode;
        } else {
            final BinaryTreeNode node = findNode(tree, data);
            if (data < node.getData()) {
                node.setLeft(newNode);
            } else {
                node.setRight(newNode);
            }

            final int balance = getHeight(tree.getLeft()) - getHeight(tree.getRight());

            if (balance > 1 && data < tree.getLeft().getData())
                return rightRotate(tree);

            // Right Right Case
            if (balance < -1 && data > tree.getRight().getData())
                return leftRotate(tree);

            // Left Right Case
            if (balance > 1 && data > tree.getLeft().getData()) {
                tree.setLeft(leftRotate(tree.getLeft()));
                return rightRotate(tree);
            }

            // Right Left Case
            if (balance < -1 && data < tree.getRight().getData()) {
                tree.setRight(rightRotate(tree.getRight()));
                return leftRotate(tree);
            }
        }
        return tree;
    }

    private static BinaryTreeNode findNode(final BinaryTreeNode tree, final int data) {
        BinaryTreeNode temp = tree;
        BinaryTreeNode node = tree;
        while (null != temp) {
            node = temp;
            if (data == temp.getData()) {
                throw new AssertionError("Can't insert duplicate values");
            } else if (data < temp.getData()) {
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return node;
    }

    private static BinaryTreeNode rightRotate(final BinaryTreeNode root) {
        final BinaryTreeNode newRoot = root.getLeft();
        root.setLeft(newRoot.getRight());
        newRoot.setRight(root);
        return newRoot;
    }

    private static BinaryTreeNode leftRotate(final BinaryTreeNode root) {
        final BinaryTreeNode newRoot = root.getRight();
        root.setRight(newRoot.getLeft());
        newRoot.setLeft(root);
        return newRoot;
    }

    private static int getHeight(final BinaryTreeNode tree) {
        int height = 0;
        if (null != tree) {
            final Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.add(tree);
            queue.add(null);
            height = 1;
            while (!queue.isEmpty()) {
                final BinaryTreeNode temp = queue.poll();
                if (null == temp) {
                    if (!queue.isEmpty()) {
                        queue.add(null);
                        height++;
                    }
                } else {
                    if (null != temp.getLeft()) {
                        queue.add(temp.getLeft());
                    }
                    if (null != temp.getRight()) {
                        queue.add(temp.getRight());
                    }
                }
            }
        }
        return height;
    }
}
