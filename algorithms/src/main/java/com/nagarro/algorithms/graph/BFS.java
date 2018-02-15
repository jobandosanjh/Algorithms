package com.nagarro.algorithms.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import com.google.common.base.MoreObjects;

public class BFS {

    private int maxVertices;
    private int verticesCount;
    private int[][] adjMatrix;
    private Vertex[] vertexList;
    private Queue<Integer> queue;

    public BFS(final int maxVertices) {
        this.maxVertices = maxVertices;
        this.verticesCount = 0;
        this.adjMatrix = new int[maxVertices][maxVertices];
        this.vertexList = new Vertex[maxVertices];
        this.queue = new ArrayDeque<>();
    }

    public void addVertex(final char label) {
        this.vertexList[verticesCount++] = new Vertex(label);
    }

    public void addEdge(final int source, final int destination) {
        if (source >= 0 && source <= verticesCount && destination >= 0 && destination <= verticesCount) {
            adjMatrix[source][destination] = 1;
            adjMatrix[destination][source] = 1;
        }
    }

    public void bfs() {
        vertexList[0].setVisited(true);
        displayVertex(0);
        queue.add(0);
        while (!queue.isEmpty()) {
            int positionQueue = queue.poll();
            int position = positionQueue;
            while (-1 != position) {
                position = getAdjUnvisitedVertex(positionQueue);
                if (-1 != position) {
                    vertexList[position].setVisited(true);
                    displayVertex(position);
                    queue.add(position);
                }
            }
        }
        for (int i = 0; i < maxVertices; i++) {
            vertexList[i].setVisited(false);
        }
    }

    public int getMaxVertices() {
        return maxVertices;
    }

    public void setMaxVertices(final int maxVertices) {
        this.maxVertices = maxVertices;
    }

    public int getVerticesCount() {
        return verticesCount;
    }

    public void setVerticesCount(final int verticesCount) {
        this.verticesCount = verticesCount;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(final int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public Vertex[] getVertexList() {
        return vertexList;
    }

    public void setVertexList(final Vertex[] vertexList) {
        this.vertexList = vertexList;
    }

    public Queue<Integer> getQueue() {
        return queue;
    }

    public void setQueue(final Queue<Integer> queue) {
        this.queue = queue;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("maxVertices", this.maxVertices)
                .add("verticesCount", this.verticesCount).add("adjMatrix", Arrays.asList(this.adjMatrix))
                .add("vertexList", Arrays.asList(this.vertexList)).add("queue", this.queue).toString();
    }

    private void displayVertex(final int position) {
        System.out.println(vertexList[position].getLabel());
    }

    private int getAdjUnvisitedVertex(final int position) {
        for (int i = 0; i < maxVertices; i++) {
            if (adjMatrix[position][i] == 1 && !vertexList[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }
}
