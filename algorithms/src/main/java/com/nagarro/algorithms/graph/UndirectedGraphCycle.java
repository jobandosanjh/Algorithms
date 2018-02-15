package com.nagarro.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public final class UndirectedGraphCycle {

    public static void main(final String[] args) {
        final Graph graph = new Graph(5);
        graph.addVertex(new GraphNode("0"));
        graph.addVertex(new GraphNode("1"));
        graph.addVertex(new GraphNode("2"));
        graph.addVertex(new GraphNode("3"));
        graph.addVertex(new GraphNode("4"));

        graph.addEdge(new GraphNode("1"), new GraphNode("0"));
        graph.addEdge(new GraphNode("1"), new GraphNode("2"));
        graph.addEdge(new GraphNode("2"), new GraphNode("0"));
        graph.addEdge(new GraphNode("0"), new GraphNode("3"));
        graph.addEdge(new GraphNode("3"), new GraphNode("4"));

        checkCycleUsingSet(graph);
    }

    private static void checkCycleUsingSet(final Graph graph) {
        final Collection<String> set = new ArrayList<>(graph.getVertexCount());
        Arrays.stream(graph.getGraphNodesList()).forEach(input -> set.add(input.peek().getName()));

        for (final LinkedList<GraphNode> node : graph.getGraphNodesList()) {
            final GraphNode source = node.peek();
            for (final GraphNode destination : node) {
                final String set1 = set.stream().filter(input -> input.contains(source.getName())).findFirst().get();
                final String set2 = set.stream().filter(input -> input.contains(destination.getName())).findFirst()
                        .get();
                if (!source.getName().equals(destination.getName())) {
                    if (set1.equals(set2)) {
                        System.out.println("Cycle Exist With Edge " + source.getName() + "-" + destination.getName());
                        break;
                    } else {
                        set.remove(set1);
                        set.remove(set2);
                        set.add("{" + set1 + "," + set2 + "}");
                    }
                }
            }
        }
        System.out.println(set);
    }

}
