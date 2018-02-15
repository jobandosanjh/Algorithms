package com.nagarro.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class DirectedGraphCycle {

    public static void main(final String[] args) {
        final Graph graph = new Graph(6);
        graph.addVertex(new GraphNode("1"));
        graph.addVertex(new GraphNode("2"));
        graph.addVertex(new GraphNode("3"));
        graph.addVertex(new GraphNode("4"));
        graph.addVertex(new GraphNode("5"));
        graph.addVertex(new GraphNode("6"));

        graph.addEdge(new GraphNode("1"), new GraphNode("2"));
        graph.addEdge(new GraphNode("1"), new GraphNode("3"));
        graph.addEdge(new GraphNode("2"), new GraphNode("3"));
        graph.addEdge(new GraphNode("4"), new GraphNode("1"));
        graph.addEdge(new GraphNode("4"), new GraphNode("5"));
        graph.addEdge(new GraphNode("5"), new GraphNode("6"));
        graph.addEdge(new GraphNode("6"), new GraphNode("4"));

        findCycle(graph);
    }

    private static void findCycle(final Graph graph) {
        final int totalVertices = graph.getVertexCount();
        final Collection<String> whiteSet = new ArrayList<>(totalVertices);
        final Collection<String> greySet = new ArrayList<>(totalVertices);
        final Collection<String> blackSet = new ArrayList<>(totalVertices);

        Arrays.stream(graph.getGraphNodesList()).forEach(input -> whiteSet.add(input.peek().getName()));

        while (!whiteSet.isEmpty()) {
            if (dfs(whiteSet.stream().findFirst().get(), whiteSet, greySet, blackSet, graph)) {
                System.out.println("Cycle Exist");
                break;
            }
        }
    }

    private static boolean dfs(final String vertex, final Collection<String> whiteSet,
            final Collection<String> greySet, final Collection<String> blackSet, final Graph graph) {
        moveVertex(vertex, whiteSet, greySet);
        for (final GraphNode graphNode : Arrays.stream(graph.getGraphNodesList())
                .filter(input -> input.peek().getName().equals(vertex)).findFirst().get()) {
            if (!graphNode.getName().equals(vertex)) {
                if (greySet.contains(graphNode.getName())) {
                    return true;
                }
                if (blackSet.contains(graphNode.getName())) {
                    continue;
                }
                if (dfs(graphNode.getName(), whiteSet, greySet, blackSet, graph)) {
                    return true;
                }
            }
        }
        moveVertex(vertex, greySet, blackSet);
        return false;
    }

    private static void moveVertex(final String vertex, final Collection<String> source,
            final Collection<String> destination) {
        source.remove(vertex);
        destination.add(vertex);
    }
}
