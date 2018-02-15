package com.nagarro.algorithms.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public final class ParameterOfTree {

    public static void main(final String[] args) {
        System.out.println(getParameter(PreOrder.getTree()));
    }

    private static int getParameter(final BinaryTreeNode tree) {
        final int parameter = tree.getData() + getParameterLeft(tree.getLeft()) + getParameterRight(tree.getRight())
                + getParameterLeavesExcludingLeftmostAndRightmost(tree);
        return parameter;
    }

    private static int getParameterLeft(final BinaryTreeNode tree) {
        if (null == tree) {
            return 0;
        }
        return tree.getData() + getParameterLeft(tree.getLeft());
    }

    private static int getParameterRight(final BinaryTreeNode tree) {
        if (null == tree) {
            return 0;
        }
        return tree.getData() + getParameterRight(tree.getRight());
    }

    private static int getParameterLeavesExcludingLeftmostAndRightmost(final BinaryTreeNode tree) {
        final Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        final List<Integer> data = new ArrayList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            final BinaryTreeNode temp = queue.poll();
            if (null == temp.getLeft() && null == temp.getRight()) {
                data.add(temp.getData());
            }
            if (null != temp.getLeft()) {
                queue.add(temp.getLeft());
            }
            if (null != temp.getRight()) {
                queue.add(temp.getRight());
            }
        }
        data.remove(data.size() - 1);
        data.remove(0);
        return data.stream().mapToInt(i -> i.intValue()).sum(); 
    }

}
