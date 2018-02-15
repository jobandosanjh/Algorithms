package com.nagarro.algorithms.graph;

public final class MatrixGraphMain {

    public static void main(final String[] args) {
        final MatrixGraph matrixGraph = new MatrixGraph(4);
        System.out.println("\t A \t\t B \t\t C \t\t D");
        System.out.println("Initial Array :");
        printArray(matrixGraph.getMatrix());
        matrixGraph.addEdge(0, 1);
        matrixGraph.addEdge(1, 2);
        matrixGraph.addEdge(2, 3);
        matrixGraph.addEdge(2, 0);
        matrixGraph.addEdge(0, 3);
        System.out.println("After Linking :");
        printArray(matrixGraph.getMatrix());
        System.out.println(matrixGraph.isEdge(0, 1));
        matrixGraph.removeEdge(0, 1);
        System.out.println(matrixGraph.isEdge(0, 1));
    }

    private static void printArray(final boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("[" + i + "," + "" + j + "] = " + array[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }

    }

}
