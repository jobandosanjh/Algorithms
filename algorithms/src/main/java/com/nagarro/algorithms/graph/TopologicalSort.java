package com.nagarro.algorithms.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import com.google.common.base.MoreObjects;

public final class TopologicalSort {

    public static void main(final String[] args) throws CloneNotSupportedException {
        final Graph graph = new Graph(8);
        graph.addVertex(new GraphNode("7"));
        graph.addVertex(new GraphNode("5"));
        graph.addVertex(new GraphNode("3"));
        graph.addVertex(new GraphNode("11"));
        graph.addVertex(new GraphNode("8"));
        graph.addVertex(new GraphNode("2"));
        graph.addVertex(new GraphNode("9"));
        graph.addVertex(new GraphNode("10"));

        graph.addEdge(new GraphNode("7"), new GraphNode("11"));
        graph.addEdge(new GraphNode("7"), new GraphNode("8"));
        graph.addEdge(new GraphNode("5"), new GraphNode("11"));
        graph.addEdge(new GraphNode("3"), new GraphNode("8"));
        graph.addEdge(new GraphNode("3"), new GraphNode("10"));
        graph.addEdge(new GraphNode("11"), new GraphNode("2"));
        graph.addEdge(new GraphNode("11"), new GraphNode("9"));
        graph.addEdge(new GraphNode("8"), new GraphNode("9"));

        topologicalSort((Graph) graph.clone());
    }

    private static void topologicalSort(final Graph graph) {
        final Queue<GraphNode> queue = new ArrayDeque<>();
        for (final LinkedList<GraphNode> linkedList : graph.getGraphNodesList()) {
            final GraphNode node = linkedList.peek();
            if (node.getInDegree() == 0) {
                queue.add(node);
                while (!queue.isEmpty()) {
                    final String nodeName = queue.peek().getName();
                    System.out.println(nodeName);
                    queue.poll();
                    final LinkedList<GraphNode> jump = Arrays.stream(graph.getGraphNodesList()).filter(input -> {
                        return input.peek().getName().equalsIgnoreCase(nodeName);
                    }).findFirst().get();
                    for (final GraphNode adjacentNode : jump) {
                        adjacentNode.setInDegree(adjacentNode.getInDegree() - 1);
                        if (adjacentNode.getInDegree() == 0) {
                            queue.add(adjacentNode);
                        }
                    }
                }
            }
        }
    }
}

class Graph implements Cloneable {

    private int verticesCount;
    private LinkedList<GraphNode>[] graphNodesList;
    private int vertexCount;
    private Collection<Edge> edges;

    @SuppressWarnings("unchecked")
    public Graph(final int totalVertices) {
        this.verticesCount = totalVertices;
        this.vertexCount = 0;
        this.graphNodesList = new LinkedList[totalVertices];
        for (int i = 0; i < verticesCount; i++) {
            this.graphNodesList[i] = new LinkedList<>();
        }
        this.edges = new ArrayList<>(2 * verticesCount);
    }

    public void addVertex(final GraphNode graphNode) {
        this.graphNodesList[vertexCount++].add(graphNode);
    }

    public void addEdge(final GraphNode source, final GraphNode destination) {
        final GraphNode storedDestination = getNodeFromList(destination);
        storedDestination.setInDegree(storedDestination.getInDegree() + 1);
        Arrays.stream(this.graphNodesList).filter(input -> {
            return input.peek().getName().equalsIgnoreCase(source.getName());
        }).findFirst().get().add(storedDestination);
    }

    public void addEdge(final String source, final String destination, final int weight) {
        final Edge edge = new Edge(source, destination, weight);
        if (!this.edges.contains(edge)) {
            this.edges.add(edge);
            addEdge(new GraphNode(source), new GraphNode(destination));
        }
    }

    public int getVerticesCount() {
        return verticesCount;
    }

    public void setVerticesCount(final int verticesCount) {
        this.verticesCount = verticesCount;
    }

    public LinkedList<GraphNode>[] getGraphNodesList() {
        return graphNodesList;
    }

    public void setGraphNodesList(final LinkedList<GraphNode>[] graphNodes) {
        this.graphNodesList = graphNodes;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(final int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public Collection<Edge> getEdges() {
        return edges;
    }

    public void setEdges(final Collection<Edge> edges) {
        this.edges = edges;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(graphNodesList);
        result = prime * result + verticesCount;
        result = prime * result + vertexCount;
        result = prime * result + edges.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final Graph that = (Graph) obj;
        if (this.graphNodesList == null) {
            if (that.graphNodesList != null)
                return false;
        } else if (!this.graphNodesList.equals(that.graphNodesList))
            return false;
        if (this.verticesCount != that.verticesCount)
            return false;
        if (this.vertexCount != that.vertexCount)
            return false;
        if (this.edges != that.edges)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("verticesCount", this.verticesCount)
                .add("graphNodesList", this.graphNodesList).add("vertexCount", this.vertexCount)
                .add("edges", this.edges).toString();
    }

    private GraphNode getNodeFromList(final GraphNode graphNode) {
        return Arrays.stream(this.graphNodesList).filter(input -> {
            return input.peek().getName().equalsIgnoreCase(graphNode.getName());
        }).findFirst().get().getFirst();
    }
}

class GraphNode {

    private String name;
    private int inDegree;

    public GraphNode(final String name) {
        this.name = name;
        this.inDegree = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(final int inDegree) {
        this.inDegree = inDegree;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.inDegree);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final GraphNode that = (GraphNode) obj;
        return Objects.equals(this.name, that.name);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("name", this.name).add("inDegree", this.inDegree).toString();
    }

}
