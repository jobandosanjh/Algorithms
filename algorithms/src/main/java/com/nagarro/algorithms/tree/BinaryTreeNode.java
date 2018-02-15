package com.nagarro.algorithms.tree;

import com.google.common.base.MoreObjects;

public class BinaryTreeNode {

    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(final int data, final BinaryTreeNode left, final BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(final int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(final BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(final BinaryTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("data", this.data).add("left", this.left).add("right", this.right)
                .toString();
    }

}
