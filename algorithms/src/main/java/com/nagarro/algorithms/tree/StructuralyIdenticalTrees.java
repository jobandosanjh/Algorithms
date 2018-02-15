package com.nagarro.algorithms.tree;

public final class StructuralyIdenticalTrees {

    public static void main(final String[] args) {
        System.out.println(isIdentical(PreOrder.getTree(), PreOrder.getTree()));
    }

    private static boolean isIdentical(final BinaryTreeNode tree1, final BinaryTreeNode tree2) {
        if (null == tree1 && null == tree2) {
            return true;
        }
        if (null == tree1 || null == tree2) {
            return false;
        }
        return tree1.getData() == tree2.getData() && isIdentical(tree1.getLeft(), tree2.getLeft())
                && isIdentical(tree1.getRight(), tree2.getRight());
    }

}
