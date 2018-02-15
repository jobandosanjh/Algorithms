package com.nagarro.algorithms.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public final class ConvertTreeToMirror {

    public static void main(final String[] args) {
        print(convert(PreOrder.getTree()));
        System.out.println(isMirror(PreOrder.getTree(), convert(PreOrder.getTree())));
    }

    private static BinaryTreeNode convert(final BinaryTreeNode tree) {
        BinaryTreeNode temp = null;
        if (null != tree) {
            convert(tree.getLeft());
            convert(tree.getRight());
            temp = tree.getLeft();
            tree.setLeft(tree.getRight());
            tree.setRight(temp);
        }
        return tree;
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

    private static void print(final BinaryTreeNode tree) {
        if (null != tree) {
            final Queue<BinaryTreeNode> queue = new ArrayDeque<>();
            queue.add(tree);
            while (!queue.isEmpty()) {
                final BinaryTreeNode temp = queue.poll();
                System.out.println(temp.getData());
                if (null != temp.getLeft()) {
                    queue.add(temp.getLeft());
                }
                if (null != temp.getRight()) {
                    queue.add(temp.getRight());
                }
            }
        }
    }

}
