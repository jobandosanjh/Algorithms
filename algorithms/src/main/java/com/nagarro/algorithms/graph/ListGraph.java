package com.nagarro.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class ListGraph {

    private int verticesCount;
    private List<Integer> vertices;
    private LinkedList<WeightedNode>[] edges;

    @SuppressWarnings("unchecked")
    public ListGraph(final int verticesCount) {
        this.verticesCount = verticesCount;
        this.vertices = new ArrayList<>(verticesCount);
        this.edges = new LinkedList[verticesCount];
        for (int i = 0; i < verticesCount; i++) {
            this.vertices.add(i);
            this.edges[i] = new LinkedList<>();
        }
    }

    public void addEdge(final int source, final int destination, final int weight) {
        if (-1 != vertices.indexOf(source) && -1 != vertices.indexOf(destination)) {
            edges[source].addFirst(new WeightedNode(destination, weight));
            edges[destination].addFirst(new WeightedNode(source, weight));
        }
    }

    public int getVerticesCount() {
        return this.verticesCount;
    }

    public void setVerticesCount(final int verticesCount) {
        this.verticesCount = verticesCount;
    }

    public List<Integer> getVertices() {
        return this.vertices;
    }

    public void setVertices(final List<Integer> vertices) {
        this.vertices = vertices;
    }

    public LinkedList<WeightedNode>[] getEdges() {
        return this.edges;
    }

    public void setEdges(final LinkedList<WeightedNode>[] edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "ListGraph [verticesCount=" + this.verticesCount + ", vertices=" + this.vertices + ", edges="
                + Arrays.asList(this.edges) + "]";
    }

    class WeightedNode {

        private int vertex;
        private int weight;

        public WeightedNode(final int vertex, final int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return this.vertex;
        }

        public void setVertex(final int vertex) {
            this.vertex = vertex;
        }

        public int getWeight() {
            return this.weight;
        }

        public void setWeight(final int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "WeightedNode [vertex=" + this.vertex + ", weight=" + this.weight + "]";
        }
    }
}
