package com.nagarro.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Kruskal {

    public static void main(final String[] args) {

        final Graph graph = new Graph(7);
        graph.addVertex(new GraphNode("A"));
        graph.addVertex(new GraphNode("B"));
        graph.addVertex(new GraphNode("C"));
        graph.addVertex(new GraphNode("D"));
        graph.addVertex(new GraphNode("E"));
        graph.addVertex(new GraphNode("F"));
        graph.addVertex(new GraphNode("G"));

        graph.addEdge("A", "C", 7);
        graph.addEdge("A", "D", 5);
        graph.addEdge("B", "C", 8);
        graph.addEdge("B", "E", 5);
        graph.addEdge("C", "D", 9);
        graph.addEdge("C", "E", 7);
        graph.addEdge("D", "E", 15);
        graph.addEdge("D", "F", 6);
        graph.addEdge("E", "F", 8);
        graph.addEdge("E", "G", 9);
        graph.addEdge("F", "G", 11);

        getMinimalSpanningTree(graph);
    }

    private static void getMinimalSpanningTree(final Graph graph) {
        final Collection<Edge> edges = graph.getEdges();
        Collections.sort((List<Edge>) edges, (final Edge obj1, final Edge obj2) -> obj1.getWeight() - obj2.getWeight());
        final Collection<String> set = new ArrayList<>();
        Arrays.stream(graph.getGraphNodesList()).forEach(input -> set.add(input.peek().getName()));
        while (!edges.isEmpty()) {
            final Edge edge = edges.stream().findFirst().get();
            edges.remove(edge);
            final String source = set.stream().filter(input -> input.contains(edge.getSource())).findFirst().get();
            final String destination = set.stream().filter(input -> input.contains(edge.getDestination())).findFirst()
                    .get();
            if (!source.equals(destination)) {
                set.remove(source);
                set.remove(destination);
                set.add("(" + source + "," + destination + ")");
                System.out.println(edge);
            }
        }
    }
}
