package com.nagarro.algorithms.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;

public final class BellmanFord {

    public static void main(final String[] args) {
        final Graph graph = new Graph(5);
        graph.addVertex(new GraphNode("A"));
        graph.addVertex(new GraphNode("B"));
        graph.addVertex(new GraphNode("C"));
        graph.addVertex(new GraphNode("D"));
        graph.addVertex(new GraphNode("E"));

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "E", 4);
        graph.addEdge("C", "B", 2);
        graph.addEdge("C", "D", 4);
        graph.addEdge("D", "E", 4);

        getShortestPath(graph, "A");
    }

    private static void getShortestPath(final Graph graph, final String source) {
        final Collection<TableRow> tableRows = new ArrayList<>(graph.getVerticesCount());
        Arrays.stream(graph.getGraphNodesList()).forEach(input -> {
            tableRows.add(new TableRow(input.peek().getName()));
        });

        UnweightedShortestPath.getTableRow(tableRows, source).setDistance(0);

        final Queue<GraphNode> queue = new ArrayDeque<>();

        queue.add(UnweightedShortestPath.getAdjacentList(graph, source).peek());

        while (!queue.isEmpty()) {
            final GraphNode graphNode = queue.poll();
            for (final GraphNode input : UnweightedShortestPath.getAdjacentList(graph, graphNode.getName())) {
                final int oldTableDistance = UnweightedShortestPath.getTableRow(tableRows, graphNode.getName())
                        .getDistance();
                final int distance = getEdge(graph.getEdges(), graphNode.getName(), input.getName()).getWeight();
                final int newTableDistance = oldTableDistance + distance;
                final TableRow tableRow = UnweightedShortestPath.getTableRow(tableRows, input.getName());
                if (tableRow.getDistance() == -1) {
                    tableRow.setDistance(newTableDistance);
                    queue.add(input);
                    tableRow.setPath(tableRow.getPath().append(input.getName()));
                } else if (newTableDistance < tableRow.getDistance()) {
                    tableRow.setDistance(newTableDistance);
                    tableRow.setPath(tableRow.getPath().append(graphNode.getName()));
                    if (!queue.contains(input)) {
                        queue.add(input);
                    }
                }
            }
        }

        tableRows.stream().forEach(System.out::println);

    }

    private static Edge getEdge(final Collection<Edge> edges, final String source, final String destination) {
        return edges.stream().filter(input -> {
            return input.getSource().equalsIgnoreCase(source) && input.getDestination().equalsIgnoreCase(destination);
        }).findFirst().orElse(new Edge());
    }

}
