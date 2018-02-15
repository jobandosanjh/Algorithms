package com.nagarro.algorithms.tree.bst;

import com.nagarro.algorithms.tree.BinaryTreeNode;

public final class InsertElement {

    public static void main(final String[] args) {
        final BinaryTreeNode tree = FindElement.getBST();
        System.out.println("Before");
        inorder(tree);
        insert(tree, 1);
        System.out.println("After");
        inorder(tree);
        insertRecursively(tree, 11);
        System.out.println("After");
        inorder(tree);
    }

    private static void insert(BinaryTreeNode tree, final int data) {
        final BinaryTreeNode node = findElement(tree, data);
        final BinaryTreeNode newNode = new BinaryTreeNode(data, null, null);
        if (null == node) {
            tree = newNode;
        } else if (data == node.getData()) {
            System.out.println("Data is already present in tree.");
        } else {
            if (data < node.getData()) {
                node.setLeft(newNode);
            } else {
                node.setRight(newNode);
            }
        }
    }

    private static BinaryTreeNode findElement(final BinaryTreeNode tree, final int data) {
        BinaryTreeNode node = null;
        if (null != tree) {
            BinaryTreeNode temp = tree;
            while (null != temp) {
                if (data == temp.getData()) {
                    node = temp;
                    break;
                } else if (data < temp.getData()) {
                    node = temp;
                    temp = temp.getLeft();
                } else {
                    node = temp;
                    temp = temp.getRight();
                }
            }
        }
        return node;
    }

    private static BinaryTreeNode insertRecursively(BinaryTreeNode tree, final int data) {
        if (null == tree) {
            tree = new BinaryTreeNode(data, null, null);
        } else if (data < tree.getData()) {
            tree.setLeft(insertRecursively(tree.getLeft(), data));
        } else if (data > tree.getData()) {
            tree.setRight(insertRecursively(tree.getRight(), data));
        } else {
            System.out.println("Already Present In Tree");
        }
        return tree;
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
