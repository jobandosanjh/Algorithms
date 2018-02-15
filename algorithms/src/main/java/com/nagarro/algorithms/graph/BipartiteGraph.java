package com.nagarro.algorithms.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public final class BipartiteGraph {

    public static void main(final String[] args) {
        final Graph graph = new Graph(8);
        graph.addVertex(new GraphNode("1"));
        graph.addVertex(new GraphNode("2"));
        graph.addVertex(new GraphNode("3"));
        graph.addVertex(new GraphNode("4"));
        graph.addVertex(new GraphNode("5"));
        graph.addVertex(new GraphNode("6"));
        graph.addVertex(new GraphNode("7"));
        graph.addVertex(new GraphNode("8"));

        graph.addEdge(new GraphNode("1"), new GraphNode("8"));
        graph.addEdge(new GraphNode("2"), new GraphNode("7"));
        graph.addEdge(new GraphNode("3"), new GraphNode("6"));
        graph.addEdge(new GraphNode("4"), new GraphNode("5"));
        graph.addEdge(new GraphNode("5"), new GraphNode("4"));
        graph.addEdge(new GraphNode("5"), new GraphNode("3"));
        graph.addEdge(new GraphNode("7"), new GraphNode("2"));
        graph.addEdge(new GraphNode("8"), new GraphNode("1"));

        biparitite(graph);
    }

    private static void biparitite(final Graph graph) {
        final Collection<GraphNode> set1 = new ArrayList<>(graph.getVertexCount() / 2);
        final Collection<GraphNode> set2 = new ArrayList<>(graph.getVertexCount() / 2);
        for (final LinkedList<GraphNode> source : graph.getGraphNodesList()) {
            if (!set2.contains(source.peek())) {
                set1.add(source.peek());
            }
            for (final GraphNode destination : source) {
                if (destination != source.peek()) {
                    if (set1.contains(source.peek())) {
                        if (set1.contains(destination)) {
                            System.out.println("Not Biparitite");
                            return;
                        }
                        if (!set2.contains(destination)) {
                            set2.add(destination);
                        }
                    } else {
                        if (set2.contains(destination)) {
                            System.out.println("Not Biparitite");
                            return;
                        }
                        if (!set1.contains(destination)) {
                            set1.add(destination);
                        }
                    }
                }
            }
        }
        System.out.println("Biparitite");
    }

}
