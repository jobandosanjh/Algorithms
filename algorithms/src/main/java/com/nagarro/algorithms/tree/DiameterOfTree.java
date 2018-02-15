package com.nagarro.algorithms.tree;

public final class DiameterOfTree {

    public static void main(final String[] args) {
        System.out.println(getHeight(PreOrder.getTree()));
        BinaryTreeNode tree = new BinaryTreeNode(1, new BinaryTreeNode(2, new BinaryTreeNode(4, null, null),
                new BinaryTreeNode(5, null, null)), new BinaryTreeNode(3, null, null));
        System.out.println(getDiameter(tree));
    }

    /**
     * The longest path passes through the root, The longest path is entirely contained in the left sub-tree, The
     * longest path is entirely contained in the right sub-tree.
     * 
     * The longest path through the root is simply the sum of the heights of the left and right sub-trees + 1 (for the
     * root node), and the other two can be found recursively:
     * 
     * @param tree
     * @return
     */
    private static int getDiameter(final BinaryTreeNode tree) {
        if (tree == null)
            return 0;

        int rootDiameter = getHeight(tree.getLeft()) + getHeight(tree.getRight()) + 1;
        int leftDiameter = getDiameter(tree.getLeft());
        int rightDiameter = getDiameter(tree.getRight());

        return Math.max(rootDiameter, Math.max(leftDiameter, rightDiameter));
    }

    private static int getHeight(final BinaryTreeNode tree) {
        if (null == tree) {
            return 0;
        }
        return Math.max(getHeight(tree.getLeft()), getHeight(tree.getRight())) + 1;
    }

}
