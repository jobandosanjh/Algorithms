package com.nagarro.algorithms.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import com.google.common.base.MoreObjects;

public final class UnweightedShortestPath {

    public static void main(final String[] args) {
        final Graph graph = new Graph(7);
        graph.addVertex(new GraphNode("A"));
        graph.addVertex(new GraphNode("B"));
        graph.addVertex(new GraphNode("C"));
        graph.addVertex(new GraphNode("D"));
        graph.addVertex(new GraphNode("E"));
        graph.addVertex(new GraphNode("F"));
        graph.addVertex(new GraphNode("G"));

        graph.addEdge(new GraphNode("A"), new GraphNode("B"));
        graph.addEdge(new GraphNode("A"), new GraphNode("D"));
        graph.addEdge(new GraphNode("B"), new GraphNode("D"));
        graph.addEdge(new GraphNode("B"), new GraphNode("E"));
        graph.addEdge(new GraphNode("E"), new GraphNode("G"));
        graph.addEdge(new GraphNode("D"), new GraphNode("F"));
        graph.addEdge(new GraphNode("D"), new GraphNode("G"));
        graph.addEdge(new GraphNode("G"), new GraphNode("F"));
        graph.addEdge(new GraphNode("C"), new GraphNode("A"));
        graph.addEdge(new GraphNode("C"), new GraphNode("F"));

        shortestPath(graph, "C");

    }

    private static void shortestPath(final Graph graph, final String source) {
        final Collection<TableRow> tableRows = new ArrayList<>(graph.getVerticesCount());
        Arrays.stream(graph.getGraphNodesList()).forEach(input -> {
            tableRows.add(new TableRow(input.peek().getName()));
        });

        getTableRow(tableRows, source).setDistance(0);

        final Queue<GraphNode> queue = new ArrayDeque<>();
        queue.add(getAdjacentList(graph, source).peek());

        while (!queue.isEmpty()) {
            final GraphNode graphNode = queue.poll();
            for (final GraphNode input : getAdjacentList(graph, graphNode.getName())) {
                final TableRow tableRow = getTableRow(tableRows, input.getName());
                if (tableRow.getDistance() == -1) {
                    tableRow.setDistance(getTableRow(tableRows, graphNode.getName()).getDistance() + 1);
                    tableRow.setPath(tableRow.getPath().append(graphNode.getName()));
                    queue.add(getAdjacentList(graph, tableRow.getVertex()).peek());
                }
            }
        }

        tableRows.stream().forEach(System.out::println);

    }

    static LinkedList<GraphNode> getAdjacentList(final Graph graph, final String source) {
        return Arrays.stream(graph.getGraphNodesList()).filter(input -> {
            return input.peek().getName().equalsIgnoreCase(source);
        }).findFirst().get();
    }

    static TableRow getTableRow(final Collection<TableRow> tableRows, final String source) {
        return tableRows.stream().filter(input -> input.getVertex().equalsIgnoreCase(source)).findFirst().get();
    }
}

class TableRow {

    private String vertex;
    private int distance;
    private StringBuilder path;

    public TableRow(final String name) {
        this.vertex = name;
        this.distance = -1;
        this.path = new StringBuilder();
    }

    public String getVertex() {
        return vertex;
    }

    public void setVertex(final String vertex) {
        this.vertex = vertex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(final int distance) {
        this.distance = distance;
    }

    public StringBuilder getPath() {
        return path;
    }

    public void setPath(final StringBuilder path) {
        this.path = path;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.distance);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final TableRow that = (TableRow) obj;
        return Objects.equals(this.vertex, that.vertex);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("vertex", this.vertex).add("distance", this.distance)
                .add("path", this.path).toString();
    }
}
