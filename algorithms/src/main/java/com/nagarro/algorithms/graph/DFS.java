package com.nagarro.algorithms.graph;

import java.util.Arrays;
import java.util.Stack;

import com.google.common.base.MoreObjects;

public final class DFS {

    private int vertexCount;
    private int maxVertices;
    private Vertex[] vertexList;
    private int[][] adjMatrix;
    private Stack<Integer> stack;

    public DFS(final int maxVertices) {
        this.vertexCount = 0;
        this.maxVertices = maxVertices;
        this.vertexList = new Vertex[maxVertices];
        this.adjMatrix = new int[maxVertices][maxVertices];
        this.stack = new Stack<>();
    }

    public void addVertex(final char label) {
        this.vertexList[vertexCount++] = new Vertex(label);
    }

    public void addEdge(final int source, final int destination) {
        if (source >= 0 && source <= vertexCount && destination >= 0 && destination <= vertexCount) {
            adjMatrix[source][destination] = 1;
            adjMatrix[destination][source] = 1;
        }
    }

    public void dfs() {
        vertexList[0].setVisited(true);
        display(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            final int position = getAdjUnvisitedVertex(stack.peek());
            if (-1 == position) {
                stack.pop();
            } else {
                vertexList[position].setVisited(true);
                display(position);
                stack.push(position);
            }
        }
        for (int i = 0; i < maxVertices; i++) {
            vertexList[i].setVisited(false);
        }
    }

    private int getAdjUnvisitedVertex(final int position) {
        for (int i = 0; i < maxVertices; i++) {
            if (adjMatrix[position][i] == 1 && !vertexList[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }

    private void display(final int position) {
        System.out.println(vertexList[position].getLabel());
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(final int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public int getMaxVertices() {
        return maxVertices;
    }

    public void setMaxVertices(final int vertices) {
        this.maxVertices = vertices;
    }

    public Vertex[] getVertexList() {
        return this.vertexList;
    }

    public void setVertexList(final Vertex[] vertexList) {
        this.vertexList = vertexList;
    }

    public int[][] getAdjMatrix() {
        return this.adjMatrix;
    }

    public void setAdjMatrix(final int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public Stack<Integer> getStack() {
        return this.stack;
    }

    public void setStack(final Stack<Integer> stack) {
        this.stack = stack;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("vertexCount", this.vertexCount)
                .add("maxVertices", this.maxVertices).add("vertexList", Arrays.asList(this.vertexList))
                .add("adjMatrix", Arrays.asList(this.adjMatrix)).add("stack", this.stack).toString();
    }

}

class Vertex {

    private char label;
    private boolean isVisited;

    public Vertex(final char label) {
        this.label = label;
        this.isVisited = false;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(final char label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(final boolean isVisited) {
        this.isVisited = isVisited;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("label", this.label).add("isVisited", this.isVisited).toString();
    }

}
