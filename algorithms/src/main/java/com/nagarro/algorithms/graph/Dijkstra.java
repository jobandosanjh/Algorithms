package com.nagarro.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public final class Dijkstra {

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

        getShortestPathMaps(graph, "A");
    }

    private static void getShortestPathMaps(final Graph graph, final String source) {
        final Map<String, String> parentMap = new HashMap<>();
        parentMap.put(source, null);
        final Map<String, Integer> distanceMap = new HashMap<>();
        distanceMap.put(source, 0);
        final Collection<Vertex> collection = new ArrayList<>();
        Arrays.stream(graph.getGraphNodesList()).forEach(
                input -> collection.add(new Vertex(input.peek().getName(), Integer.MAX_VALUE)));
        collection.stream().filter(input -> input.getName().equalsIgnoreCase(source)).findFirst().get().setWeight(0);

        while (!collection.isEmpty()) {
            Collections.sort((List<Vertex>) collection, new Comparator<Vertex>() {
                @Override
                public int compare(final Vertex o1, final Vertex o2) {
                    return o1.getWeight() - o2.getWeight();
                }
            });
            final Vertex vertex = collection.stream().findFirst().get();
            collection.remove(vertex);
            distanceMap.put(vertex.getName(), vertex.getWeight());
            for (final GraphNode graphNode : UnweightedShortestPath.getAdjacentList(graph, vertex.name)) {
                final boolean condition1 = collection.stream().anyMatch(input -> {
                    return input.getName().equalsIgnoreCase(graphNode.getName());
                });
                if (condition1) {
                    final int newDistance = distanceMap.get(vertex.getName())
                            + getEdge(graph.getEdges(), vertex.getName(), graphNode.getName()).getWeight();
                    final int oldDistance = collection.stream().filter(input -> {
                        return input.getName().equalsIgnoreCase(graphNode.getName());
                    }).findFirst().get().getWeight();
                    if (oldDistance > newDistance) {
                        parentMap.put(graphNode.getName(), vertex.getName());
                        collection.stream().filter(input -> {
                            return input.getName().equalsIgnoreCase(graphNode.getName());
                        }).findFirst().get().setWeight(newDistance);
                    }
                }
            }
        }
        distanceMap.keySet().stream().forEach(input -> System.out.println(input + "[" + distanceMap.get(input) + "]"));
    }

    private static Edge getEdge(final Collection<Edge> edges, final String source, final String destination) {
        return edges.stream().filter(input -> {
            return input.getSource().equalsIgnoreCase(source) && input.getDestination().equalsIgnoreCase(destination);
        }).findFirst().orElse(new Edge());
    }

    static class Vertex {

        private String name;
        private int weight;

        public Vertex(final String name, final int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(final int weight) {
            this.weight = weight;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.name);
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            final Vertex that = (Vertex) obj;
            return Objects.equal(this.name, that.name) && Objects.equal(this.weight, that.weight);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("name", this.name).add("weight", this.weight).toString();
        }

    }

}

class Edge {

    private String source;
    private String destination;
    private int weight;

    public Edge() {
    }

    public Edge(final String source, final String destination, final int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getSource() {
        return source;
    }

    public void setSource(final String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.weight);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final Edge that = (Edge) obj;
        return Objects.equal(this.source, that.source) && Objects.equal(this.destination, that.destination)
                && Objects.equal(this.weight, that.weight);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("source", this.source).add("destination", this.destination)
                .add("weight", this.weight).toString();
    }

}