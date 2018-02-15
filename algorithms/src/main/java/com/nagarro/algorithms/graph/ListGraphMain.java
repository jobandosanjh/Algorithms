package com.nagarro.algorithms.graph;

public final class ListGraphMain {

    public static void main(final String[] args) {
        final ListGraph listGraph = new ListGraph(4);
        listGraph.addEdge(0, 1, 1);
        listGraph.addEdge(0, 2, 2);
        listGraph.addEdge(0, 3, 1);
        listGraph.addEdge(1, 2, 1);
        listGraph.addEdge(2, 3, 1);
        System.out.println(listGraph);
    }

}
