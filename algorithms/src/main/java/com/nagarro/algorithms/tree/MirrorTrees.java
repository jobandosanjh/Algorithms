package com.nagarro.algorithms.tree;

public final class MirrorTrees {

    public static void main(final String[] args) {
        System.out.println(isMirror(PreOrder.getTree(), PreOrder.getTree()));
        System.out.println(isMirror(new BinaryTreeNode(0, new BinaryTreeNode(1, null, null), null), new BinaryTreeNode(
                0, null, new BinaryTreeNode(1, null, null))));
    }

    private static boolean isMirror(final BinaryTreeNode tree1, final BinaryTreeNode tree2) {
        if (null == tree1 && null == tree2) {
            return true;
        }
        if (null == tree1 || null == tree2) {
            return false;
        }
        return tree1.getData() == tree2.getData() && isMirror(tree1.getLeft(), tree2.getRight())
                && isMirror(tree1.getRight(), tree2.getLeft());
    }
}
