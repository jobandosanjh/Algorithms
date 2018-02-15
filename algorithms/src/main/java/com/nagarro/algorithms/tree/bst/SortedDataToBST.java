package com.nagarro.algorithms.tree.bst;

import java.util.Arrays;
import java.util.List;

import com.nagarro.algorithms.tree.BinaryTreeNode;

public final class SortedDataToBST {

    public static void main(final String[] args) {
        final BinaryTreeNode tree = convert(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println(isBST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static BinaryTreeNode convert(final List<Integer> data) {
        if (data.isEmpty()) {
            return null;
        }
        final BinaryTreeNode tree = new BinaryTreeNode();
        final int mid = data.size() / 2;
        tree.setData(data.get(mid == 0 ? 0 : mid - 1));
        if (mid > 0) {
            tree.setLeft(convert(data.subList(0, mid - 1)));
            tree.setRight(convert(data.subList(mid, data.size())));
        }
        return tree;
    }

    private static boolean isBST(final BinaryTreeNode tree, final int min, final int max) {
        if (null == tree) {
            return true;
        }
        if (tree.getData() <= min || tree.getData() >= max) {
            return false;
        }
        return isBST(tree.getLeft(), min, tree.getData()) && isBST(tree.getRight(), tree.getData(), max);
    }
}
