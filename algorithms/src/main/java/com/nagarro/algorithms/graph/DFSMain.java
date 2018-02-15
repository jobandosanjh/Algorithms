package com.nagarro.algorithms.graph;

public final class DFSMain {

    public static void main(final String[] args) {
        final DFS dfs = new DFS(8);
        dfs.addVertex('A');
        dfs.addVertex('B');
        dfs.addVertex('C');
        dfs.addVertex('D');
        dfs.addVertex('E');
        dfs.addVertex('F');
        dfs.addVertex('G');
        dfs.addVertex('H');

        dfs.addEdge(0, 1);
        dfs.addEdge(1, 2);
        dfs.addEdge(1, 7);
        dfs.addEdge(2, 3);
        dfs.addEdge(2, 4);
        dfs.addEdge(4, 5);
        dfs.addEdge(4, 6);
        dfs.addEdge(4, 7);
        
        dfs.dfs();
    }

}
